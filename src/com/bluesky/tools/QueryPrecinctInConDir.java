package com.bluesky.tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.database.DBConnection;

//query distinct precinct from table--ConstructionSiteDirector
public class QueryPrecinctInConDir {
	public LinkedList<String> queryPrecinctInConDir() {
		LinkedList<String> list = new LinkedList<String>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select distinct ConstructionSite.Districts from ConstructionSite,ConstructionSiteDirector where ConstructionSite.ID = ConstructionSiteDirector.ConstructionSiteID  ";
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
