package com.servlet.auth;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.FavoriteDAO;
import com.DAO.VideoDAO;
import com.entity.Favorite;
import com.entity.User;
import com.entity.Video;

/**
 * Servlet implementation class LikeServlet
 */
@WebServlet("/user/LikeServlet")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteDAO favoriteDAO;
	private VideoDAO videoDAO;

	public LikeServlet() {
		super();
		this.favoriteDAO = new FavoriteDAO();
		this.videoDAO = new VideoDAO();
		this.videoDAO = new VideoDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String videoid = request.getParameter("id");
		int id = Integer.parseInt(videoid);
		Video video = this.videoDAO.findById(id);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Favorite> list = this.favoriteDAO.findID(user);
		boolean check =true;
		for (Favorite favorite : list) {
			if (video.getId()==favorite.getVideo().getId()) {
				check=false;
				break;
			}
		}
		if (check) {
			Date date = new Date();
			Favorite favo = new Favorite();
			favo.setLike_date(date);
			favo.setUser(user);
			favo.setVideo(video);
			this.favoriteDAO.insert(favo);
			response.sendRedirect(request.getContextPath() + "/trangchu");
		} else {
			response.sendRedirect(request.getContextPath() + "/trangchu");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
