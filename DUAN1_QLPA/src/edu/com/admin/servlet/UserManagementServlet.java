package edu.com.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.com.dao.UserDAO;
import edu.com.dao.VideoDAO;
import edu.com.model.User;
import edu.com.model.Video;
import edu.com.utils.PageInfo;
import edu.com.utils.PageType;

/**
 * Servlet implementation class UserManagementServlet
 */
@WebServlet({"/UserManagementServlet","/UserManagementServlet/create","/UserManagementServlet/update","/UserManagementServlet/delete"
	,"/UserManagementServlet/reset","/UserManagementServlet/edit"})
public class UserManagementServlet extends HttpServlet {
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		User user = new User();
		if(url.contains("edit")) {
			edit(request, response);
		}else if(url.contains("delete")) {
			delete(request, response);
		}else if(url.contains("reset")) {
			
		}
		findAll(request, response);
		PageInfo.ForWardToLayoutAdmin(request, response, PageType.USER_MANAGEMENT_PAGE);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String url=request.getRequestURL().toString();
	if(url.contains("create")) {
		insert(request, response);
	}else if(url.contains("update")) {
		update(request, response);
	}else if(url.contains("delete")) {
		delete(request, response);
	}else if(url.contains("reset")) {
		
	}
	findAll(request, response);
	PageInfo.ForWardToLayoutAdmin(request, response, PageType.USER_MANAGEMENT_PAGE);
	
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDAO udao = new UserDAO();
			List<User> list= udao.findbyAll();
			request.setAttribute("users", list);
		}catch(Exception e ) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
	
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDAO dao = new UserDAO();
			String userID = request.getParameter("id");
			User user = dao.findByID(userID);
			request.setAttribute("EditUsers", user);
		} catch (Exception e) {
			request.setAttribute("error", "Error:" + e.getMessage());
		}
	
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDAO dao = new UserDAO();
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			dao.insert(user);
			request.setAttribute("mess", "Them thanh cong!!!");
		} catch (Exception e) {
			request.setAttribute("error", "Error:" + e.getMessage());
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDAO dao = new UserDAO();
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			//khong duoc phep cap nhap id
			dao.findByID(user.getId());
			dao.update(user);
			request.setAttribute("mess", "Cap nhat thanh cong!!!");
			request.setAttribute("EditUsers", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Cap nhat that bai!!!");
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDAO dao = new UserDAO();
			String userID = request.getParameter("id");
			dao.delete(userID);
			request.setAttribute("mess", "Xoa thanh cong!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Xoa that bai!!!");
		}
	}
}
