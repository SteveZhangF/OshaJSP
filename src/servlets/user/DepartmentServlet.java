package servlets.user;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.user.User;
import bean.user.data.Company;
import bean.user.data.Department;
import bean.user.data.Employee;
import dao.user.data.DepartmentDAO;
import dao.user.data.EmployeeDAO;
import database.dao.factory.DAOFactoryImpl;

/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/department")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartmentServlet() {
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
			list(request, response);
			break;
		case "edit":
			edit(request, response);
			break;
		case "save":
			save(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		default:
			break;
		}
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		String superDepID = request.getParameter("superDepartmentID");
		String depid = request.getParameter("department_id");
		String depName = request.getParameter("department_name");
		String depAddress = request.getParameter("department_address");
		String depPhone = request.getParameter("department_phone");
		Department department = DAOFactoryImpl.getDepartmentDAO().getDepartmentbyID(depid);
		if (department == null) {
			department = new Department();
			Department supD = DAOFactoryImpl.getDepartmentDAO().getDepartmentbyID(superDepID);
			if (supD != null) {
				supD.addSubDepartment(department);
			} else {
				Company company = ((User) request.getSession().getAttribute("user")).getCompany();
				company.addDepartment(department);
			}
		}
		department.setDepartment_name(depName);
		department.setDepartment_address(depAddress);
		department.setDepartment_telephone(depPhone);
		DAOFactoryImpl.getDepartmentDAO().save(department);
		
		try {
			response.getWriter().write("success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("tablesource", "department");
		try {
			request.getRequestDispatcher("/table.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		String departmentID = request.getParameter("department_id");
		if (departmentID != null) {
			Department department = DAOFactoryImpl.getDepartmentDAO().getDepartmentbyID(departmentID);
			request.setAttribute("department", department);
		}
		try {
			request.getRequestDispatcher("department_edit.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String de_id = request.getParameter("department_id");
		DepartmentDAO dao = DAOFactoryImpl.getDepartmentDAO();
		String result = "";

		Department department = dao.getDepartmentbyID(de_id);
		if (department == null) {
			result = "no such department";
		} else {
			dao.delete(department.getUuid());
		}
	}

}
