package com.bluesky.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bluesky.bean.WeChat;
import com.bluesky.dao.ConstructionSiteDao;
import com.bluesky.dao.WeChatDao;

/**
 * Servlet implementation class weixin_infoServlet
 */
@WebServlet("/jsp/weixin_infoServlet")
public class weixin_infoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public weixin_infoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String weChatNo="weChatNo"; //weChatNo is the custom's wechat account,it's need to be replaced 
		WeChat weChat=new WeChat();
		WeChatDao weChatDao=new WeChatDao();
		ConstructionSiteDao constructionIdDao=new ConstructionSiteDao();
		String constructionId=request.getParameter("select_constructionId");
		weChat.setConstructionId(constructionIdDao.queryIdByName(constructionId));
		System.out.println(constructionId);
		//weChat.setConstructionId(request.getParameter("select_constructionId"));
		weChat.setContent(request.getParameter("content"));
		weChat.setDistrict(request.getParameter("select_district"));
		weChat.setId(request.getParameter("id"));
		weChat.setStreet(request.getParameter("select_street"));
		weChat.setWeChatNo(weChatNo);
		if(!("").equals(request.getParameter("src"))){
			weChat.setHasImg(1);
			weChat.setHasVideo(1);
		}
		weChatDao.addManager(weChat);
	}

}
