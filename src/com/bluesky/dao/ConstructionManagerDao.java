package com.bluesky.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.bean.ConstructionManager;
import com.bluesky.database.DBConnection;

public class ConstructionManagerDao {
	// add an director
	public boolean addManager(ConstructionManager conManager) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "insert into ConstructionSiteDirector values('" + conManager.getId() + "','"
					+ conManager.getPassword() + "','" + conManager.getName() + "','" + conManager.getSex() + "','"
					+ conManager.getTel() + "','" + conManager.getIdCardNo() + "','" + conManager.getConstructionId()
					+ "','" + conManager.getCompany() + "';";
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete a director
	public boolean delManager(ConstructionManager conManager) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "delete from ConstructionSiteDirector where id='" + conManager.getId() + "';";
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// query all directors
	public LinkedList<ConstructionManager> queryManagers() {
		LinkedList<ConstructionManager> list = new LinkedList<ConstructionManager>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from ConstructionSiteDirector";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ConstructionManager conManager = new ConstructionManager();
				conManager.setId(rs.getString(1));
				conManager.setPassword(rs.getString(2));
				conManager.setName(rs.getString(3));
				conManager.setSex(rs.getString(4));
				conManager.setTel(rs.getString(5));
				conManager.setIdCardNo(rs.getString(6));
				conManager.setConstructionId(rs.getString(7));
				conManager.setCompany(rs.getString(8));
				list.add(conManager);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query one director
	public ConstructionManager queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		ConstructionManager conManager = new ConstructionManager();
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from ConstructionSiteDirector where id = '" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
			conManager.setId(rs.getString(1));
			conManager.setPassword(rs.getString(2));
			conManager.setName(rs.getString(3));
			conManager.setTel(rs.getString(4));
			conManager.setIdCardNo(rs.getString(5));}
			return conManager;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query directors by given number
	public LinkedList<ConstructionManager> queryByPage(int start, int stepLength) {
		LinkedList<ConstructionManager> list = new LinkedList<ConstructionManager>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from ConstructionSiteDirector limit " + start + "," + stepLength + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ConstructionManager conManager = new ConstructionManager();
				conManager.setId(rs.getString(1));
				conManager.setPassword(rs.getString(2));
				conManager.setName(rs.getString(3));
				conManager.setSex(rs.getString(4));
				conManager.setTel(rs.getString(5));
				conManager.setIdCardNo(rs.getString(6));
				conManager.setConstructionId(rs.getString(7));
				conManager.setCompany(rs.getString(8));
				list.add(conManager);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query numbers of directors
	public int qureyNumOfDirectors() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from ConstructionSiteDirector";
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
