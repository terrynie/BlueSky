package com.bluesky.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.bean.Videos;
import com.bluesky.database.DBConnection;

public class VideosDao {
	// add a video
	public boolean addImage(Videos video) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "insert into Videos values('" + video.getId() + "','" + video.getComplaintId() + "','"
					+ video.getVideoPath() + "');";
			stmt.executeUpdate(sql);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete a video
	public boolean delVideos(Videos video) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "delete from Videos where ID='" + video.getId() + "';";
			stmt.executeUpdate(sql);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// query all videos
	public LinkedList<Videos> queryVideoss() {
		LinkedList<Videos> list = new LinkedList<Videos>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from Videos";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Videos video = new Videos();
				video.setId(rs.getString(1));
				video.setComplaintId(rs.getString(2));
				video.setVideoPath(rs.getString(3));
				list.add(video);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query one video
	public Videos queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		Videos video = new Videos();
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from Videos where id = '" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				video.setId(rs.getString(1));
				video.setComplaintId(rs.getString(2));
				video.setVideoPath(rs.getString(3));
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
			return video;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query video counts by given number
	public LinkedList<Videos> queryByPage(int start, int stepLength) {
		LinkedList<Videos> list = new LinkedList<Videos>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from Videos limit " + start + "," + stepLength + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Videos video = new Videos();
				video.setId(rs.getString(1));
				video.setComplaintId(rs.getString(2));
				video.setVideoPath(rs.getString(3));
				list.add(video);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query numbers of videos
	public int qureyNumOfVideos() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from Videos";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sum = rs.getInt(1);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
}
