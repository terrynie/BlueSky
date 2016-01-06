package com.bluesky.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.bluesky.bean.FineTicket;
import com.bluesky.database.DBConnection;

public class FineTicketDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	// add a fine ticket
	public boolean addFineTicket(FineTicket fineTicket) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "insert into FineTicket values(?,?,?,?,?,?,?,?)";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, fineTicket.getId());
			ps.setString(2, fineTicket.getNotificationId());
			ps.setString(3, fineTicket.getConSiteId());
			ps.setString(4, fineTicket.getCompany());
			ps.setDouble(5, fineTicket.getFineMoney());
			ps.setDate(6, fineTicket.getStartTime());
			ps.setDate(7, fineTicket.getDeadLine());
			ps.setString(8, fineTicket.getWho());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete a fine ticket
	public boolean delFineTicket(FineTicket fineTicket) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "delete from FineTicket where ID=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, fineTicket.getId());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// query all fine tickets
	public LinkedList<FineTicket> queryFineTickets() {
		LinkedList<FineTicket> list = new LinkedList<FineTicket>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from FineTicket";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				FineTicket fineTicket = new FineTicket();
				fineTicket.setId(rs.getString(1));
				fineTicket.setNotificationId(rs.getString(2));
				fineTicket.setConSiteId(rs.getString(3));
				fineTicket.setCompany(rs.getString(4));
				fineTicket.setFineMoney(rs.getDouble(5));
				fineTicket.setStartTime(rs.getDate(6));
				fineTicket.setDeadLine(rs.getDate(7));
				fineTicket.setWho(rs.getString(8));
				list.add(fineTicket);
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

	// query one fineTicketistrator
	public FineTicket queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		FineTicket fineTicket = new FineTicket();
		try {
			String sql = "select * from FineTicket where id = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				fineTicket.setId(rs.getString(1));
				fineTicket.setNotificationId(rs.getString(2));
				fineTicket.setConSiteId(rs.getString(3));
				fineTicket.setCompany(rs.getString(4));
				fineTicket.setFineMoney(rs.getDouble(5));
				fineTicket.setStartTime(rs.getDate(6));
				fineTicket.setDeadLine(rs.getDate(7));
				fineTicket.setWho(rs.getString(8));
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return fineTicket;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query fine ticket counts by given number
		public LinkedList<FineTicket> queryByPage(int status, int start, int stepLength) {
			LinkedList<FineTicket> list = new LinkedList<FineTicket>();
			if (DBConnection.conn == null) {
				DBConnection.openConn();
			}
			try {
				String sql = "select * from FineTicket limit ?,?";
				ps = DBConnection.conn.prepareStatement(sql);
				ps.setInt(1, status);
				ps.setInt(2, start);
				if(status >= 0){
					sql = "select * from FineTicket where status=? limit ?,?";
					ps = DBConnection.conn.prepareStatement(sql);
					ps.setInt(1, status);
					ps.setInt(2, start);
					ps.setInt(3, stepLength);
				}
				rs = ps.executeQuery();
				while (rs.next()) {
					FineTicket fineTicket = new FineTicket();
					fineTicket.setId(rs.getString(1));
					fineTicket.setNotificationId(rs.getString(2));
					fineTicket.setConSiteId(rs.getString(3));
					fineTicket.setCompany(rs.getString(4));
					fineTicket.setFineMoney(rs.getDouble(5));
					fineTicket.setStartTime(rs.getDate(6));
					fineTicket.setDeadLine(rs.getDate(7));
					fineTicket.setWho(rs.getString(8));
					list.add(fineTicket);
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


	// query numbers of fine tickets
	public int qureyNumOfFineTicket() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from FineTicket";
			ps = DBConnection.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
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
	
	public int queryNumByStatus(int status) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from FineTicket where status=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, status);
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

	
	/**
	 * update one fineticket's status according to its id
	 * 
	 * @param id
	 *            the id of the fineticket whose status will be update
	 * @param status
	 *            the new status of the fineticket
	 * @return a value of int standards the operating result
	 */
	public int updateStatus(String id, int status) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int num = 0;
		try {
			String sql = "update fineticket set status=? where id=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setString(2, id);
			num = ps.executeUpdate();
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
