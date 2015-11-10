package com.bluedsky.bean;

import java.lang.reflect.Array;
import java.util.Date;

public class Notification {
	private String id; // ����֪ͨ���
	private String title; // ���ı���
	private String content; // ��������
	private String publishDept; // ��������
	private String accordingTo; // ��������
	private boolean hasPhotos; // �ٱ������Ƿ���ͼƬ
	private boolean hasVedio; // �ٱ������Ƿ�����Ƶ
	private boolean hasText; // �ٱ������Ƿ�������
	private Array photos; // �洢ͼƬ
	private Array vedio; // �洢��Ƶ
	private Array text; // �洢����
	private Date publishDate; // ����ʱ��
	private Date deadline; // ���Ľ�ֹ����
	private boolean isFeedback; // �Ƿ���
	private String constructionName; // ��������
	private String feedbackId; // �������
	
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

	public boolean isHasPhotos() {
		return hasPhotos;
	}

	public void setHasPhotos(boolean hasPhotos) {
		this.hasPhotos = hasPhotos;
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

	public Array getPhotos() {
		return photos;
	}

	public void setPhotos(Array photos) {
		this.photos = photos;
	}

	public Array getVedio() {
		return vedio;
	}

	public void setVedio(Array vedio) {
		this.vedio = vedio;
	}

	public Array getText() {
		return text;
	}

	public void setText(Array text) {
		this.text = text;
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
