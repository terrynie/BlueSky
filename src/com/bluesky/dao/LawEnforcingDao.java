package com.bluesky.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.bean.LawEnforcing;
import com.bluesky.database.DBConnection;

public class LawEnforcingDao {
	public boolean addLawEnforcing(LawEnforcing lawEnforcing) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "insert into LawEnforcing values('" + lawEnforcing.getId() + "','" + lawEnforcing.getPassword()
					+ "','" + lawEnforcing.getName() + "','" + lawEnforcing.getTel() + "','"
					+ lawEnforcing.getIdCardNo() + "');";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delLawEnforcing(LawEnforcing lawEnforcing) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "delete from LawEnforcing where ID='" + lawEnforcing.getId() + "';";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public LinkedList<LawEnforcing> queryLawEnforcings() {
		LinkedList<LawEnforcing> list = new LinkedList<LawEnforcing>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from LawEnforcing";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				LawEnforcing lawEnforcing = new LawEnforcing();
				lawEnforcing.setId(rs.getString(1));
				lawEnforcing.setPassword(rs.getString(2));
				lawEnforcing.setName(rs.getString(3));
				lawEnforcing.setTel(rs.getString(4));
				lawEnforcing.setIdCardNo(rs.getString(5));
				list.add(lawEnforcing);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	public LawEnforcing queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		LawEnforcing lawEnforcing = new LawEnforcing();
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from LawEnforcing where id = '" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
			lawEnforcing.setId(rs.getString(1));
			lawEnforcing.setPassword(rs.getString(2));
			lawEnforcing.setName(rs.getString(3));
			lawEnforcing.setTel(rs.getString(4));
			lawEnforcing.setIdCardNo(rs.getString(5));}
			return lawEnforcing;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public LinkedList<LawEnforcing> queryByLength(int start, int stepLength) {
		LinkedList<LawEnforcing> list = new LinkedList<LawEnforcing>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from LawEnforcing limit " + start + "," + stepLength + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				LawEnforcing lawEnforcing = new LawEnforcing();
				lawEnforcing.setId(rs.getString(1));
				lawEnforcing.setPassword(rs.getString(2));
				lawEnforcing.setName(rs.getString(3));
				lawEnforcing.setTel(rs.getString(4));
				lawEnforcing.setIdCardNo(rs.getString(5));
				list.add(lawEnforcing);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	public int qureyNumOfLawEnforcings() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from LawEnforcing";
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
