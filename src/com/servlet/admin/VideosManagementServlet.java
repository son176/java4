package com.servlet.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.DAO.VideoDAO;
import com.base.BaseAdminServlet;
import com.base.BaseServlet;
import com.entity.Video;

/**
 * Servlet implementation class VideosManagementServlet
 */
@WebServlet({ "/admin/VideosManagement", "/admin/VideosManagement/create", "/admin/VideosManagement/update",
		"/admin/VideosManagement/delete", "/admin/VideosManagement/reset", "/admin/VideosManagement/edit" })
public class VideosManagementServlet extends BaseAdminServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;

	public VideosManagementServlet() {
		super();
		this.videoDAO = new VideoDAO();
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
			this.index(request, response);
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Video> listvideo = this.videoDAO.findAll();
		request.setAttribute("listvideo", listvideo);
		String view = "/Views/admin/videos/video.jsp";
		this.render(request, response, view);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			String idStr = request.getParameter("id");
			int id = Integer.parseInt(idStr);
			Video video = videoDAO.findById(id);
			request.setAttribute("video", video);
			String view = "/Views/admin/videos/video.jsp";
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
			if (url.contains("create")) {
				create(request, response);
			} else if (url.contains("delete")) {
				delete(request, response);
			} else if (url.contains("update")) {
				update(request, response);
			} else if (url.contains("reset")) {
				reset(request, response);
			}
			String view = "/Views/admin/videos/video.jsp";
			this.render(request, response, view);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void reset(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Video video = new Video();
		request.setAttribute("video", video);
		response.sendRedirect(request.getContextPath() + "/admin/VideosManagement");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {

			e.printStackTrace();
		}

		videoDAO.update(video);
		request.setAttribute("video", video);
		response.sendRedirect(request.getContextPath() + "/admin/VideosManagement");
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String videoId = request.getParameter("id");
			int id = Integer.parseInt(videoId);
			Video video = videoDAO.findById(id);
			videoDAO.delete(video);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/admin/VideosManagement");
	}

	protected void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {

			e.printStackTrace();
		}
		videoDAO.store(video);
		response.sendRedirect(request.getContextPath() + "/admin/VideosManagement");
	}

}