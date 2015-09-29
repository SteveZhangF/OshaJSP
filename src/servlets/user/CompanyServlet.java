package servlets.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.user.User;
import bean.user.data.Company;
import database.dao.factory.DAOFactoryImpl;

/**
 * Servlet implementation class CompanyServlet
 */
@WebServlet("/company")
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompanyServlet() {
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
		switch (action) {
		case "edit":
			edit(request, response);
			break;
		case "save":
			save(request, response);
			break;
		case "update":
			update(request, response);
		case "showTreeMenu":
			showTreeMenu(request, response);
			break;
		default:
			break;
		}

	}

	private void showTreeMenu(HttpServletRequest request, HttpServletResponse response) {

		User user = (User) request.getSession().getAttribute("user");
		String user_id = user.getUuid();
		try {
			Company company = DAOFactoryImpl.getCompanyDAO().getCompanybyUserID(user_id);
			request.setAttribute("company", company);
			System.out.println(company);
			request.getRequestDispatcher("/customer/layout/company_menu.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String company_name = request.getParameter("company_name");
		String company_address = request.getParameter("company_address");
		String company_phone = request.getParameter("company_phone");

		Company company = DAOFactoryImpl.getCompanyDAO().getCompanybyID(request.getParameter("company_id"));
		company.setAddress(company_address);
		company.setName(company_name);
		company.setPhone(company_phone);
		DAOFactoryImpl.getCompanyDAO().save(company);
		// DAOFactoryImpl.getUserDAO().save((User)
		// request.getSession().getAttribute("user"));
		try {
			response.getWriter().write("success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {

		User user = (User) request.getSession().getAttribute("user");
		String user_id = user.getUuid();
		try {
			Company company = DAOFactoryImpl.getCompanyDAO().getCompanybyUserID(user_id);
			request.setAttribute("company", company);
			request.getRequestDispatcher("/company_edit.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {

		String company_id = request.getParameter("company_id");

		Company company = DAOFactoryImpl.getCompanyDAO().getCompanybyID(company_id);
		if (company == null) {
			company = new Company();
			User user = (User) request.getSession().getAttribute("user");
			user.setCompany(company);
		}

		String company_name = request.getParameter("company_name");
		String company_address = request.getParameter("company_address");
		String company_phone = request.getParameter("company_phone");

		company.setAddress(company_address);
		company.setName(company_name);
		company.setPhone(company_phone);
		DAOFactoryImpl.getCompanyDAO().save(company);

		try {
			response.getWriter().write("success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
