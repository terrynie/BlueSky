package com.qs.sqlserver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class TestSqlServer {

	public static void main(String[] args) {
		LinkedList<TestDataBean> list = new TestSqlServer().queryAll();
		for (int i = 0; i < list.size(); i++) {
			TestDataBean data = list.get(i);
			System.out.println(data.getIdm() + " " + data.getIdfac() + " " + data.getTime());
		}
	}

	private LinkedList<TestDataBean> queryAll() {
		if (DbConnection.conn == null) {
			DbConnection.openConn();
		}
		LinkedList<TestDataBean> list = new LinkedList<>();
		String sql = "select * from dbo.dCurrent";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = DbConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				TestDataBean data = new TestDataBean();
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
			DbConnection.closeResultSet(rs);
			DbConnection.closeStatement(ps);
			DbConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
