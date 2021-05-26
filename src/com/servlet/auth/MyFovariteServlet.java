package com.servlet.auth;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.DAO.FavoriteDAO;
import com.base.BaseServlet;
import com.entity.Favorite;
import com.entity.User;
import com.entity.Video;

/**
 * Servlet implementation class LikeVideoServlet
 */
@WebServlet("/user/LikeVideoServlet")
public class MyFovariteServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteDAO favoriteDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyFovariteServlet() {
		super();
		this.favoriteDAO = new FavoriteDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			System.out.println("ban phai dang nhap");
			response.sendRedirect("/myvideo/LoginServlet");
		} else {
			List<Favorite> list = this.favoriteDAO.findID(user);
			List<Video> listvideo = new ArrayList<Video>();
			if (list.isEmpty()) {
				System.out.println("khong co FAVORITE");
			} else {
				for (Favorite favorite : list) {
					listvideo.add(favorite.getVideo());
				}
				request.setAttribute("listvideo", listvideo);
			}

		}
		String view = "/Views/auth/user/like.jsp";
		this.render(request, response, view);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
