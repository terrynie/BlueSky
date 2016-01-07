package com.qs.sqlserver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbConnection {
	public static Connection conn = null;
	public static String driverClass = "";
	public static String dbURL = "";
	public static String dbUser = "";
	public static String dbPwd = "";

	static {
		loadProperty();
	}

	private static boolean loadProperty() {
		Properties properties = new Properties();
		try {
			properties.load(DbConnection.class.getResourceAsStream("db.properties"));
			driverClass = properties.getProperty("drivername");
			dbURL = properties.getProperty("dburl");
			dbUser = properties.getProperty("username");
			dbPwd = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void openConn() {
		try {
			Class.forName(driverClass).newInstance();
			conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeConn() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}

}
