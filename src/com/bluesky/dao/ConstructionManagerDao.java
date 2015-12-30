package com.bluesky.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.bluesky.bean.ConstructionManager;
import com.bluesky.database.DBConnection;

public class ConstructionManagerDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	// add an director
	public boolean addManager(ConstructionManager conManager) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "insert into ConstructionSiteDirector values(?,?,?,?,?,?,?)";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, conManager.getId());
			ps.setString(2, conManager.getPassword());
			ps.setString(3, conManager.getName());
			ps.setString(4, conManager.getSex());
			ps.setString(5, conManager.getTel());
			ps.setString(6, conManager.getIdCardNo());
			ps.setString(7, conManager.getConstructionId());
			ps.setString(8, conManager.getCompany());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
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
			String sql = "delete from ConstructionSiteDirector where id=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, conManager.getId());
			ps.executeUpdate(sql);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
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
			String sql = "select * from ConstructionSiteDirector";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
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
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query one director
	public ConstructionManager queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		ConstructionManager conManager = new ConstructionManager();
		try {
			String sql = "select * from ConstructionSiteDirector where id = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				conManager.setId(rs.getString(1));
				conManager.setPassword(rs.getString(2));
				conManager.setName(rs.getString(3));
				conManager.setTel(rs.getString(4));
				conManager.setIdCardNo(rs.getString(5));
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
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
			String sql = "select * from ConstructionSiteDirector limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, stepLength);
			rs = ps.executeQuery();
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
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query numbers of directors
	public int qureyNumOfDirectors() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from ConstructionSiteDirector";
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

	public LinkedList<String> queryPrecinctInConDir() {
		LinkedList<String> list = new LinkedList<String>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select distinct ConstructionSite.Districts from ConstructionSite,ConstructionSiteDirector where ConstructionSite.ID = ConstructionSiteDirector.ConstructionSiteID";
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
