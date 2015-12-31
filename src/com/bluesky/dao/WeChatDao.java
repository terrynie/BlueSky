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
					+ customerComplaint.getContent() + "'," + customerComplaint.isHasImg() + ","
					+ customerComplaint.isHasVideo() + "," + customerComplaint.getStatus() + ");";
			stmt.executeUpdate(sql);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
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
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
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
				customerComplaint.setHasImg(rs.getBoolean(7));
				customerComplaint.setHasVideo(rs.getBoolean(8));
				customerComplaint.setStatus(rs.getInt(9));
				list.add(customerComplaint);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
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
				customerComplaint.setHasImg(rs.getBoolean(7));
				customerComplaint.setHasVideo(rs.getBoolean(8));
				customerComplaint.setStatus(rs.getInt(9));
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
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
				customerComplaint.setHasImg(rs.getBoolean(7));
				customerComplaint.setHasVideo(rs.getBoolean(8));
				customerComplaint.setStatus(rs.getInt(9));
				list.add(customerComplaint);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
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
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
	
	// query numbers of customer complaints
	public int queryNumOfComplaintsByStatus(int status){
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from CustomerComplaint where Status=" + status;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sum = rs.getInt(1);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	/*
	 * query customer complaints according to status
	 * 
	 * the value of "status"(default:0)
	 * 
	 * if 0, then "wait dealed"
	 * if 1, then "dealed and passed"
	 * if 2, then "dealed but not passed"
	 * 
	 */
	
	public LinkedList<WeChat> queryComplaintsByStatus(int status){
		LinkedList<WeChat> list = new LinkedList<WeChat>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from CustomerComplaint where status=0";
			if (status == 1) {
				sql = "select * from CustomerComplaint where status=1";
			} else if (status == 2) {
				sql = "select * from CustomerComplaint where status=2";
			}
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				WeChat customerComplaint = new WeChat();
				customerComplaint.setId(rs.getString(1));
				customerComplaint.setWeChatNo(rs.getString(2));
				customerComplaint.setDistrict(rs.getString(3));
				customerComplaint.setStreet(rs.getString(4));
				customerComplaint.setConstructionId(rs.getString(5));
				customerComplaint.setContent(rs.getString(6));
				customerComplaint.setHasImg(rs.getBoolean(7));
				customerComplaint.setHasVideo(rs.getBoolean(8));
				customerComplaint.setStatus(rs.getInt(9));
				list.add(customerComplaint);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}
	
}
