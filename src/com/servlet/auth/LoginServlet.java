package com.servlet.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.base.BaseServlet;
import com.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends BaseServlet {
	private UserDAO userDAO;

	public LoginServlet() {
		super();
		this.userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/Views/auth/login.jsp";
		this.render(request, response, view);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String pass = request.getParameter("password");
			User entity = this.userDAO.login(email, pass);
			HttpSession session = request.getSession();
			if (entity == null) {
				session.setAttribute("error", "invalid email or password");
				response.sendRedirect(request.getContextPath() + "/LoginServlet");
			} else {
				session.setAttribute("user", entity);
				session.setAttribute("isLogin", true);
				session.setAttribute("error", "");
				if (entity.getRole() == 1) {
					response.sendRedirect(request.getContextPath() + "/trangchu");
				} else {
					response.sendRedirect(request.getContextPath() + "/admin/VideosManagement");
				}
			}
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
	}

}
