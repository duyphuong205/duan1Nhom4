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

import edu.com.supportModel.loginForm;
import edu.com.utils.CookieUtils;
import edu.com.utils.PageInfo;
import edu.com.utils.PageType;
import edu.com.utils.SessionUtils;

/**
 * Servlet implementation class ChangepasswordSevlet
 */
@WebServlet("/ChangepasswordSevlet")
public class ChangepasswordSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_CHANGEPASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try {
//			User user= new User();
//			BeanUtils.populate(user, request.getParameterMap());
//			UserDAO userdao = new UserDAO();
//			
//			if (user.getPassword() == null) {
//				request.setAttribute("error", "Khong khop!!");
//				}else {
//					userdao.findByID(user.getId());
//					userdao.changpassword(user);
//					request.setAttribute("mess", "Doi thanh cong!!!");
//				} 
//		}catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("error", e.getMessage());
//		}
//		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_CHANGEPASSWORD_PAGE);

}
}




































