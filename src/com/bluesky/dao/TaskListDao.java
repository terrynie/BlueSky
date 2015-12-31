package com.bluesky.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.bluesky.bean.TaskList;
import com.bluesky.database.DBConnection;

public class TaskListDao {

	PreparedStatement ps = null;
	ResultSet rs = null;

	// add a task
	public boolean addTask(TaskList task) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "insert into TaskList values(?,?,?,?,?,?,?)";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, task.getId());
			ps.setString(2, task.getSource());
			ps.setString(3, task.getContent());
			ps.setInt(4, task.getHasContent());
			ps.setInt(5, task.getHasImg());
			ps.setInt(6, task.getHasVideo());
			ps.setInt(7, task.getStatus());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete a task
	public boolean delTask(TaskList task) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "delete from TaskList where id=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, task.getId());
			ps.executeUpdate();
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// query all tasks
	public LinkedList<TaskList> queryTaskLists() {
		LinkedList<TaskList> list = new LinkedList<TaskList>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from TaskList";
			ps = DBConnection.conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				TaskList task = new TaskList();
				task.setId(rs.getString(1));
				task.setSource(rs.getString(2));
				task.setContent(rs.getString(3));
				task.setHasContent(rs.getInt(4));
				task.setHasImg(rs.getInt(5));
				task.setHasVideo(rs.getInt(6));
				task.setStatus(rs.getInt(7));
				list.add(task);
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

	// query one task
	public TaskList queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		TaskList task = new TaskList();
		try {
			String sql = "select * from TaskList where id=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setString(1, task.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				task.setId(rs.getString(1));
				task.setSource(rs.getString(2));
				task.setContent(rs.getString(3));
				task.setHasContent(rs.getInt(4));
				task.setHasImg(rs.getInt(5));
				task.setHasVideo(rs.getInt(6));
				task.setStatus(rs.getInt(7));
			}
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConn();
			return task;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// query task counts by given number
	public LinkedList<TaskList> queryByPage(int start, int stepLength) {
		LinkedList<TaskList> list = new LinkedList<TaskList>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from TaskList limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, stepLength);
			rs = ps.executeQuery();
			while (rs.next()) {
				TaskList task = new TaskList();
				task.setId(rs.getString(1));
				task.setSource(rs.getString(2));
				task.setContent(rs.getString(3));
				task.setHasContent(rs.getInt(4));
				task.setHasImg(rs.getInt(5));
				task.setHasVideo(rs.getInt(6));
				task.setStatus(rs.getInt(7));
				list.add(task);
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

	// query numbers of tasks
	public int qureyNumOfTaskList() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from TaskList";
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

	/*
	 * query numbers of tasks waitting to be dealed according to different role
	 * default value -- "status = 0" -- Administrator else "status = 1" --
	 * InspectionPersonnel else "status = 2" -- LawInforcing department
	 */
	public int qureyNumOfTaskWaitDealed(String role) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from TaskList where Status=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, 0);
			if (role.trim().equals("InspectionPersonnel")) {
				ps.setInt(1, 2);
			} else if (role.trim().equals("LawInforcing")) {
				ps.setInt(1, 3);
			}
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

	public LinkedList<TaskList> qureyTaskWaitDealedByPage(int start, int stepLength, String role) {
		LinkedList<TaskList> list = new LinkedList<TaskList>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from TaskList where Status=? limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, start);
			ps.setInt(3, stepLength);
			if (role.trim().equals("InspectionPersonnel")) {
				ps.setInt(1, 1);
			} else if (role.trim().equals("LawInforcing")) {
				ps.setInt(1, 2);
			}

			rs = ps.executeQuery();
			while (rs.next()) {
				TaskList task = new TaskList();
				task.setId(rs.getString(1));
				task.setSource(rs.getString(2));
				task.setContent(rs.getString(3));
				task.setHasContent(rs.getInt(4));
				task.setHasImg(rs.getInt(5));
				task.setHasVideo(rs.getInt(6));
				task.setStatus(rs.getInt(7));
				list.add(task);
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

	/*
	 * query numbers of tasks dealing(Administrator and InspectionPersonnel)
	 * default value "status = 1" -- Administrator else "status = 2" --
	 * InspectionPersonnel
	 */
	public int qureyNumOfTaskDealing(String role) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from TaskList where Status=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, 1);
			if (role.trim().equals("InspectionPersonnel")) {
				ps.setInt(1, 2);
			}
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

	public LinkedList<TaskList> qureyTaskDealingByPage(int start, int stepLength, String role) {
		LinkedList<TaskList> list = new LinkedList<TaskList>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from TaskList where Status=? limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setInt(2, start);
			ps.setInt(3, stepLength);
			if (role.trim().equals("InspectionPersonnel")) {
				ps.setInt(1, 1);
			} else if (role.trim().equals("LawInforcing")) {
				ps.setInt(1, 2);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				TaskList task = new TaskList();
				task.setId(rs.getString(1));
				task.setSource(rs.getString(2));
				task.setContent(rs.getString(3));
				task.setHasContent(rs.getInt(4));
				task.setHasImg(rs.getInt(5));
				task.setHasVideo(rs.getInt(6));
				task.setStatus(rs.getInt(7));
				list.add(task);
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

	public int qureyNumOfTaskListDone() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			String sql = "select count(*) from TaskList where Status=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, 3);
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

	/*
	 * query tasks done by page
	 */
	public LinkedList<TaskList> queryTaskDoneByPage(int start, int stepLength) {
		LinkedList<TaskList> list = new LinkedList<TaskList>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			String sql = "select * from TaskList where status=? limit ?,?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, 3);
			ps.setInt(2, start);
			ps.setInt(3, stepLength);
			rs = ps.executeQuery();
			while (rs.next()) {
				TaskList task = new TaskList();
				task.setId(rs.getString(1));
				task.setSource(rs.getString(2));
				task.setContent(rs.getString(3));
				task.setHasContent(rs.getInt(4));
				task.setHasImg(rs.getInt(5));
				task.setHasVideo(rs.getInt(6));
				task.setStatus(rs.getInt(7));
				list.add(task);
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


	public int updateTaskStatus(String id, int status) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int num = 0;

		try {
			String sql = "update TaskList set status=? where id=?";
			ps = DBConnection.conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setString(2, id);
			num = ps.executeUpdate();
			return num;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} 

	}
}
