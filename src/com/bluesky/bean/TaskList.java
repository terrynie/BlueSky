package com.bluesky.bean;

public class TaskList {
	private String id;// 业务编号
	private String source;// 来源
	private String content;// 内容
	private int hasContent;// 是否有文字
	private int hasImg;// 是否有图片
	private int hasVideo;// 是否有视频
	private int isDone;// 是否已经处理

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int isHasContent() {
		return hasContent;
	}

	public void setHasContent(int hasContent) {
		this.hasContent = hasContent;
	}

	public int isHasImg() {
		return hasImg;
	}

	public void setHasImg(int hasImg) {
		this.hasImg = hasImg;
	}

	public int isHasVideo() {
		return hasVideo;
	}

	public void setHasVideo(int hasVideo) {
		this.hasVideo = hasVideo;
	}

	public int isDone() {
		return isDone;
	}

	public void setDone(int isDone) {
		this.isDone = isDone;
	}

}
