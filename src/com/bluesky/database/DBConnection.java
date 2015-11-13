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

	// 读取配置文件
	public static boolean loadProperty() {
		Properties properties = new Properties();
		try {
			properties.load(DBConnection.class.getResourceAsStream("db.properties"));
			driverClass = properties.getProperty("drivername");
			dbURL = properties.getProperty("dburl");
			dbUser = properties.getProperty("username");
			dbPwd = properties.getProperty("password");
			//System.out.println("pwd:" + dbPwd + " ----- 读取配置文件成功！");
		} catch (IOException e) {
			System.out.println("读取配置文件失败");
			return false;
		}
		return true;
	}

	public static void openConn() {
		// 加载驱动类
		try {
			Class.forName(driverClass).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("驱动类没有找到，加载失败");
			return;
		}
		// 获得与指定数据库的连接
		try {
			conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("连接失败！");
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
