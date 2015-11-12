package com.bluesky.bean;

public class WeChat {
	private String id;// 投诉编号
	private String weChatNo;// 微信号
	private String district;// 区
	private String street;// 街道
	private String constructionId;// 工地编号
	private String content;// 投诉内容

	public WeChat() {
	}

	public WeChat(String id, String weChatNo, String province, String city, String district, String street,
			String constructionId, String content) {
		super();
		this.id = id;
		this.weChatNo = weChatNo;
		this.district = district;
		this.street = street;
		this.constructionId = constructionId;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWeChatNo() {
		return weChatNo;
	}

	public void setWeChatNo(String weChatNo) {
		this.weChatNo = weChatNo;
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

	public String getConstructionId() {
		return constructionId;
	}

	public void setConstructionId(String constructionId) {
		this.constructionId = constructionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}