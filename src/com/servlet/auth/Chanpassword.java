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
 * Servlet implementation class Chanpassword
 */
@WebServlet("/user/Chanpassword")
public class Chanpassword extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public Chanpassword() {
		super();
		this.userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/Views/auth/user/changepassword.jsp";
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
		if (user == null) {
			System.out.println("ban phai dang nhap");
			response.sendRedirect("/myvideo/LoginServlet");
		} else {
			String fullname = user.getFullname();
			String password = user.getPassword();
			String currentpassword = request.getParameter("currentpassword");
			String name = request.getParameter("fullname");
			String passnew = request.getParameter("password");
			String confirmpassword = request.getParameter("confirmpassword");
			if (password.equalsIgnoreCase(currentpassword) && fullname.equalsIgnoreCase(name)) {
				if (passnew.equalsIgnoreCase(confirmpassword)) {
					user.setPassword(confirmpassword);
					this.userDAO.update(user);
					System.out.println("doi password thanh cong");
				}else {
					System.out.println("confirmpassword sai");
				}

			}else {
				System.out.println("full name hoac password sai");
			}
			doGet(request, response);
		}

	}

}
