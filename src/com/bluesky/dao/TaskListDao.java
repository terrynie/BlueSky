package com.bluesky.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bluesky.bean.TaskList;
import com.bluesky.database.DBConnection;

public class TaskListDao {
	// add a task
	public boolean addTask(TaskList task) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "insert into TaskList values('" + task.getId() + "','" + task.getSource() + "','"
					+ task.getContent() + "','" + task.getContent() + "','" + task.getHasImg() + "','"
					+ task.getHasVideo() + "','" + task.getStatus() + "');";
			stmt.executeUpdate(sql);
			DBConnection.closeStatement(stmt);
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "delete from TaskList where id='" + task.getId() + "';";
			stmt.executeUpdate(sql);
			DBConnection.closeStatement(stmt);
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from TaskList";
			ResultSet rs = stmt.executeQuery(sql);
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
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query one task
	public TaskList queryOne(String id) {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		TaskList task = new TaskList();
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from TaskList where id = '" + id + "';";
			ResultSet rs = stmt.executeQuery(sql);
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
			DBConnection.closeStatement(stmt);
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from TaskList limit '" + start + "','" + stepLength + "';";
			ResultSet rs = stmt.executeQuery(sql);
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
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query numbers of tasks
	public int qureyNumOfTaskList() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from TaskList";
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from TaskList where Status=0";
			if (role.trim().equals("InspectionPersonnel")) {
				sql = "select count(*) from TaskList where Status=1";
			} else if (role.trim().equals("LawInforcing")) {
				sql = "select count(*) from TaskList where Status=2";
			}
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

	public LinkedList<TaskList> qureyTaskWaitDealedByPage(int start, int stepLength, String role) {
		LinkedList<TaskList> list = new LinkedList<TaskList>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from TaskList where Status=0 limit " + start + "," + stepLength + ";";
			if (role.trim().equals("InspectionPersonnel")) {
				sql = "select * from TaskList where Status=1 limit " + start + "," + stepLength + ";";
			} else if (role.trim().equals("LawInforcing")) {
				sql = "select * from TaskList where Status=2 limit " + start + "," + stepLength + ";";
			}
			ResultSet rs = stmt.executeQuery(sql);
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
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
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
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from TaskList where Status=1";
			if (role.trim().equals("InspectionPersonnel")) {
				sql = "select count(*) from TaskList where Status = 2";
			}
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
	
	public LinkedList<TaskList> qureyTaskDealingByPage(int start, int stepLength, String role) {
		LinkedList<TaskList> list = new LinkedList<TaskList>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from TaskList where Status=0 limit " + start + "," + stepLength + ";";
			if (role.trim().equals("InspectionPersonnel")) {
				sql = "select * from TaskList where Status=1 limit " + start + "," + stepLength + ";";
			} else if (role.trim().equals("LawInforcing")) {
				sql = "select * from TaskList where Status=2 limit " + start + "," + stepLength + ";";
			}
			ResultSet rs = stmt.executeQuery(sql);
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
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}
	
	public int qureyNumOfTaskListDone() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from TaskList where Status=3";
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

	/*
	 * query tasks done by page
	 */
	public LinkedList<TaskList> queryTaskDoneByPage(int start, int stepLength) {
		LinkedList<TaskList> list = new LinkedList<TaskList>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from TaskList where Status=3 limit " + start + "," + stepLength + ";";
			ResultSet rs = stmt.executeQuery(sql);
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
			DBConnection.closeStatement(stmt);
			DBConnection.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

}
