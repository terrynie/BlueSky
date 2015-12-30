package com.bluesky.bean;

public class WeChat {
	private String id;// 投诉编号
	private String weChatNo;// 微信号
	private String district;// 区
	private String street;// 街道
	private String constructionId;// 工地编号
	private String content;// 投诉内容
	private int hasImg;// 是否有图片
	private int hasVideo;// 是否有视频
	private int status;// 状态判断（是否处理，是否属实）
	
	/*
	 * field:status
	 * 0:未处理(waiting dealed)
	 * 1:管理员审核通过(passed)
	 * 2:管理员审核未通过(not passed)
	 * 
	 */

	public WeChat() {
	}

	public void setHasImg(int hasImg) {
		this.hasImg = hasImg;
	}

	public void setHasVideo(int hasVideo) {
		this.hasVideo = hasVideo;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getHasImg() {
		return hasImg;
	}

	public int getHasVideo() {
		return hasVideo;
	}

}
