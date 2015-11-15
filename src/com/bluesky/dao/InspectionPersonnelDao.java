package com.bluesky.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.bean.InspectionPersonnel;
import com.bluesky.database.DBConnection;

public class InspectionPersonnelDao {
	// add an inspector
	public boolean addManager(InspectionPersonnel inspector) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "insert into InspectionPersonnel values('" + inspector.getId() + "','"
					+ inspector.getPassword() + "','" + inspector.getName() + "','" + inspector.getSex() + "','"
					+ inspector.getSection() + "','" + inspector.getPrecinct() + "','" + inspector.getTel() + "','"
					+ inspector.getIdCardNo() + "');";
			stmt.executeUpdate(sql);
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "delete from InspectionPersonnel where id='" + inspector.getId() + "';";
			stmt.executeUpdate(sql);
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from InspectionPersonnel";
			ResultSet rs = stmt.executeQuery(sql);
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
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query one inspector
	public InspectionPersonnel queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		InspectionPersonnel inspector = new InspectionPersonnel();
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from InspectionPersonnel where id = '" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				inspector.setId(rs.getString(1));
				inspector.setPassword(rs.getString(2));
				inspector.setName(rs.getString(3));
				inspector.setTel(rs.getString(4));
				inspector.setIdCardNo(rs.getString(5));
			}
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from InspectionPersonnel limit " + start + "," + stepLength + ";";
			ResultSet rs = stmt.executeQuery(sql);
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
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query numbers of inspectors
	public int qureyNumOfInspectors() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from InspectionPersonnel";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	// query inspection personnel according to precinct
	public LinkedList<InspectionPersonnel> queryInspByPrecinct(String precinct) {
		LinkedList<InspectionPersonnel> list = new LinkedList<InspectionPersonnel>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from InspectionPersonnel where precinct = '" + precinct + "';";
			ResultSet rs = stmt.executeQuery(sql);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//query distinct precinct from table--InspectionPersonnel

		public LinkedList<String> queryPrecinct() {
			LinkedList<String> list = new LinkedList<String>();
			if (DBConnection.conn == null) {
				DBConnection.openConn();
			}
			try {
				Statement stmt = DBConnection.conn.createStatement();
				String sql = "select distinct precinct from InspectionPersonnel";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					list.add(rs.getString(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}

}
