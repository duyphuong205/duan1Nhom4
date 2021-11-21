package edu.com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.com.dao.UserDAO;
import edu.com.model.User;
import edu.com.utils.PageInfo;
import edu.com.utils.PageType;
import edu.com.utils.SessionUtils;

/**
 * Servlet implementation class EditprofileServet
 */
@WebServlet("/EditprofileServet")
public class EditprofileServet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_EDITPROFILE_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		User user= new User();
		BeanUtils.populate(user,request.getParameterMap());

		UserDAO userdao = new UserDAO();
		//lấy v�? id của đối tượng user
		User oldsuer=userdao.findByID(user.getId());
		userdao.editProfile(user);
		request.setAttribute("mess", "Chỉnh sửa thành công!!!");
	}catch(Exception e) {
		e.printStackTrace();
		request.setAttribute("error","Chỉnh sửa thất bại!!!");
	}
	PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_EDITPROFILE_PAGE);
	}

}















