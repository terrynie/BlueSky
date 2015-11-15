package com.bluesky.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.bean.Notification;
import com.bluesky.database.DBConnection;

public class NotificationDao {
	// add an notification
	public boolean addNotification(Notification notification) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "insert into CorrectionNotification values('" + notification.getId() + "','"
					+ notification.getTitle() + "','" + notification.getContent() + "','"
					+ notification.getPublishDept() + "','" + notification.getAccordingTo() + "','"
					+ notification.isHasImgs() + "','" + notification.isHasVedio() + "','" + notification.isHasText()
					+ "','" + notification.getImgPath() + "','" + notification.getVideoPath() + "','"
					+ notification.getPublishDate() + "','" + notification.getDeadline() + "','"
					+ notification.isFeedback() + "','" + notification.getConstructionName() + "','"
					+ notification.getFeedbackId() + "');";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete an notification
	public boolean delNotification(Notification notification) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "delete from CorrectionNotification where ID='" + notification.getId() + "'";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// query notifications
	public LinkedList<Notification> queryNotifications() {
		LinkedList<Notification> list = new LinkedList<Notification>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from CorrectionNotification";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Notification notification = new Notification();
				notification.setId(rs.getString(1));
				notification.setTitle(rs.getString(2));
				notification.setContent(rs.getString(3));
				notification.setPublishDept(rs.getString(4));
				notification.setAccordingTo(rs.getString(5));
				notification.setHasImgs(rs.getInt(6));
				notification.setHasVedio(rs.getInt(7));
				notification.setHasText(rs.getInt(8));
				notification.setImgPath(rs.getString(9));
				notification.setVideoPath(rs.getString(10));
				notification.setPublishDate(rs.getDate(11));
				notification.setDeadline(rs.getDate(12));
				notification.setFeedback(rs.getInt(13));
				notification.setConstructionName(rs.getString(14));
				notification.setFeedbackId(rs.getString(15));
				list.add(notification);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query one notification according to id
	public Notification queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		Notification notification = new Notification();
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from CorrectionNotification where id = '" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				notification.setId(rs.getString(1));
				notification.setTitle(rs.getString(2));
				notification.setContent(rs.getString(3));
				notification.setPublishDept(rs.getString(4));
				notification.setAccordingTo(rs.getString(5));
				notification.setHasImgs(rs.getInt(6));
				notification.setHasVedio(rs.getInt(7));
				notification.setHasText(rs.getInt(8));
				notification.setPublishDate(rs.getDate(9));
				notification.setDeadline(rs.getDate(10));
				notification.setFeedback(rs.getInt(11));
				notification.setConstructionName(rs.getString(12));
				notification.setFeedbackId(rs.getString(13));
			}
			return notification;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query notifications by given nubmer
	public LinkedList<Notification> queryByPage(int start, int stepLength) {
		LinkedList<Notification> list = new LinkedList<Notification>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from CorrectionNotification limit " + start + "," + stepLength + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Notification notification = new Notification();
				notification.setId(rs.getString(1));
				notification.setTitle(rs.getString(2));
				notification.setContent(rs.getString(3));
				notification.setPublishDept(rs.getString(4));
				notification.setAccordingTo(rs.getString(5));
				notification.setHasImgs(rs.getInt(6));
				notification.setHasVedio(rs.getInt(7));
				notification.setHasText(rs.getInt(8));
				notification.setPublishDate(rs.getDate(9));
				notification.setDeadline(rs.getDate(10));
				notification.setFeedback(rs.getInt(11));
				notification.setConstructionName(rs.getString(12));
				notification.setFeedbackId(rs.getString(13));
				list.add(notification);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query numbers of notifications
	public int qureyNumOfNotifications() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from CorrectionNotification";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
	
	//query id according to construction site id
	public String queryConSiteIdById(String id){
		String conSiteId = null;
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select consiteid from CorrectionNotification where id ='"+id+"';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				id=rs.getString(1);
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return id;
		}
	}
}
