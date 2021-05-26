package com.servlet.auth;

import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;

import com.DAO.VideoDAO;
import com.base.BaseServlet;
import com.entity.User;
import com.entity.Video;
import com.utils.HibernateUtils;
@WebServlet("/trangchu")
public class HomeServlet extends BaseServlet {
	private VideoDAO videoDAO;
	public HomeServlet() {
		this.videoDAO = new VideoDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageStr = req.getParameter("page");
		String limitStr = req.getParameter("limit");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int limit = limitStr == null ? 6 : Integer.parseInt(limitStr);
		int offset = limit * (page - 1);
		List<Video> listVideos = this.videoDAO.pagiate(offset, limit);
		List<Video> listVideo = this.videoDAO.findAll();
		int listVideoSize = listVideo.size();
		if(listVideoSize%6==0) {
			listVideoSize = listVideoSize/6;
		}else {
			listVideoSize = listVideoSize/6 +1;
		}
		req.setAttribute("listVideoSize", listVideoSize);
		req.setAttribute("listVideos", listVideos);
		req.setAttribute("page", page);
		String view = "/Views/auth/user/home.jsp";
		this.render(req, resp, view);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
