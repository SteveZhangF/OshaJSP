package servlets.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import bean.dao.BaseDao;
import bean.form.Form;
import bean.form.module.Module;
import bean.form.record.EmployeeRecord;
import bean.form.record.FormRecord;
import bean.form.record.component.FormRecordComponent;
import bean.user.User;
import bean.user.data.Employee;
import database.dao.factory.DAOFactoryImpl;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch (action) {
		case "showEmployeeForm":
			showEmployeeForm(request, response);
			break;
		default:
			break;
		}
	}
	
	
	private void showEmployeeForm(HttpServletRequest request, HttpServletResponse response){
		User user = (User) request.getSession().getAttribute("user");
		List<Form> forms = new ArrayList<>();
		for(Module module:user.getCompany().getModules()){
			for(Form f: module.getForms()){
				if(f.getForm_type()!=null && f.getForm_type().equalsIgnoreCase("Employee Form")){
					forms.add(f);
				}
			}
		}
		
		request.setAttribute("employeeForm", forms);
		try {
			request.getRequestDispatcher("employee_forms.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
