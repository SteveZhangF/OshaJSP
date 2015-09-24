package servlets.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.form.Form;
import database.dao.factory.DAOFactoryImpl;
import form.parser.FormOutputHelper;
import servlets.form.helpers.formsgenerator.FormGenerator;
import servlets.form.helpers.recordgenerator.RecordGenerator;

/**
 * Servlet implementation class UserForm
 */
@WebServlet("/userform")
public class UserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserFormServlet() {
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
		case "showEmployeeForm":
			// showEmployeeForm(request, response);
			System.err.println("sha bi le ba");
			break;
		case "showEmployeeFormSelectJson":
			showEmployeeFormSelectJson(request, response);
			break;
		case "viewform":
			viewForm(request, response);
			break;
		case "submitform":
			submitForm(request, response);
			break;
		default:
			break;
		}
	}

	private void submitForm(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String recordid = request.getParameter("record_id");
		
		RecordGenerator erg = new RecordGenerator(DAOFactoryImpl.getOrganizationElementDAO().getOEbyID(id),recordid);
		Map<String, String[]> paraMap = request.getParameterMap();
		for (String key : paraMap.keySet()) {
			if (key.length() != 32) {
				continue;
			}
			erg.addRecordComponent(key, request.getParameter(key));
		}
		erg.save();
	}

	private void viewForm(HttpServletRequest request, HttpServletResponse response) {
		String form_id = request.getParameter("form_id");
		String oe_id = request.getParameter("oe_id");
		// TODO
		String form = FormGenerator.getOEForm(form_id, oe_id);
		try {
			response.setContentType("json");
			response.getWriter().write(form);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showEmployeeFormSelectJson(HttpServletRequest request, HttpServletResponse response) {
		String employee_id = request.getParameter("employee_id");
		try {
			response.getWriter().write(FormGenerator.getModule(employee_id));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
