package com.bluesky.tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.bluesky.database.DBConnection;

//query distinct precinct from table--ConstructionSiteDirector
public class QueryPrecinctInConDir {
	@SuppressWarnings("null")
	public String[] queryPrecinctInConDir() {
		String[] precincts = null;
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select distinct ConstructionSite.Districts from ConstructionSite,ConstructionSiteDirector where ConstructionSite.ID = ConstructionSiteDirector.ConstructionSiteID  ";
			ResultSet rs = stmt.executeQuery(sql);
			for (int i = 0; i < rs.getRow(); i++) {
				precincts[i] = rs.getString(1);
			}
			return precincts;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return precincts;
	}
}
