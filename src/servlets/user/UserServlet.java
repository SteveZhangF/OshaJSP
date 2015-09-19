package servlets.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PRIVATE_MEMBER;

import bean.user.User;
import dao.user.UserDAO;
import database.dao.factory.DAOFactoryImpl;
import global.MD5;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		System.out.println(action);
		switch (action) {
		case "login":
			login(request, response);
			break;
		case "register":
			register(request, response);
			break;
		case "logout":
			logout(request, response);
			break;
		case "list":
			break;
		default:

			break;
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		System.out.println(email);

		try {
			int check = DAOFactoryImpl.getUserDAO().check(email, pwd);
			if (check == 0) {
				User user = DAOFactoryImpl.getUserDAO().getUser(email);
				request.getSession().setAttribute("user", user);
			}
			response.getWriter().write("" + check);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response){
		request.getSession().setAttribute("user",null);
		try {
			response.getWriter().write("0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email").toLowerCase();
		String pwd = request.getParameter("password");
		User user = new User();
		user.setUser_email(email);
		user.setUser_password_digest(MD5.toMD5(pwd));
		try {
			DAOFactoryImpl.getUserDAO().save(user);
			response.getWriter().write("0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
