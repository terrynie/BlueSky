package com.bluesky.bean;

public class Videos {
	private String id;//视频编号
	private String complaintId;//投诉编号
	private String videoPath;//视频路径
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	
}
