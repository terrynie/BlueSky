package com.bluesky.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.bean.FineTicket;
import com.bluesky.database.DBConnection;

public class FineTicketDao {

	// add a fine ticket
	public boolean addFineTicket(FineTicket fineTicket) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "insert into FineTicket values('" + fineTicket.getId() + "','" + fineTicket.getNotificationId()
					+ "','" + fineTicket.getConSiteId() + "','" + fineTicket.getCompany() + "',"
					+ fineTicket.getFineMoney() + ",'" + fineTicket.getStartTime() + "','" + fineTicket.getWho()
					+ "','" + fineTicket.getFineMoney() + "');";
			stmt.execute(sql);
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "delete from FineTicket where ID='" + fineTicket.getId() + "';";
			stmt.execute(sql);
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from FineTicket";
			ResultSet rs = stmt.executeQuery(sql);
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
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query one fineTicketistrator
	public FineTicket queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		FineTicket fineTicket = new FineTicket();
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from FineTicket where id = '" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
			fineTicket.setId(rs.getString(1));
			fineTicket.setNotificationId(rs.getString(2));
			fineTicket.setConSiteId(rs.getString(3));
			fineTicket.setCompany(rs.getString(4));
			fineTicket.setFineMoney(rs.getDouble(5));
			fineTicket.setStartTime(rs.getDate(6));
			fineTicket.setDeadLine(rs.getDate(7));
			fineTicket.setWho(rs.getString(8));}
			return fineTicket;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query fine ticket counts by given number
	public LinkedList<FineTicket> queryByPage(int start, int stepLength) {
		LinkedList<FineTicket> list = new LinkedList<FineTicket>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from FineTicket limit " + start + "," + stepLength + ";";
			ResultSet rs = stmt.executeQuery(sql);
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
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query numbers of fine tickets
	public int qureyNumOfFineTicket() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from FineTicket";
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
