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
		default:
			break;
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String company_name = request.getParameter("company_name");
		String company_address = request.getParameter("company_address");
		String company_phone = request.getParameter("company_phone");

		Company company = DAOFactoryImpl.getCompanyDAO().getCompanybyID(request.getParameter("company_id"));
		company.setCompany_address(company_address);
		company.setCompany_name(company_name);
		company.setCompany_phone(company_phone);
		DAOFactoryImpl.getCompanyDAO().save(company);
//		DAOFactoryImpl.getUserDAO().save((User) request.getSession().getAttribute("user"));
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
			if (company == null) {
				request.setAttribute("action", "save");
			} else {
				request.setAttribute("action", "update");
				request.setAttribute("company", company);
			}
			request.getRequestDispatcher("/company_edit.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		String company_name = request.getParameter("company_name");
		String company_address = request.getParameter("company_address");
		String company_phone = request.getParameter("company_phone");

		Company company = new Company();
		company.setCompany_address(company_address);
		company.setCompany_name(company_name);
		company.setCompany_phone(company_phone);
		try {
			DAOFactoryImpl.getCompanyDAO().save(company);

			User user = (User) request.getSession().getAttribute("user");
			user.setCompany(company);
			DAOFactoryImpl.getUserDAO().save(user);
			response.getWriter().write("success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
