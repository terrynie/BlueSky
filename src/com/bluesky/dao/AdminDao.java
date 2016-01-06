package com.bluesky.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.bluesky.bean.Admin;
import com.bluesky.database.DBConnection;
import com.bluesky.tools.TimeConvert;

public class AdminDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	// add an administrator
	public boolean addAdmin(Admin admin) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "insert into Admin values(?,?,?,?,?,?,?)";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, admin.getId());
			ps.setString(2, admin.getPassword());
			ps.setString(3, admin.getName());
			ps.setString(4, admin.getTel());
			ps.setString(5, admin.getIdCardNo());
			ps.setDate(6, TimeConvert.ConvertToSqlDate(admin.getRegisterDate()));
			ps.setDate(7, TimeConvert.ConvertToSqlDate(admin.getLogoffTime()));
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete an administrator
	public boolean delAdmin(Admin admin) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "delete from Admin where ID=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, admin.getId());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// query all administrators
	public LinkedList<Admin> queryAdmins() {
		LinkedList<Admin> list = new LinkedList<Admin>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from Admin";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getString(1));
				admin.setPassword(rs.getString(2));
				admin.setName(rs.getString(3));
				admin.setTel(rs.getString(4));
				admin.setIdCardNo(rs.getString(5));
				admin.setRegisterDate((java.util.Date)rs.getDate(6));
				admin.setLogoffTime((java.util.Date)rs.getDate(7));
				list.add(admin);
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

	// query one administrator
	public Admin queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		Admin admin = new Admin();
		try {
			String sql = "select * from Admin where id = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				admin.setId(rs.getString(1));
				admin.setPassword(rs.getString(2));
				admin.setName(rs.getString(3));
				admin.setTel(rs.getString(4));
				admin.setIdCardNo(rs.getString(5));
				admin.setRegisterDate(rs.getDate(6));
				admin.setLogoffTime(rs.getDate(7));
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query admin counts by given number
	public LinkedList<Admin> queryByPage(int start, int stepLength) {
		LinkedList<Admin> list = new LinkedList<Admin>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from Admin limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, stepLength);
			rs = ps.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getString(1));
				admin.setPassword(rs.getString(2));
				admin.setName(rs.getString(3));
				admin.setTel(rs.getString(4));
				admin.setIdCardNo(rs.getString(5));
				admin.setRegisterDate(rs.getDate(6));
				admin.setLogoffTime(rs.getDate(7));
				list.add(admin);
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

	// query numbers of administrators
	public int qureyNumOfAdmin() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from Admin";
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
	
	// update admin info
	public int updateAdmin(Admin admin) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int num = 0;
		String sql = "update admin set password=?,name=?,tel=?,idcardno=? where id=?";
		try {
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, admin.getPassword());
			ps.setString(2, admin.getName());
			ps.setString(3, admin.getTel());
			ps.setString(4, admin.getIdCardNo());
			ps.setString(5, admin.getId());
			num = ps.executeUpdate();
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// update password
	public int updatePasswd(String id, String passwd) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int num = 0;
		String sql = "update admin set password=? where id=?";
		try {
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, passwd);
			ps.setString(2, id);
			num = ps.executeUpdate();
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}