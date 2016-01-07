package com.bluesky.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bluesky.bean.LawEnforcing;
import com.bluesky.database.DBConnection;
import com.bluesky.tools.TimeConvert;

public class LawEnforcingDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean addLawEnforcing(LawEnforcing lawEnforcing) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "insert into LawEnforcing values(?,?,?,?,?,?,?)";
			ps.setString(1, lawEnforcing.getId());
			ps.setString(2, lawEnforcing.getPassword());
			ps.setString(3, lawEnforcing.getName());
			ps.setString(4, lawEnforcing.getTel());
			ps.setString(5, lawEnforcing.getIdCardNo());
			ps.setDate(6, TimeConvert.ConvertToSqlDate(lawEnforcing.getRegisterDate()));
			ps.setDate(7, TimeConvert.ConvertToSqlDate(lawEnforcing.getLogoffTime()));
			ps = DBConnection.conn.prepareStatement(sql);

			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
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
			String sql = "delete from LawEnforcing where ID=?";
			ps.setString(1, lawEnforcing.getId());
			ps = DBConnection.conn.prepareStatement(sql);
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<LawEnforcing> queryLawEnforcings() {
		ArrayList<LawEnforcing> list = new ArrayList<LawEnforcing>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from LawEnforcing";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				LawEnforcing lawEnforcing = new LawEnforcing();
				lawEnforcing.setId(rs.getString(1));
				lawEnforcing.setPassword(rs.getString(2));
				lawEnforcing.setName(rs.getString(3));
				lawEnforcing.setTel(rs.getString(4));
				lawEnforcing.setIdCardNo(rs.getString(5));
				lawEnforcing.setRegisterDate(rs.getDate(6));
				lawEnforcing.setLogoffTime(rs.getDate(7));
				list.add(lawEnforcing);
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

	public LawEnforcing queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		LawEnforcing lawEnforcing = new LawEnforcing();
		try {
			String sql = "select * from LawEnforcing where id=?";
			ps.setString(1, id);
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				lawEnforcing.setId(rs.getString(1));
				lawEnforcing.setPassword(rs.getString(2));
				lawEnforcing.setName(rs.getString(3));
				lawEnforcing.setTel(rs.getString(4));
				lawEnforcing.setIdCardNo(rs.getString(5));
				lawEnforcing.setRegisterDate(rs.getDate(6));
				lawEnforcing.setLogoffTime(rs.getDate(7));
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return lawEnforcing;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<LawEnforcing> queryByLength(int start, int stepLength) {
		ArrayList<LawEnforcing> list = new ArrayList<LawEnforcing>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from LawEnforcing limit ?,?";
			ps.setInt(1, start);
			ps.setInt(2, stepLength);
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				LawEnforcing lawEnforcing = new LawEnforcing();
				lawEnforcing.setId(rs.getString(1));
				lawEnforcing.setPassword(rs.getString(2));
				lawEnforcing.setName(rs.getString(3));
				lawEnforcing.setTel(rs.getString(4));
				lawEnforcing.setIdCardNo(rs.getString(5));
				lawEnforcing.setRegisterDate(rs.getDate(6));
				lawEnforcing.setLogoffTime(rs.getDate(7));
				list.add(lawEnforcing);
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

	public int qureyNumOfLawEnforcings() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from LawEnforcing";
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
