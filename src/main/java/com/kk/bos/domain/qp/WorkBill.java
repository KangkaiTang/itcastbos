package com.kk.bos.domain.qp;

import com.kk.bos.domain.bc.Staff;
import java.sql.Timestamp;

/**
 * WorkBill entity. @author MyEclipse Persistence Tools
 */

public class WorkBill implements java.io.Serializable {
	public static final String TYPENEW = "新";
	public static final String TYPEUD = "追";
	public static final String TYPEDEL = "销";
	
	
	public static final String STATENEW = "新单";
	public static final String STATEINFO = "已通知";
	public static final String STATECONF = "已确认";
	public static final String STATEGOT = "已取件";
	public static final String STATEDEL = "销单";
	
	// Fields

	private String id;
	private NoticeBill noticeBill;
	private Staff staff;
	private String type;
	private String pickstate;
	private Timestamp buildtime;
	private Integer attachbilltimes;
	private String remark;

	// Constructors

	/** default constructor */
	public WorkBill() {
	}

	/** minimal constructor */
	public WorkBill(String id, Timestamp buildtime) {
		this.id = id;
		this.buildtime = buildtime;
	}

	/** full constructor */
	public WorkBill(String id, NoticeBill noticeBill, Staff staff, String type,
			String pickstate, Timestamp buildtime, Integer attachbilltimes,
			String remark) {
		this.id = id;
		this.noticeBill = noticeBill;
		this.staff = staff;
		this.type = type;
		this.pickstate = pickstate;
		this.buildtime = buildtime;
		this.attachbilltimes = attachbilltimes;
		this.remark = remark;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public NoticeBill getNoticeBill() {
		return this.noticeBill;
	}

	public void setNoticeBill(NoticeBill noticeBill) {
		this.noticeBill = noticeBill;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPickstate() {
		return this.pickstate;
	}

	public void setPickstate(String pickstate) {
		this.pickstate = pickstate;
	}

	public Timestamp getBuildtime() {
		return this.buildtime;
	}

	public void setBuildtime(Timestamp buildtime) {
		this.buildtime = buildtime;
	}

	public Integer getAttachbilltimes() {
		return this.attachbilltimes;
	}

	public void setAttachbilltimes(Integer attachbilltimes) {
		this.attachbilltimes = attachbilltimes;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}