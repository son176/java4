package com.servlet.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAO;
import com.base.BaseServlet;
import com.entity.Email;
import com.entity.User;
import com.utils.EmailUtils;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends BaseServlet {
	private static final long serialVersionUID = 1L;
       private UserDAO userDAO;
       private EmailUtils emailUtils;
    public ForgotPassword() {
        super();
        this.userDAO = new UserDAO();
        this.emailUtils = new EmailUtils();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/Views/auth/user/forgotpassword.jsp";
		this.render(request, response, view);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("aaaaaaa");
		try {
			String emailAddress = req.getParameter("email");
			User user = this.userDAO.selectByEmail(emailAddress);

			if(user ==null) {
			 System.out.println("null");
			}else {
				Email email= new Email();
				email.setFrom("congtungheo171996@gmail.com");
				email.setFromPassword("minhhachahoa1996");
				emailUtils.send(email,req);
			}
			resp.sendRedirect(req.getContextPath() + "/LoginServlet");
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}

}
