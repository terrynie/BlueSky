package com.bluesky.bean;

import java.util.Date;

public class Notification {
	private String id; // 整改通知编号
	private String title; // 整改标题
	private String content; // 整改内容
	private String publishDept; // 发布部门
	private String accordingTo; // 整改依据
	private boolean hasImgs; // 举报内容是否有图片
	private boolean hasVedio; // 举报内容是否有视频
	private boolean hasText; // 举报内容是否有文字
	private String imgPath; // 存储图片路径
	private String videoPath; // 存储视频路径
	private Date publishDate; // 发布时间
	private Date deadline; // 整改截止日期
	private boolean isFeedback; // 是否反馈
	private String constructionName; // 工地名称
	private String feedbackId; // 反馈编号
	
	public Notification() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishDept() {
		return publishDept;
	}

	public void setPublishDept(String publishDept) {
		this.publishDept = publishDept;
	}

	public String getAccordingTo() {
		return accordingTo;
	}

	public void setAccordingTo(String accordingTo) {
		this.accordingTo = accordingTo;
	}

	public boolean isHasImgs() {
		return hasImgs;
	}

	public void setHasImgs(boolean hasImgs) {
		this.hasImgs = hasImgs;
	}

	public boolean isHasVedio() {
		return hasVedio;
	}

	public void setHasVedio(boolean hasVedio) {
		this.hasVedio = hasVedio;
	}

	public boolean isHasText() {
		return hasText;
	}

	public void setHasText(boolean hasText) {
		this.hasText = hasText;
	}

	
	
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public boolean isFeedback() {
		return isFeedback;
	}

	public void setFeedback(boolean isFeedback) {
		this.isFeedback = isFeedback;
	}

	public String getConstructionName() {
		return constructionName;
	}

	public void setConstructionName(String constructionName) {
		this.constructionName = constructionName;
	}

	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
}
