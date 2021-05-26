package com.servlet.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.DAO.UserDAO;
import com.base.BaseServlet;
import com.entity.User;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/user/EditServlet")
public class EditServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public EditServlet() {
		super();
		this.userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/Views/auth/user/edit-profile.jsp";
		this.render(request, response, view);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String fullname = request.getParameter("fullname");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		user.setFullname(fullname);
		user.setPassword(pass);
		user.setEmail(email);
		this.userDAO.update(user);
		response.sendRedirect(request.getContextPath() + "/trangchu");

	}

}
