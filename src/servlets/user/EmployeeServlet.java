package servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.user.User;
import bean.user.data.Company;
import bean.user.data.Department;
import bean.user.data.Employee;
import database.dao.factory.DAOFactoryImpl;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
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

		default:
			break;
		}
	}

	/**
	 * save or update the employee information
	 */
	private void save(HttpServletRequest request, HttpServletResponse response) {
		String department_id = request.getParameter("department_id");

		String employee_id = request.getParameter("employee_id");
		String employee_name = request.getParameter("firstName") + ":" + request.getParameter("lastName");
		String employee_phone = request.getParameter("phoneNumber");
		String employee_email = request.getParameter("email");

		Employee employee = DAOFactoryImpl.getEmployeeDAO().getEmployeebyID(employee_id);

		Department supD = null;
		if (employee == null) {
			employee = new Employee();
			supD = DAOFactoryImpl.getDepartmentDAO().getDepartmentbyID(department_id);
			if (supD != null) {
				supD.addEmployee(employee);
			} else {
				Company company = ((User) request.getSession().getAttribute("user")).getCompany();
				employee.setCompany(company);
			}
		}
		employee.setEmail(employee_email);
		employee.setPhone(employee_phone);
		employee.setName(employee_name);
		DAOFactoryImpl.getEmployeeDAO().save(employee);

		try {
			response.getWriter().write("success!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// department_id : departmentID,
	// employee_id:myid
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		String employee_id = request.getParameter("employee_id");
		if (employee_id != null) {
			Employee department = DAOFactoryImpl.getEmployeeDAO().getEmployeebyID(employee_id);
			request.setAttribute("employee", department);
		}
		try {
			request.getRequestDispatcher("employee_edit.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("tablesource", "employee");
		try {
			request.getRequestDispatcher("/table.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
