package com.bluesky.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.bluesky.bean.WeChat;
import com.bluesky.database.DBConnection;
import com.bluesky.tools.TimeConvert;

public class WeChatDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// add customer_complaints
	public boolean addOneComplaint(WeChat customerComplaint) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "insert into CustomerComplaint values(?,?,?,?,?,?,?,?,?,?,?)";
			ps = DBConnection.conn.prepareStatement(sql);

			ps.setString(1, customerComplaint.getId());
			ps.setString(2, customerComplaint.getWeChatNo());
			ps.setString(3, customerComplaint.getDistrict());
			ps.setString(4, customerComplaint.getStreet());
			ps.setString(5, customerComplaint.getConstructionId());
			ps.setString(6, customerComplaint.getContent());
			ps.setInt(7, customerComplaint.getHasImg());
			ps.setInt(8, customerComplaint.getHasVideo());
			ps.setInt(9, customerComplaint.getStatus());
			ps.setDate(10, TimeConvert.ConvertToSqlDate(customerComplaint.getComplainTime()));
			ps.setDate(11, TimeConvert.ConvertToSqlDate(customerComplaint.getDealedTime()));
			
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete a customer_complaint
	public boolean delOneComplaint(WeChat customerComplaint) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "delete from CustomerComplaint where id=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, customerComplaint.getId());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// query all customer_complaints
	public LinkedList<WeChat> queryNumbers() {
		LinkedList<WeChat> list = new LinkedList<WeChat>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from CustomerComplaint";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
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
				customerComplaint.setStatus(rs.getInt(9));
				customerComplaint.setComplainTime(rs.getDate(10));
				customerComplaint.setDealedTime(rs.getDate(11));
				list.add(customerComplaint);
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

	// query one customer_complaint
	public WeChat queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		WeChat customerComplaint = new WeChat();
		try {
			String sql = "select * from Admin where id = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, customerComplaint.getId());
			rs = ps.executeQuery(sql);
			while (rs.next()) {
				customerComplaint.setId(rs.getString(1));
				customerComplaint.setWeChatNo(rs.getString(2));
				customerComplaint.setDistrict(rs.getString(3));
				customerComplaint.setDistrict(rs.getString(4));
				customerComplaint.setConstructionId(rs.getString(5));
				customerComplaint.setContent(rs.getString(6));
				customerComplaint.setHasImg(rs.getInt(7));
				customerComplaint.setHasVideo(rs.getInt(8));
				customerComplaint.setStatus(rs.getInt(9));
				customerComplaint.setComplainTime(rs.getDate(10));
				customerComplaint.setDealedTime(rs.getDate(11));
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
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
			String sql = "select * from CustomerComplaint limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, stepLength);
			ResultSet rs = ps.executeQuery();

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
				customerComplaint.setStatus(rs.getInt(9));
				customerComplaint.setComplainTime(rs.getDate(10));
				customerComplaint.setDealedTime(rs.getDate(11));
				list.add(customerComplaint);
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

	// query numbers of customer complaints
	public int qureyNumOfComplaints() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from CustomerComplaint";
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

	// query numbers of customer complaints
	public int queryNumOfComplaintsByStatus(int status) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from CustomerComplaint where Status=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, status);
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

	/*
	 * query customer complaints according to status by given page 
	 * 
	 * if 0, then "wait dealed" 
	 * if 1, then "dealed and passed" 
	 * if 2, then "dealed but not passed"
	 * 
	 */

	public LinkedList<WeChat> queryComplaintsByStatus(int status, int start, int stepLength) {
		LinkedList<WeChat> list = new LinkedList<WeChat>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = null;
			if (status == 0) {
				sql = "select * from CustomerComplaint where status=0 limit ?,?";
			} else if (status == 1) {
				sql = "select * from CustomerComplaint where status=1 limit ?,?";
			} else if (status == 2) {
				sql = "select * from CustomerComplaint where status=2 limit ?,?";
			}
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, stepLength);

			rs = ps.executeQuery();
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
				customerComplaint.setStatus(rs.getInt(9));
				customerComplaint.setComplainTime(rs.getDate(10));
				customerComplaint.setDealedTime(rs.getDate(11));
				list.add(customerComplaint);
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
	/**
	 * update status by id 
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateStatusById(String id, int status) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int num = 0;
		try {
			String sql = "update CustomerComplaint set status=? where id=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setString(2, id);

			num = ps.executeUpdate();
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
