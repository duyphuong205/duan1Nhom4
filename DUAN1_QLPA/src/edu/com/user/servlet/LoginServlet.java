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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = CookieUtils.get("id", request);
		String password = CookieUtils.get("password", request);
		request.setAttribute("id", username);
		request.setAttribute("password", password);
		SessionUtils.add("id", username, request);
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_LOGIN_PAGE);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			loginForm lgf = new loginForm();
			BeanUtils.populate(lgf, request.getParameterMap());
			UserDAO userdao = new UserDAO();
			User user = userdao.chekckLogin(lgf.getId(), lgf.getPassword());
			if (user != null) {
				SessionUtils.add("id", user.getId(), request);
				if (lgf.isRemember()) {
					CookieUtils.add("id", lgf.getId(), 24, response);
					CookieUtils.add("password", lgf.getPassword(), 24, response);
				} else {
					CookieUtils.add("id", lgf.getId(), 0, response);
					CookieUtils.add("password", lgf.getPassword(), 0, response);
				}
				request.setAttribute("isLogin", true);
				request.setAttribute("admin", user.getAdmin());
				request.getRequestDispatcher("HomeServlet").forward(request, response);
				return;
			}
			request.setAttribute("error", "Username Hoặc Password Không Đúng!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_LOGIN_PAGE);
	}

}
