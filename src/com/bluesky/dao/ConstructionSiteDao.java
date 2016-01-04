package com.bluesky.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.bluesky.bean.ConstructionSite;
import com.bluesky.database.DBConnection;

public class ConstructionSiteDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	// add a construction site
	public boolean addConSite(ConstructionSite constructionSite) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "insert into ConstructionSite values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, constructionSite.getId());
			ps.setString(2, constructionSite.getProjectName());
			ps.setString(3, constructionSite.getName());
			ps.setString(4, constructionSite.getDirectorId());
			ps.setDouble(5, constructionSite.getArea());
			ps.setDate(6, constructionSite.getStartTime());
			ps.setDate(7, constructionSite.getCompleteTime());
			ps.setInt(8, constructionSite.getTotalFloors());
			ps.setString(9, constructionSite.getDistrict());
			ps.setString(10, constructionSite.getStruct());
			ps.setDouble(11, constructionSite.getPrice());
			ps.setInt(12, constructionSite.getTotalMonitors());
			ps.setString(13, constructionSite.getProgress());
			ps.setDouble(14, constructionSite.getLongitude());
			ps.setDouble(15, constructionSite.getLatitude());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
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
			String sql = "delete from ConstructionSite where id=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, constructionSite.getId());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
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
			String sql = "select * from ConstructionSite";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
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
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query one construction site
	public ConstructionSite queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		ConstructionSite constructionSite = new ConstructionSite();
		try {
			String sql = "select * from ConstructionSite where id = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
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
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
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
			String sql = "select * from ConstructionSite limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, stepLength);
			rs = ps.executeQuery();
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
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query numbers of construction sites
	public int qureyNumOfConSites() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from ConstructionSite";
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

	// query by district
	public LinkedList<ConstructionSite> queryByDistrict(String district) {
		LinkedList<ConstructionSite> list = new LinkedList<ConstructionSite>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		ConstructionSite constructionSite = new ConstructionSite();
		try {
			String sql = "select * from ConstructionSite where district = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, district);
			rs = ps.executeQuery();
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
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
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
			String sql = "select distinct name from ConstructionSite where streets=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, street);
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

	// query streets according to district
	public LinkedList<String> queryStreetByDistrict(String district) {
		LinkedList<String> list = new LinkedList<String>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select distinct streets from ConstructionSite where districts=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, district);
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

	// query distinct districts from construction site table
	public LinkedList<String> queryDistricts() {
		LinkedList<String> list = new LinkedList<String>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select distinct districts from ConstructionSite";
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

	// query construction site id by name
	public String queryIdByName(String conSiteName) {
		String id = null;
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select id from ConstructionSite where name = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, conSiteName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getString(1);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
