package com.bluesky.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.bluesky.bean.WhetherInfo;
import com.bluesky.tools.CloseResource;

public class WhetherDao {
	
	private static Connection conn = null;
	private static String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String dbURL = "jdbc:sqlserver://192.168.188.54:1433;DatabaseName=test";
	private static String dbUser = "sa";
	private static String dbPwd = "123456";
	private PreparedStatement ps;
	private ResultSet rs;
	
	static{
		openConn();
	}
	
	public static void openConn() {
		try {
			Class.forName(driverClass).newInstance();
			conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private LinkedList<WhetherInfo> queryAll() {
		if (conn == null) {
			openConn();
		}
		LinkedList<WhetherInfo> list = new LinkedList<>();
		String sql = "select * from dbo.dCurrent";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				WhetherInfo data = new WhetherInfo();
				data.setIdm(rs.getInt(1));
				data.setIdfac(rs.getInt(2));
				data.setTime(rs.getTimestamp(3));
				data.setE1(rs.getFloat(4));
				data.setE2(rs.getFloat(5));
				data.setE3(rs.getFloat(6));
				data.setE4(rs.getFloat(7));
				data.setE5(rs.getFloat(1));
				data.setE6(rs.getFloat(9));
				data.setE7(rs.getFloat(10));
				data.setE8(rs.getFloat(11));
				data.setE9(rs.getFloat(12));
				data.setE10(rs.getFloat(13));
				data.setE11(rs.getFloat(14));
				data.setE12(rs.getFloat(15));
				data.setE13(rs.getFloat(16));
				data.setE14(rs.getFloat(17));
				data.setE15(rs.getFloat(18));
				data.setE16(rs.getFloat(19));
				list.add(data);
			}
			CloseResource.closeResultSet(rs);
			CloseResource.closeStatement(ps);
			CloseResource.closeConn(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
