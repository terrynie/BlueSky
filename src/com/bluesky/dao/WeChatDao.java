package com.bluesky.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.bean.WeChat;
import com.bluesky.database.DBConnection;

public class WeChatDao {

	// add customer_complaints
	public boolean addManager(WeChat customerComplaint) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "insert into CustomerComplaint values('" + customerComplaint.getId() + "','"
					+ customerComplaint.getWeChatNo() + "','" + customerComplaint.getDistrict() + "','"
					+ customerComplaint.getStreet() + "','" + customerComplaint.getConstructionId() + "','"
					+ customerComplaint.getContent() + "','" + customerComplaint.isHasImg() + "','"
					+ customerComplaint.isHasVideo() + "');";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete a customer_complaint
	public boolean delManager(WeChat customerComplaint) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "delete from CustomerComplaint where id='" + customerComplaint.getId() + "';";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// query all customer_complaints
	public LinkedList<WeChat> queryManagers() {
		LinkedList<WeChat> list = new LinkedList<WeChat>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from CustomerComplaint";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				WeChat customerComplaint = new WeChat();
				customerComplaint.setId(rs.getString(1));
				customerComplaint.setWeChatNo(rs.getString(2));
				customerComplaint.setDistrict(rs.getString(3));
				customerComplaint.setStreet(rs.getString(4));
				customerComplaint.setConstructionId(rs.getString(5));
				customerComplaint.setContent(rs.getString(6));
				customerComplaint.setHasImg(rs.getInt(7));
				customerComplaint.setHasVideo(rs.getInt(8));
				list.add(customerComplaint);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query one customer_complaint
	public WeChat queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		WeChat customerComplaint = new WeChat();
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from Admin where id = '" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				customerComplaint.setId(rs.getString(1));
				customerComplaint.setWeChatNo(rs.getString(2));
				customerComplaint.setDistrict(rs.getString(3));
				customerComplaint.setDistrict(rs.getString(4));
				customerComplaint.setConstructionId(rs.getString(5));
				customerComplaint.setContent(rs.getString(6));
				customerComplaint.setHasImg(rs.getInt(7));
				customerComplaint.setHasVideo(rs.getInt(8));
			}
			return customerComplaint;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query customer complaints by given number
	public LinkedList<WeChat> queryByPage(int start, int stepLength) {
		LinkedList<WeChat> list = new LinkedList<WeChat>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from CustomerComplaint limit " + start + "," + stepLength + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				WeChat customerComplaint = new WeChat();
				customerComplaint.setId(rs.getString(1));
				customerComplaint.setWeChatNo(rs.getString(2));
				customerComplaint.setDistrict(rs.getString(3));
				customerComplaint.setStreet(rs.getString(4));
				customerComplaint.setConstructionId(rs.getString(5));
				customerComplaint.setContent(rs.getString(6));
				customerComplaint.setHasImg(rs.getInt(7));
				customerComplaint.setHasVideo(rs.getInt(8));
				list.add(customerComplaint);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query numbers of customer complaints
	public int qureyNumOfComplaints() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from CustomerComplaint";
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
