package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.form.module.Module;
import bean.user.User;
import database.dao.factory.DAOFactoryImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class UserServletAdmin
 */
@WebServlet("/user_admin")
public class UserServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServletAdmin() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch (action) {
		case "list":
			showlist(request, response);
			break;
		case "userJSON":
			userJSON(request, response);
			break;
		default:
			break;
		}
	}

	private void userJSON(HttpServletRequest request, HttpServletResponse response) {
		List<User> list = DAOFactoryImpl.getUserDAO().list();
		JSONArray ja = new JSONArray();
		for (User user : list) {
			JSONObject jso = new JSONObject();
			jso.put("id", user.getUuid());
			jso.put("email", user.getUser_email());
			if (user.getCompany() != null) {
				jso.put("company_name", user.getCompany().getCompany_name());
			}
			ja.add(jso);
		}
		try {
			response.getWriter().write(ja.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showlist(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("dashboardlayout/usertable.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
