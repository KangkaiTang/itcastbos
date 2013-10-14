package com.kk.bos.web.action.impl.bc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.kk.bos.domain.Page;
import com.kk.bos.domain.bc.Region;
import com.kk.bos.domain.bc.Subarea;
import com.kk.bos.utils.FileUtils;
import com.kk.bos.web.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class SubAreaAction extends BaseAction implements ModelDriven<Subarea> {

	Subarea subarea = new Subarea();

	@Override
	public Subarea getModel() {
		// TODO Auto-generated method stub
		return subarea;
	}

	public String saveOrUpdate() throws Exception {

		subareaService.saveOrUpdate(subarea);
		return "saveOrUpdateSuccess";
	}

	public InputStream getInputStream() throws Exception {
		List<Subarea> subareas = ((Page) ServletActionContext.getRequest()
				.getSession().getAttribute("returnPage")).getRows();
		// 创建一个workbook
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("分区信息");
		//头信息
		Row headRow = sheet.createRow(0);
		headRow.createCell(0).setCellValue("分区编号");
		headRow.createCell(1).setCellValue("关键字");
		headRow.createCell(2).setCellValue("起始号");
		headRow.createCell(3).setCellValue("结束号");
		headRow.createCell(4).setCellValue("是否区分单双号");
		headRow.createCell(5).setCellValue("位置信息");
		
		int sheetRow = 0;
		for(Subarea subarea : subareas ) {
			Row subRow = sheet.createRow(++sheetRow);
			subRow.createCell(0).setCellValue(subarea.getId());
			subRow.createCell(1).setCellValue(subarea.getAddresskey());
			subRow.createCell(2).setCellValue(subarea.getStartnum());
			subRow.createCell(3).setCellValue(subarea.getEndnum());
			subRow.createCell(4).setCellValue(subarea.getSingle());
			subRow.createCell(5).setCellValue(subarea.getPosition());
		}
		
		
		//将excel写入流
		ByteArrayOutputStream outPutStream = new ByteArrayOutputStream();
		workbook.write(outPutStream);
		outPutStream.close();
		
		byte[] excelData = outPutStream.toByteArray();
		
		return new ByteArrayInputStream(excelData);
	}

	public String exportXls() throws Exception {
		
		String agent = ServletActionContext.getRequest().getHeader("user-agent");
		String downloadFileName = FileUtils.encodeDownloadFilename("分区数据.xls", agent);
		ActionContext.getContext().put("downloadFileName", downloadFileName);
		
		return "exportXlsSuccess";
	}

	public String conditionQuery() throws Exception {

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Subarea.class);
		// 注入条件
		if (subarea.getAddresskey() != null
				&& subarea.getAddresskey().trim().length() > 0) {
			detachedCriteria.add(Restrictions.like("addresskey",
					"%" + subarea.getAddresskey() + "%"));
		}

		if (subarea.getDecideZone() != null
				&& subarea.getDecideZone().getId() != null
				&& subarea.getDecideZone().getId().trim().length() > 0) {
			detachedCriteria.add(Restrictions.eq("decidedZone",
					subarea.getDecideZone()));
		}

		Region subAreaRegion = subarea.getRegion();
		if (subAreaRegion != null) {
			// 此处多表关联，一定要建立别名
			detachedCriteria.createAlias("region", "r");
			if (subAreaRegion.getProvince() != null
					&& subAreaRegion.getProvince().trim().length() > 0) {
				detachedCriteria.add(Restrictions.like("r.province", "%"
						+ subAreaRegion.getProvince() + "%"));
			}
			if (subAreaRegion.getCity() != null
					&& subAreaRegion.getCity().trim().length() > 0) {
				detachedCriteria.add(Restrictions.like("r.city", "%"
						+ subAreaRegion.getCity() + "%"));
			}
			if (subAreaRegion.getDistrict() != null
					&& subAreaRegion.getDistrict().trim().length() > 0) {
				detachedCriteria.add(Restrictions.like("r.district", "%"
						+ subAreaRegion.getDistrict() + "%"));
			}
		}

		Page myPage = initPage(detachedCriteria);
		Page returnPage = subareaService.pageQuery(myPage);
		ActionContext.getContext().put("returnPage", returnPage);
		ServletActionContext.getRequest().getSession()
				.setAttribute("returnPage", returnPage);
		return "conditionQuerySuccess";
	}

}
