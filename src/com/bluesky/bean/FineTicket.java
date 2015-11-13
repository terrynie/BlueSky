package com.bluesky.bean;

import java.util.Date;

public class FineTicket {
	private String id;// 罚单编号
	private String notificationId;// 整改通知编号
	private String conSiteId;// 工地编号
	private String company;// 施工单位
	private double fineMoney;// 罚款金额
	private Date startTime;// 开具日期
	private Date deadLine;// 缴纳期限
	private String who;// 罚单开具人

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}

	public String getConSiteId() {
		return conSiteId;
	}

	public void setConSiteId(String conSiteId) {
		this.conSiteId = conSiteId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getFineMoney() {
		return fineMoney;
	}

	public void setFineMoney(double fineMoney) {
		this.fineMoney = fineMoney;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

}
