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
import bean.user.data.Company;
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
		case "getUserDetail":
			getUserDetail(request, response);
			break;
		case "saveUser":
			saveUser(request, response);
			break;
		default:
			break;
		}
	}
	
	private void saveUser(HttpServletRequest request, HttpServletResponse response){
		
		String user_id = request.getParameter("user_id");
		Company company = DAOFactoryImpl.getUserDAO().getUserbyID(user_id).getCompany();
		String[] modules = request.getParameterValues("modules");
		for(Module mNow:company.getModules()){
			mNow.getCompanies().remove(company);
		}
		company.getModules().clear();
		DAOFactoryImpl.getCompanyDAO().save(company);
		for(String module:modules){
			Module mo = DAOFactoryImpl.getModuleDAO().getModuleById(module);
			company.addModule(mo);
		}
		DAOFactoryImpl.getCompanyDAO().save(company);
	}
	
	private void getUserDetail(HttpServletRequest request, HttpServletResponse response){
		String user_id = request.getParameter("user_id");
		User user = DAOFactoryImpl.getUserDAO().getUserbyID(user_id);
		request.setAttribute("user", user);
		Company company = user.getCompany();
		List<Module> modulesHas = company.getModules();
		request.setAttribute("modulesHas", modulesHas);
		List<Module> modules = DAOFactoryImpl.getModuleDAO().list();
		request.setAttribute("modulesAll", modules);
		
		
		try {
			request.getRequestDispatcher("/dashboard/layout/user_detail.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				jso.put("company_name", user.getCompany().getName());
				jso.put("company_id", user.getCompany().getUuid());
			}
			ja.add(jso);
		}
		JSONObject result = new JSONObject();
		result.put("data",	ja);
		try {
			response.getWriter().write(result.toString());
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
