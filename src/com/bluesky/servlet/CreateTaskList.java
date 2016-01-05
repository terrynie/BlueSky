package com.bluesky.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bluesky.bean.TaskList;
import com.bluesky.dao.TaskListDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * Servlet implementation class createTaskList
 */
@WebServlet("/jsp/createTaskList")
public class CreateTaskList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTaskList() {
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
		
		//-----------------------------------------upload img---------------------------------------
				String saveDirectory="D:/upload";
				File savedir=new File(saveDirectory);
				if(!savedir.exists()){//如果上传目录不存在则创建它
					savedir.mkdirs();
				}
				
				
				int maxPostSize = 3 * 5 * 1024 * 1024 ;  //上传大小限制：5M
				FileRenamePolicy policy =(FileRenamePolicy)new DefaultFileRenamePolicy(); 
			    MultipartRequest multi;
				multi = new MultipartRequest(request, saveDirectory, maxPostSize,"UTF-8",policy);
				Enumeration<String> files = multi.getFileNames(); 
				while(files.hasMoreElements()){
				String name=files.nextElement();
				File f = multi.getFile(name);
				System.out.println(f.getPath()+" "+f.getName());
				if(f!=null){
				   String fileName = f.getName();
				   System.out.println(saveDirectory);
				   
				   String newFileName=String.valueOf(System.currentTimeMillis());
				   newFileName+=(new Random()).nextInt(20)+fileName.substring(fileName.lastIndexOf("."));
			        File sServerFile= new File(saveDirectory+"\\"+newFileName);
			        System.out.println(saveDirectory+"\\" +newFileName);
			        if(sServerFile.exists()){//将先前上传的文件删除掉，这样重命名才能成功
			   	       sServerFile.delete();
			        }        
			               
				   f.renameTo(sServerFile);//重命名文件
				}
				}
		//--------------------------------------------------
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
		taskList.setHasVideo(0);
		taskList.setStatus(0);
		if (src == null) {
			taskList.setHasImg(0);
			taskList.setHasVideo(0);
		} else if ("img".equals(src_split) || "png".equals(src_split) || "jpeg".equals(src_split)
				|| "bmp".equals(src_split) || "gif".equals(src_split)) {
			taskList.setHasImg(1);
		} else {
			taskList.setHasImg(0);
		}
		taskListDao.addTask(taskList);
		
		request.getRequestDispatcher("createTaskList.jsp").forward(request, response);
	}
}
