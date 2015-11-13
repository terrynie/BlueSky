package com.bluesky.tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.bean.InspectionPersonnel;
import com.bluesky.database.DBConnection;

//query inspection personnel according to precinct
public class QueryByPrecincts {
	public LinkedList<InspectionPersonnel> queryInspByPrecinct(String precinct) {
		LinkedList<InspectionPersonnel> list = new LinkedList<InspectionPersonnel>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from InspectionPersonnel where precinct = '" + precinct + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				InspectionPersonnel inspector = new InspectionPersonnel();
				inspector.setId(rs.getString(1));
				inspector.setPassword(rs.getString(2));
				inspector.setName(rs.getString(3));
				inspector.setSex(rs.getString(4));
				inspector.setSection(rs.getString(5));
				inspector.setPrecinct(rs.getString(6));
				inspector.setTel(rs.getString(7));
				inspector.setIdCardNo(rs.getString(8));
				list.add(inspector);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
