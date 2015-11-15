package com.bluesky.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.bean.ConstructionSite;
import com.bluesky.database.DBConnection;

public class ConstructionSiteDao {
	// add a construction site
	public boolean addConSite(ConstructionSite constructionSite) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "insert into ConstructionSite values('" + constructionSite.getId() + "','"
					+ constructionSite.getProjectName() + "','" + constructionSite.getName() + "','"
					+ constructionSite.getDirectorId() + "'," + constructionSite.getArea() + ",'"
					+ constructionSite.getStartTime() + "','" + constructionSite.getCompleteTime() + "',"
					+ constructionSite.getTotalFloors() + ",'" + constructionSite.getDistrict() + "',"
					+ constructionSite.getStreet() + "','" + constructionSite.getCompany() + "','"
					+ constructionSite.getStruct() + "'," + constructionSite.getPrice() + ",'"
					+ constructionSite.getTotalMonitors() + "');";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete a construction site
	public boolean delConSite(ConstructionSite constructionSite) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "delete from ConstructionSite where id='" + constructionSite.getId() + "';";
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// query all construction sites
	public LinkedList<ConstructionSite> queryConSites() {
		LinkedList<ConstructionSite> list = new LinkedList<ConstructionSite>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from ConstructionSite";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ConstructionSite constructionSite = new ConstructionSite();
				constructionSite.setId(rs.getString(1));
				constructionSite.setProjectName(rs.getString(2));
				constructionSite.setName(rs.getString(3));
				constructionSite.setDirectorId(rs.getString(4));
				constructionSite.setArea(rs.getDouble(5));
				constructionSite.setStartTime(rs.getDate(6));
				constructionSite.setCompleteTime(rs.getDate(7));
				constructionSite.setTotalFloors(rs.getInt(8));
				constructionSite.setDistrict(rs.getString(9));
				constructionSite.setStreet(rs.getString(10));
				constructionSite.setCompany(rs.getString(11));
				constructionSite.setStruct(rs.getString(12));
				constructionSite.setPrice(rs.getDouble(13));
				constructionSite.setTotalMonitors(rs.getInt(14));
				list.add(constructionSite);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query one construction site
	public ConstructionSite queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		ConstructionSite constructionSite = new ConstructionSite();
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from ConstructionSite where id = '" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				constructionSite.setId(rs.getString(1));
				constructionSite.setProjectName(rs.getString(2));
				constructionSite.setName(rs.getString(3));
				constructionSite.setDirectorId(rs.getString(4));
				constructionSite.setArea(rs.getDouble(5));
				constructionSite.setStartTime(rs.getDate(6));
				constructionSite.setCompleteTime(rs.getDate(7));
				constructionSite.setTotalFloors(rs.getInt(8));
				constructionSite.setDistrict(rs.getString(9));
				constructionSite.setStreet(rs.getString(10));
				constructionSite.setCompany(rs.getString(11));
				constructionSite.setStruct(rs.getString(12));
				constructionSite.setPrice(rs.getDouble(13));
				constructionSite.setTotalMonitors(rs.getInt(14));
			}
			return constructionSite;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query construction sites by given number
	public LinkedList<ConstructionSite> queryByPage(int start, int stepLength) {
		LinkedList<ConstructionSite> list = new LinkedList<ConstructionSite>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from ConstructionSite limit " + start + "," + stepLength + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ConstructionSite constructionSite = new ConstructionSite();
				constructionSite.setId(rs.getString(1));
				constructionSite.setProjectName(rs.getString(2));
				constructionSite.setName(rs.getString(3));
				constructionSite.setDirectorId(rs.getString(4));
				constructionSite.setArea(rs.getDouble(5));
				constructionSite.setStartTime(rs.getDate(6));
				constructionSite.setCompleteTime(rs.getDate(7));
				constructionSite.setTotalFloors(rs.getInt(8));
				constructionSite.setDistrict(rs.getString(9));
				constructionSite.setStreet(rs.getString(10));
				constructionSite.setCompany(rs.getString(11));
				constructionSite.setStruct(rs.getString(12));
				constructionSite.setPrice(rs.getDouble(13));
				constructionSite.setTotalMonitors(rs.getInt(14));
				list.add(constructionSite);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query numbers of construction sites
	public int qureyNumOfConSites() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from ConstructionSite";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	// query by district
	public LinkedList<ConstructionSite> queryByDistrict(String district) {
		LinkedList<ConstructionSite> list = new LinkedList<ConstructionSite>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		ConstructionSite constructionSite = new ConstructionSite();
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from ConstructionSite where district = '" + district + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				constructionSite.setId(rs.getString(1));
				constructionSite.setProjectName(rs.getString(2));
				constructionSite.setName(rs.getString(3));
				constructionSite.setDirectorId(rs.getString(4));
				constructionSite.setArea(rs.getDouble(5));
				constructionSite.setStartTime(rs.getDate(6));
				constructionSite.setCompleteTime(rs.getDate(7));
				constructionSite.setTotalFloors(rs.getInt(8));
				constructionSite.setDistrict(rs.getString(9));
				constructionSite.setStreet(rs.getString(10));
				constructionSite.setCompany(rs.getString(11));
				constructionSite.setStruct(rs.getString(12));
				constructionSite.setPrice(rs.getDouble(13));
				constructionSite.setTotalMonitors(rs.getInt(14));
				list.add(constructionSite);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query construction site according to street
	public LinkedList<String> queryConSiteNameByStreet(String street) {
		LinkedList<String> list = new LinkedList<String>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select distinct name from ConstructionSite where streets='" + street + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// query streets according to district
	public LinkedList<String> queryStreetByDistrict(String district) {
		LinkedList<String> list = new LinkedList<String>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select distinct streets from ConstructionSite where districts='" + district + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//query distinct districts from construction site table
	public LinkedList<String> queryDistricts(){
		LinkedList<String> list = new LinkedList<String>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select distinct districts from ConstructionSite";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
