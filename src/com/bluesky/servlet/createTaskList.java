package com.bluesky.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bluesky.bean.TaskList;
import com.bluesky.dao.TaskListDao;

/**
 * Servlet implementation class createTaskList
 */
@WebServlet("/jsp/createTaskList")
public class createTaskList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createTaskList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		TaskList taskList=new TaskList();
		TaskListDao taskListDao=new TaskListDao();
		String id=request.getParameter("id");
		String src=request.getParameter("src");
		String content=request.getParameter("content");
		String src_split = null;
		if(src != null){
			System.out.println(src);
			String [] srcArray=src.split(".");
			System.out.println(srcArray[0]);
			src_split = srcArray[0];
		}
		taskList.setId(id);
		taskList.setContent(content);
		taskList.setSource(session.getAttribute("dept").toString().trim());
		taskList.setHasContent(1);
		taskList.setStatus(0);
		if (src == null) {
			taskList.setHasImg(0);
			taskList.setHasVideo(0);
		} else if ("img".equals(src_split) || "png".equals(src_split) || "jpeg".equals(src_split)
				|| "bmp".equals(src_split) || "gif".equals(src_split)) {
			taskList.setHasImg(1);
			taskList.setHasVideo(0);
		} else {
			taskList.setHasVideo(1);
			taskList.setHasImg(0);
		}
		taskListDao.addTask(taskList);
		request.getRequestDispatcher("createTaskList.jsp").forward(request, response);
	}
}
