package com.bluesky.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.bluesky.bean.InspectionPersonnel;
import com.bluesky.database.DBConnection;

public class InspectionPersonnelDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	// add an inspector
	public boolean addManager(InspectionPersonnel inspector) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "insert into InspectionPersonnel values(?,?,?,?,?,?,?,?)";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, inspector.getId());
			ps.setString(2, inspector.getPassword());
			ps.setString(3, inspector.getName());
			ps.setString(4, inspector.getSex());
			ps.setString(5, inspector.getSection());
			ps.setString(6, inspector.getPrecinct());
			ps.setString(7, inspector.getTel());
			ps.setString(8, inspector.getIdCardNo());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete a inspector
	public boolean delManager(InspectionPersonnel inspector) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "delete from InspectionPersonnel where id=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, inspector.getId());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// query all inspectors
	public LinkedList<InspectionPersonnel> queryInspectors() {
		LinkedList<InspectionPersonnel> list = new LinkedList<InspectionPersonnel>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from InspectionPersonnel";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				InspectionPersonnel inspector = new InspectionPersonnel();
				inspector.setId(rs.getString(1));
				inspector.setPassword(rs.getString(2));
				inspector.setName(rs.getString(3));
				inspector.setSex(rs.getString(4));
				inspector.setSection(rs.getString(5));
				inspector.setPrecinct(rs.getString(6));
				inspector.setTel(rs.getString(7));
				inspector.setIdCardNo(rs.getString(8));
				list.add(inspector);
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

	// query one inspector
	public InspectionPersonnel queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		InspectionPersonnel inspector = new InspectionPersonnel();
		try {
			String sql = "select * from InspectionPersonnel where id = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				inspector.setId(rs.getString(1));
				inspector.setPassword(rs.getString(2));
				inspector.setName(rs.getString(3));
				inspector.setTel(rs.getString(4));
				inspector.setIdCardNo(rs.getString(5));
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return inspector;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query inspectors by given number
	public LinkedList<InspectionPersonnel> queryByPage(int start, int stepLength) {
		LinkedList<InspectionPersonnel> list = new LinkedList<InspectionPersonnel>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from InspectionPersonnel limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, stepLength);
			rs = ps.executeQuery();
			while (rs.next()) {
				InspectionPersonnel inspector = new InspectionPersonnel();
				inspector.setId(rs.getString(1));
				inspector.setPassword(rs.getString(2));
				inspector.setName(rs.getString(3));
				inspector.setSex(rs.getString(4));
				inspector.setSection(rs.getString(5));
				inspector.setPrecinct(rs.getString(6));
				inspector.setTel(rs.getString(7));
				inspector.setIdCardNo(rs.getString(8));
				list.add(inspector);
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

	// query numbers of inspectors
	public int qureyNumOfInspectors() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from InspectionPersonnel";
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

	// query inspection personnel according to precinct
	public LinkedList<InspectionPersonnel> queryInspByPrecinct(String precinct) {
		LinkedList<InspectionPersonnel> list = new LinkedList<InspectionPersonnel>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from InspectionPersonnel where precinct = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, precinct);
			rs = ps.executeQuery();
			while (rs.next()) {
				InspectionPersonnel inspector = new InspectionPersonnel();
				inspector.setId(rs.getString(1));
				inspector.setPassword(rs.getString(2));
				inspector.setName(rs.getString(3));
				inspector.setSex(rs.getString(4));
				inspector.setSection(rs.getString(5));
				inspector.setPrecinct(rs.getString(6));
				inspector.setTel(rs.getString(7));
				inspector.setIdCardNo(rs.getString(8));
				list.add(inspector);
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

	// query distinct precinct from table--InspectionPersonnel
	public LinkedList<String> queryPrecinct() {
		LinkedList<String> list = new LinkedList<String>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select distinct precinct from InspectionPersonnel";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
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

}
