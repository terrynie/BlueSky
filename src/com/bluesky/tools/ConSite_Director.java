package com.bluesky.tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import com.bluesky.bean.Con_Dir;
import com.bluesky.database.DBConnection;

//info of constructionsite and director in the same page
public class ConSite_Director {
	public LinkedList<Con_Dir> queryConInfo(String prcinct) {
		LinkedList<Con_Dir> list = new LinkedList<Con_Dir>();

		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select ConstructionSite.name,ConstructionSite.progress,ConstructionSiteDirector.name from ConstructionSiteDirector,ConstructionSite where "
					+ "ConstructionSite.id =ConstructionSiteDirector.constructionSiteId and districts = '" + prcinct
					+ "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Con_Dir conSite_Director = new Con_Dir();
				conSite_Director.setConName(rs.getString(1));
				conSite_Director.setProgress(rs.getString(2));
				conSite_Director.setDirectorName(rs.getString(3));
				list.add(conSite_Director);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
