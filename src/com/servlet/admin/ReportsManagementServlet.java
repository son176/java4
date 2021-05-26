package com.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.FavoriteDAO;
import com.DAO.ShareDAO;
import com.DAO.VideoDAO;
import com.base.BaseAdminServlet;
import com.entity.Favorite;
import com.entity.FavoriteUserReport;
import com.entity.Share;
import com.entity.FavoriteReport;
import com.entity.User;
import com.entity.Video;





/**
 * Servlet implementation class ReportsManagementServlet
 */
@WebServlet("/admin/ReportsManagementServlet")
public class ReportsManagementServlet extends BaseAdminServlet {
	private static final long serialVersionUID = 1L;
      private VideoDAO videoDAO;
      private FavoriteDAO favoriteDAO;
      private ShareDAO shareDAO;
	public ReportsManagementServlet() {
		super();
		this.videoDAO = new VideoDAO();
		this.favoriteDAO = new FavoriteDAO();
		shareDAO = new ShareDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		reportFavoritesByVideos(request, response);
		reportFavoriteUsersByVideos(request, response);
		String view = "/Views/admin/reports/reports.jsp";
		this.render(request, response, view);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	protected void reportFavoriteUsersByVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String videoid = request.getParameter("videoUserId");
		Integer video_id = 0;
		if(videoid != null ) {
			video_id = Integer.parseInt(videoid);
		}
		try {
			List<Video> vList = this.videoDAO.findAll();
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			List<Share> listShare = shareDAO.findAll();
			
			List<FavoriteUserReport> list = favoriteDAO.reportFavoriteUsersByVideos(video_id);
			request.setAttribute("video_id", video_id);
			request.setAttribute("vidList", vList);
			request.setAttribute("favUsers", list);
			request.setAttribute("listShare", listShare);
		} catch (Exception e) {
	    e.printStackTrace();
		}

	}

	protected void reportFavoritesByVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<FavoriteReport> list = favoriteDAO.reportFavoritesByVideos();
			request.setAttribute("favList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
