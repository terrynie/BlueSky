package com.bluesky.tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.bluesky.database.DBConnection;
import com.mysql.jdbc.ResultSetMetaData;

//info of constructionsite and director in the same page
public class ConSite_Director {
	@SuppressWarnings("null")
	public String[][] queryConInfo(String prcinct) {
		String[][] list = null;
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select ConstructionSite.name,ConstructionSite.progress,ConstructionSiteDirector.name from ConstructionSiteDirector,ConstructionSite where "
					+ "ConstructionSite.id =ConstructionSiteDirector.constructionSiteId and districts = '" + prcinct
					+ "';";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 0; i < rs.getRow(); i++) {
				for (int j = 0; j < columnCount; j++) {
					list[i][j] = rs.getString(j);
				}
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
