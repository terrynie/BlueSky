package com.bluesky.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.bluesky.bean.Notification;
import com.bluesky.database.DBConnection;

public class NotificationDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	// add an notification
	public boolean addNotification(Notification notification) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "insert into CorrectionNotification values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, notification.getId());
			ps.setString(2, notification.getTitle());
			ps.setString(3, notification.getContent());
			ps.setString(4, notification.getPublishDept());
			ps.setString(5, notification.getAccordingTo());
			ps.setInt(6, notification.getHasImgs());
			ps.setInt(7, notification.getHasVedio());
			ps.setInt(8, notification.getHasText());
			ps.setString(9, notification.getImgPath());
			ps.setString(10, notification.getVideoPath());
			ps.setDate(11, notification.getPublishDate());
			ps.setDate(12, notification.getDeadline());
			ps.setInt(13, notification.getIsFeedback());
			ps.setString(14, notification.getConstructionName());
			ps.setString(15, notification.getFeedbackId());
			ps.setInt(16, notification.getStatus());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
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
			String sql = "delete from CorrectionNotification where ID=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, notification.getId());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
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
			String sql = "select * from CorrectionNotification";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
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
				notification.setIsFeedback(rs.getInt(13));
				notification.setConstructionName(rs.getString(14));
				notification.setFeedbackId(rs.getString(15));
				notification.setStatus(rs.getInt(16));
				list.add(notification);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query one notification according to id
	public Notification queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		Notification notification = new Notification();
		try {
			String sql = "select * from CorrectionNotification where id =?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				notification.setId(rs.getString(1));
				notification.setTitle(rs.getString(2));
				notification.setContent(rs.getString(3));
				notification.setPublishDept(rs.getString(4));
				notification.setAccordingTo(rs.getString(5));
				notification.setHasImgs(rs.getInt(6));
				notification.setHasVedio(rs.getInt(7));
				notification.setHasText(rs.getInt(8));
				notification.setPublishDate(rs.getDate(11));
				notification.setDeadline(rs.getDate(12));
				notification.setIsFeedback(rs.getInt(13));
				notification.setConstructionName(rs.getString(14));
				notification.setFeedbackId(rs.getString(15));
				notification.setStatus(rs.getInt(16));
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
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
			String sql = "select * from CorrectionNotification limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, stepLength);
			rs = ps.executeQuery();
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
				notification.setPublishDate(rs.getDate(11));
				notification.setDeadline(rs.getDate(12));
				notification.setIsFeedback(rs.getInt(13));
				notification.setConstructionName(rs.getString(14));
				notification.setFeedbackId(rs.getString(15));
				notification.setStatus(rs.getInt(16));
				list.add(notification);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query numbers of notifications
	public int qureyNumOfNotifications() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from CorrectionNotification";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				sum = rs.getInt(1);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return sum;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// query id according to construction site id
	public String queryConSiteIdById(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select consiteid from CorrectionNotification where id = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getString(1);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
