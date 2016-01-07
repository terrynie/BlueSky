package com.bluesky.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bluesky.bean.TaskImages;
import com.bluesky.database.DBConnection;

public class TaskImageDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	// add an image
	public boolean addImage(TaskImages image) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "insert into taskimages values(?,?,?)";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, image.getImgId());
			ps.setString(2, image.getTaskId());
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
	public boolean delImages(TaskImages image) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "delete from taskimages where ID=?";
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
	public ArrayList<TaskImages> queryAllImagess() {
		ArrayList<TaskImages> list = new ArrayList<TaskImages>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from taskimages";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				TaskImages image = new TaskImages();
				image.setImgId(rs.getString(1));
				ps.setString(2, image.getTaskId());
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

	// query images according to TaskID
	public ArrayList<TaskImages> queryImages(String TaskID) {
		ArrayList<TaskImages> list = new ArrayList<TaskImages>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		TaskImages image = new TaskImages();
		try {
			String sql = "select * from taskimages where TaskID = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, TaskID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				image.setImgId(rs.getString(1));
				ps.setString(2, image.getTaskId());
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
	public ArrayList<TaskImages> queryByPage(int start, int stepLength) {
		ArrayList<TaskImages> list = new ArrayList<TaskImages>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from taskimages limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, stepLength);
			rs = ps.executeQuery();
			while (rs.next()) {
				TaskImages image = new TaskImages();
				image.setImgId(rs.getString(1));
				ps.setString(2, image.getTaskId());
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
			String sql = "select count(*) from taskimages";
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
