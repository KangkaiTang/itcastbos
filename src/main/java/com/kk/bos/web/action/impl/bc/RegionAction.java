package com.kk.bos.web.action.impl.bc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.criterion.DetachedCriteria;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.Region;
import com.kk.bos.utils.PinYin4jUtils;
import com.kk.bos.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class RegionAction extends BaseAction implements ModelDriven<Region> {

	private Region region = new Region();
	//获得上传文件
	private File regionBatch;
	
	//日志文件
	private static final Logger LOG = Logger.getLogger(Region.class);
		
	@Override
	public Region getModel() {
		// TODO Auto-generated method stub
		return region;
	}
	
	public void setRegionBatch(File regionBatch) {
		this.regionBatch = regionBatch;
	}
	
	public String ajaxlist() throws Exception {
		List<Region> lst = regionService.listAllRegions();
		ActionContext.getContext().put("lst", lst);
		return "ajaxlistSuccess";
	}
	
	public String listRegions() throws Exception {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Region.class);
		Page myPage = initPage(detachedCriteria);
		Page returnPage = regionService.pageQuery(myPage);
		ActionContext.getContext().put("returnPage", returnPage);
		return "listRegionsSuccess";
	}


	public String uploadXls() throws FileNotFoundException, IOException  {
		System.out.println(regionBatch.getName());
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(regionBatch));
		//避免空指针异常
		workbook.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);
		HSSFSheet sheet =  workbook.getSheetAt(0);
		for (Row row : sheet) {
			if(row.getRowNum()==0) {
				continue;
			}
			//抽取到Region的bean中
			Region r = new Region();
			String regionId = row.getCell(0).getStringCellValue();
			if("".equals(regionId.trim()) || regionService.findRegionById(regionId) !=null) {
				continue;
			} else {
				r.setId(regionId);
			}
			r.setProvince(row.getCell(1).getStringCellValue());
			r.setCity(row.getCell(2).getStringCellValue());
			r.setDistrict(row.getCell(3).getStringCellValue());
			r.setPostcode(row.getCell(4).getStringCellValue());
			
//			r.setShortcode(row.getCell(5).getStringCellValue());
//			r.setCitycode(row.getCell(6).getStringCellValue());
			
			//用拼音jar注入
			r.setShortcode(PinYin4jUtils.getHeader(r.getProvince())+PinYin4jUtils.getHeader(r.getCity()) + PinYin4jUtils.getHeader(r.getDistrict()));
			r.setCitycode(PinYin4jUtils.getNamePinyin(r.getProvince()));
			System.out.println(r.getId() + " " +r.getCity() + " " +r.getCitycode() + " " +r.getShortcode());
			//存入到数据库中
			try {
				System.out.println("===save region ===");
				regionService.saveOrUpdate(r);	
			} catch(Exception e) {
				LOG.error("导入异常：" + region.getId(), e);
			}
		}
		
		
		//返回Json数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("msg", "successfully import the batch file");
		ActionContext.getContext().put("map", map);
		
		return "uploadXlsSuccess";
	}

}
