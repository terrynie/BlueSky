package com.bluesky.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bluesky.bean.Videos;
import com.bluesky.database.DBConnection;

public class VideosDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// add a video
	public boolean addImage(Videos video) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "insert into Videos values(?,?,?)";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, video.getId());
			ps.setString(2, video.getComplaintId());
			ps.setString(3, video.getVideoPath());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
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
			String sql = "delete from Videos where ID=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, video.getId());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// query all videos
	public ArrayList<Videos> queryVideoss() {
		ArrayList<Videos> list = new ArrayList<Videos>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from Videos";
			ps = DBConnection.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Videos video = new Videos();
				video.setId(rs.getString(1));
				video.setComplaintId(rs.getString(2));
				video.setVideoPath(rs.getString(3));
				list.add(video);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query one video
	public Videos queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		Videos video = new Videos();
		try {
			String sql = "select * from Videos where id = ?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				video.setId(rs.getString(1));
				video.setComplaintId(rs.getString(2));
				video.setVideoPath(rs.getString(3));
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return video;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query video counts by given number
	public ArrayList<Videos> queryByPage(int start, int stepLength) {
		ArrayList<Videos> list = new ArrayList<Videos>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from Videos limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, stepLength);
			rs = ps.executeQuery();
			while (rs.next()) {
				Videos video = new Videos();
				video.setId(rs.getString(1));
				video.setComplaintId(rs.getString(2));
				video.setVideoPath(rs.getString(3));
				list.add(video);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query numbers of videos
	public int qureyNumOfVideos() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from Videos";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				sum = rs.getInt(1);
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return sum;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
