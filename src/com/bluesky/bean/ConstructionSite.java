package com.bluesky.bean;

import java.sql.Date;

public class ConstructionSite {
	private String id;//工地编号
	private String projectName;//项目名称
	private String name;//工地名称
	private String directorId;//负责人编号
	private double area;//面积
	private Date startTime;//开始日期
	private Date completeTime;//预计完成日期
	private int totalFloors;//层数
	private String district;//区
	private String street;//街道
	private String company;//所属公司
	private String struct;//结构
	private double price;//价格
	private int totalMonitors;//监控数量
	private String progress;//进度
	private double longitude;//经度
	private double latitude;//纬度
	

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirectorId() {
		return directorId;
	}

	public void setDirectorId(String directorId) {
		this.directorId = directorId;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public int getTotalFloors() {
		return totalFloors;
	}

	public void setTotalFloors(int totalFloors) {
		this.totalFloors = totalFloors;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStruct() {
		return struct;
	}

	public void setStruct(String struct) {
		this.struct = struct;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTotalMonitors() {
		return totalMonitors;
	}

	public void setTotalMonitors(int totalMonitors) {
		this.totalMonitors = totalMonitors;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

}