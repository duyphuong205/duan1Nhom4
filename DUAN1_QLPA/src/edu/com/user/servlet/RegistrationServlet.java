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

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_REGISTRATION_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user,request.getParameterMap());
			UserDAO udao =new UserDAO();
			udao.signIn(user);
			request.setAttribute("mess","Dang Ky Thanh Cong");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error",e.getMessage());
			
		}
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_REGISTRATION_PAGE);
	}

}

















