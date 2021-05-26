package com.servlet.auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.FavoriteDAO;
import com.base.BaseAdminServlet;
import com.entity.Favorite;
import com.entity.User;

/**
 * Servlet implementation class UnlikeServlet
 */
@WebServlet("/user/UnlikeServlet")
public class UnlikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteDAO favoriteDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UnlikeServlet() {
		super();
		this.favoriteDAO = new FavoriteDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String favoriteID = request.getParameter("id");
		int id = Integer.parseInt(favoriteID);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Favorite> list = this.favoriteDAO.findID(user);
		for (Favorite favorite : list) {
			if(favorite.getVideo().getId()==id) {
				favoriteDAO.delete(favorite);
				break;
			}
		}
		
		
		response.sendRedirect(request.getContextPath()+"/user/LikeVideoServlet");
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
