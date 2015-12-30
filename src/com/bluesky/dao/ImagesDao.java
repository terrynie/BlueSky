package com.bluesky.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.bluesky.bean.Images;
import com.bluesky.database.DBConnection;

public class ImagesDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	// add an image
	public boolean addImage(Images image) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "insert into Images values(?,?,?)";
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
	public boolean delImages(Images image) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "delete from Images where ID=?";
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
	public LinkedList<Images> queryImagess() {
		LinkedList<Images> list = new LinkedList<Images>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from Images";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				Images image = new Images();
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

	// query one image
	public Images queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		Images image = new Images();
		try {
			String sql = "select * from Images where id = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				image.setImgId(rs.getString(1));
				image.setComplaintId(rs.getString(2));
				image.setImgPath(rs.getString(3));
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return image;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query image counts by given number
	public LinkedList<Images> queryByPage(int start, int stepLength) {
		LinkedList<Images> list = new LinkedList<Images>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from Images limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, stepLength);
			rs = ps.executeQuery();
			while (rs.next()) {
				Images image = new Images();
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
			String sql = "select count(*) from Images";
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
