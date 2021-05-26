package com.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	protected void render(HttpServletRequest req, HttpServletResponse resp, String view) throws ServletException, IOException {
		req.setAttribute("view", view);
		req.getRequestDispatcher("/Views/auth/layout.jsp").forward(req, resp);
	}
}
