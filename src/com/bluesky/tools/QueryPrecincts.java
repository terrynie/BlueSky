package com.bluesky.tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.database.DBConnection;

//query distinct precinct from table--InspectionPersonnel
public class QueryPrecincts {

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
