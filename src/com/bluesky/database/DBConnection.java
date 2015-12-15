package com.bluesky.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	public static Connection conn = null;
	public static String driverClass = "";
	public static String dbURL = "";
	public static String dbUser = "";
	public static String dbPwd = "";

	static {
		loadProperty();
	}

	public static boolean loadProperty() {
		Properties properties = new Properties();
		try {
			properties.load(DBConnection.class.getResourceAsStream("db.properties"));
			driverClass = properties.getProperty("drivername");
			dbURL = properties.getProperty("dburl");
			dbUser = properties.getProperty("username");
			dbPwd = properties.getProperty("password");
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public static void openConn() {
		try {
			Class.forName(driverClass).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			return;
		}

		try {
			conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConn() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
