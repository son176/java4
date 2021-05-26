package com.servlet.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import com.DAO.UserDAO;
import com.base.BaseServlet;
import com.entity.User;
import com.utils.HibernateUtils;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends BaseServlet {
	private static final long serialVersionUID = 1L;
        private UserDAO userDAO;
    
    public Registration() {
        super();
        this.userDAO=new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/Views/auth/user/registration.jsp";
		this.render(request, response, view);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User entity =new User();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
			entity.setRole(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Session session =HibernateUtils.getSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		System.out.println("dang ky thanh cong");
		doGet(request, response);
	}
	}
