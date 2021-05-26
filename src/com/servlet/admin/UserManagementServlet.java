package com.servlet.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.DAO.UserDAO;
import com.base.BaseAdminServlet;
import com.entity.User;
import com.entity.Video;

/**
 * Servlet implementation class UserManagementServlet
 */
@WebServlet({ "/admin/UserManagementServlet", "/admin/UserManagementServlet/update",
		"/admin/UserManagementServlet/delete", "/admin/UserManagementServlet/edit" ,"/admin/UserManagementServlet/reset"})
public class UserManagementServlet extends BaseAdminServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public UserManagementServlet() {
		super();
		this.userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI().toString();
		if (uri.contains("edit")) {
			this.edit(request, response);
		} else {
			List<User> list = this.userDAO.findAll();
			request.setAttribute("list", list);
			String view = "/Views/admin/users/user.jsp";
			this.render(request, response, view);
		}

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		try {
			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
			User uadmin = userDAO.findById(id);
			request.setAttribute("uadmin", uadmin);
			String view = "/Views/admin/users/user.jsp";
			this.render(request, response, view);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI().toString();
		try {
			if (url.contains("delete")) {
				delete(request, response);
			} else if (url.contains("update")) {
				update(request, response);
			} else if (url.contains("reset")) {
				reset(request, response);
			}
			String view = "/Views/admin/users/user.jsp";
			this.render(request, response, view);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void reset(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User uadmin = new User();
		request.setAttribute("uadmin", uadmin);
		HttpSession session = request.getSession();
		session.setAttribute("message", "");
		response.sendRedirect(request.getContextPath() + "/admin/UserManagementServlet");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User uadmin = new User();
		try {
			BeanUtils.populate(uadmin, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		userDAO.update(uadmin);
		request.setAttribute("uadmin", uadmin);
		response.sendRedirect(request.getContextPath() + "/admin/UserManagementServlet");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String userid = request.getParameter("id");
			int id = Integer.parseInt(userid);
			User uadmin = userDAO.findById(id);
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if(uadmin.getId().equals(user.getId())) {
				session.setAttribute("message", "Ban khong the xoa chinh minh");
			}else {
				userDAO.delete(uadmin);
				session.setAttribute("message", "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/admin/UserManagementServlet");
	}

}
