package com.bluesky.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.bean.Admin;
import com.bluesky.database.DBConnection;
public class AdminDao {
	// add an administrator
	public boolean addAdmin(Admin admin) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "insert into Admin values('" + admin.getId() + "','" + admin.getPassword() + "','"
					+ admin.getName() + "','" + admin.getTel() + "','" + admin.getIdCardNo() + "');";
			stmt.executeUpdate(sql);
			DBConnection.closeStatement(stmt);
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "delete from Admin where ID='" + admin.getId() + "';";
			stmt.executeUpdate(sql);
			DBConnection.closeStatement(stmt);
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from Admin";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getString(1));
				admin.setPassword(rs.getString(2));
				admin.setName(rs.getString(3));
				admin.setTel(rs.getString(4));
				admin.setIdCardNo(rs.getString(5));
				list.add(admin);
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

	// query one administrator
	public Admin queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		Admin admin = new Admin();
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from Admin where id = '" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				admin.setId(rs.getString(1));
				admin.setPassword(rs.getString(2));
				admin.setName(rs.getString(3));
				admin.setTel(rs.getString(4));
				admin.setIdCardNo(rs.getString(5));
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from Admin limit " + start + "," + stepLength + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getString(1));
				admin.setPassword(rs.getString(2));
				admin.setName(rs.getString(3));
				admin.setTel(rs.getString(4));
				admin.setIdCardNo(rs.getString(5));
				list.add(admin);
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

	// query numbers of administrators
	public int qureyNumOfAdmin() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from Admin";
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
}