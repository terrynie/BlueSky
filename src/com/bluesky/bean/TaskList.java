package com.bluesky.bean;

public class TaskList {
	private String id;// 业务编号
	private String source;// 来源
	private String content;// 内容
	private int hasContent;// 是否有文字
	private int hasImg;// 是否有图片
	private int hasVideo;// 是否有视频
	private int status;// 处理状态
	
	/**
	 * 管理：初始化（initialize -- 0） 处理转下级（dealing -- 1） 处理完成（done -- 3）
	 * 巡检：待办（waitting to be dealed -- 1） 处理转下级（dealing -- 2）  处理完成（done -- 3） 
	 * 执法：待办（waitting to be dealed -- 2）  处理完成（done -- 3）
	 */

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

	public int getHasContent() {
		return hasContent;
	}

	public void setHasContent(int hasContent) {
		this.hasContent = hasContent;
	}

	public int getHasImg() {
		return hasImg;
	}

	public void setHasImg(int hasImg) {
		this.hasImg = hasImg;
	}

	public int getHasVideo() {
		return hasVideo;
	}

	public void setHasVideo(int hasVideo) {
		this.hasVideo = hasVideo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
