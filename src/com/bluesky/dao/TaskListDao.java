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
					+ task.getContent() + "','"+task.isHasContent()+"','" + task.isHasImg() + "','" + task.isHasVideo() + "', '" + task.isDone()
					+ "');";
			stmt.execute(sql);
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
			stmt.execute(sql);
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
				task.setHasContent(rs.getBoolean(4));
				task.setHasImg(rs.getBoolean(5));
				task.setHasVideo(rs.getBoolean(6));
				task.setDone(rs.getBoolean(7));
				list.add(task);
			}
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
			while(rs.next()){
			task.setId(rs.getString(1));
			task.setSource(rs.getString(2));
			task.setContent(rs.getString(3));
			task.setHasContent(rs.getBoolean(4));
			task.setHasImg(rs.getBoolean(5));
			task.setHasVideo(rs.getBoolean(6));
			task.setDone(rs.getBoolean(7));}
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
				task.setHasContent(rs.getBoolean(4));
				task.setHasImg(rs.getBoolean(5));
				task.setHasVideo(rs.getBoolean(6));
				task.setDone(rs.getBoolean(7));
				list.add(task);
			}
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	// query numbers of tasks done
	public int qureyNumOfTaskDone() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from TaskList where isdone=1";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	// query numbers of tasks not done
	public int qureyNumOfTaskNotDone() {
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		int sum = 0;
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select count(*) from TaskList where isdone=0";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}

	// query tasks have done
	public LinkedList<TaskList> queryTaskDone(int start, int stepLength) {
		LinkedList<TaskList> list = new LinkedList<TaskList>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from TaskList where isdone=1 limit " + start + "," + stepLength + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TaskList task = new TaskList();
				task.setId(rs.getString(1));
				task.setSource(rs.getString(2));
				task.setContent(rs.getString(3));
				task.setHasContent(rs.getBoolean(4));
				task.setHasImg(rs.getBoolean(5));
				task.setHasVideo(rs.getBoolean(6));
				task.setDone(rs.getBoolean(7));
				list.add(task);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}

	// query tasks not done
	public LinkedList<TaskList> queryTaskNotDone(int start, int stepLength) {
		LinkedList<TaskList> list = new LinkedList<TaskList>();
		if (DBConnection.conn == null) {
			DBConnection.openConn();
		}
		try {
			Statement stmt = DBConnection.conn.createStatement();
			String sql = "select * from TaskList where isdone=0 limit " + start + "," + stepLength + ";";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TaskList task = new TaskList();
				task.setId(rs.getString(1));
				task.setSource(rs.getString(2));
				task.setContent(rs.getString(3));
				task.setHasContent(rs.getBoolean(4));
				task.setHasImg(rs.getBoolean(5));
				task.setHasVideo(rs.getBoolean(6));
				task.setDone(rs.getBoolean(7));
				list.add(task);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return list;
		}
	}
}
