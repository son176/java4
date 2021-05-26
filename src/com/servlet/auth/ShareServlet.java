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

import com.DAO.ShareDAO;
import com.DAO.UserDAO;
import com.DAO.VideoDAO;
import com.entity.Favorite;
import com.entity.Share;
import com.entity.User;
import com.entity.Video;

/**
 * Servlet implementation class ShareServlet
 */
@WebServlet("/user/ShareServlet")
public class ShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private ShareDAO shareDAO;
	private VideoDAO videoDAO;
    public ShareServlet() {
        super();
       this.shareDAO = new ShareDAO();
       this.userDAO = new UserDAO();
       this.videoDAO = new VideoDAO();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoid = request.getParameter("id");
		int id = Integer.parseInt(videoid);
		Video video = this.videoDAO.findById(id);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Share> list = this.shareDAO.findID(user);
		boolean check =true;
		for (Share favorite : list) {
			if (video.getId()==favorite.getVideo().getId()) {
				check=false;
				break;
			}
		}
		if (check) {
			Date date = new Date();
			Share favo = new Share();
			favo.setShare_date(date);
			favo.setUser(user);
			favo.setEmails(user.getEmail());
			favo.setVideo(video);
			this.shareDAO.insert(favo);
			response.sendRedirect(request.getContextPath() + "/trangchu");
		} else {
			response.sendRedirect(request.getContextPath() + "/trangchu");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
