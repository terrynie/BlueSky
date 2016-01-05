package com.bluesky.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.bluesky.bean.WeChatImages;
import com.bluesky.database.DBConnection;

public class WeChatImagesDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	// add an image
	public boolean addImage(WeChatImages image) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "insert into wechatimages values(?,?,?)";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, image.getImgId());
			ps.setString(2, image.getComplaintId());
			ps.setString(3, image.getImgPath());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete an image
	public boolean delImages(WeChatImages image) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "delete from wechatimages where ID=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, image.getImgId());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// query all images
	public LinkedList<WeChatImages> queryAllImagess() {
		LinkedList<WeChatImages> list = new LinkedList<WeChatImages>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from wechatimages";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				WeChatImages image = new WeChatImages();
				image.setImgId(rs.getString(1));
				image.setComplaintId(rs.getString(2));
				image.setImgPath(rs.getString(3));
				list.add(image);
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

	// query images according to complaintId 
	public LinkedList<WeChatImages> queryImages(String complaintId) {
		LinkedList<WeChatImages> list = new LinkedList<WeChatImages>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		WeChatImages image = new WeChatImages();
		try {
			String sql = "select * from wechatimages where ComplaintId = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, complaintId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				image.setImgId(rs.getString(1));
				image.setComplaintId(rs.getString(2));
				image.setImgPath(rs.getString(3));
				list.add(image);
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

	// query image counts by given number
	public LinkedList<WeChatImages> queryByPage(int start, int stepLength) {
		LinkedList<WeChatImages> list = new LinkedList<WeChatImages>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from wechatimages limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, stepLength);
			rs = ps.executeQuery();
			while (rs.next()) {
				WeChatImages image = new WeChatImages();
				image.setImgId(rs.getString(1));
				image.setComplaintId(rs.getString(2));
				image.setImgPath(rs.getString(3));
				list.add(image);
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

	// query numbers of images
	public int qureyNumOfImages() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from wechatimages";
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

}
