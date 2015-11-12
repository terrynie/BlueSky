package com.bluesky.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.bean.Images;
import com.bluesky.database.DBConnection;

public class ImagesDao {
	// add an image
	public boolean addImage(Images image) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "insert into Images values('" + image.getImgId() + "','" + image.getWeChatId() + "','"
					+ image.getImgPath() + "';";
			stmt.execute(sql);
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "delete from Images where ID='" + image.getImgId() + "';";
			stmt.execute(sql);
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from Images";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Images image = new Images();
				image.setImgId(rs.getString(1));
				image.setWeChatId(rs.getString(2));
				image.setImgPath(rs.getString(3));
				list.add(image);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query one image
	public Images queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		Images image = new Images();
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from Images where id = '" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				image.setImgId(rs.getString(1));
				image.setWeChatId(rs.getString(2));
				image.setImgPath(rs.getString(3));
			}
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from Images limit " + start + "," + stepLength + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Images image = new Images();
				image.setImgId(rs.getString(1));
				image.setWeChatId(rs.getString(2));
				image.setImgPath(rs.getString(3));
				list.add(image);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query numbers of images
	public int qureyNumOfImages() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from Images";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

}
