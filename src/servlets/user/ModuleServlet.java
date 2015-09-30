package servlets.user;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.form.Form;
import bean.form.module.Module;
import bean.user.User;
import bean.user.data.Company;
import bean.user.data.OrganizationElement;
import database.dao.factory.DAOFactoryImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ModuleServlet
 */
@WebServlet("/module")
public class ModuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuleServlet() {
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
		case "showMain":
			showMain(request, response);
			break;
		case "showTreeMenuModule":
			showTreeMenuModule(request, response);
			break;
		case "getPercentInMenu":
			getPercentInMenu(request, response);
			break;
		default:
			break;
		}
	}
	
	private void showMain(HttpServletRequest request, HttpServletResponse response){
		try {
			response.getWriter().write("Main");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void showTreeMenuModule(HttpServletRequest request, HttpServletResponse response){
		User user = (User)request.getSession().getAttribute("user");
		user = DAOFactoryImpl.getUserDAO().getUserbyID(user.getUuid());
		Writer out = null;
		try {
			out = response.getWriter();
			Company company = user.getCompany();
			if(company ==null){
				out.write("no company");
			}else {
				List<Module> modules = company.getModules();
				request.setAttribute("modules", modules);
				request.getRequestDispatcher("/customer/layout/_left_menu_module_menu.jsp").forward(request, response);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// need to be improved
	private void getPercentInMenu(HttpServletRequest request, HttpServletResponse response){
		User user = (User)request.getSession().getAttribute("user");
		user = DAOFactoryImpl.getUserDAO().getUserbyID(user.getUuid());
		Writer out = null;
		try {
			out = response.getWriter();
			Company company = user.getCompany();
			if(company ==null){
				out.write("no company");
			}else {
				List<Module> modules = company.getModules();
				System.out.println(modules.size());
				JSONArray jsoAllA = new JSONArray();
				for(Module module:modules){
					double all = 0;
					double filled=0;
					JSONArray jsoAll = new JSONArray();
					for(Form form : module.getForms()){
						switch (form.getForm_type()) {
						case CompanyForm:
							double this_formFilled = form.fillPercent(company.getUuid());
							all=all+100;
							JSONObject jsoCOmpany = new JSONObject();
							jsoCOmpany.put("form_id", form.getUuid());
							jsoCOmpany.put("percent", this_formFilled);
							filled = filled + this_formFilled;
							jsoAll.add(jsoCOmpany);
							break;
						case DepartmentForm:
							double departmentFormFilled = 0;
							double dform_all = 0;
							for(OrganizationElement d:company.getDepartments()){
								double d_filled = form.fillPercent(d.getUuid());
								System.out.println(d_filled);
								departmentFormFilled=departmentFormFilled+d_filled;
								dform_all+=100;
							}
							double res = departmentFormFilled/dform_all*100;
							System.err.println(res);
							filled = filled + res;
							all+=100;
							JSONObject jsod = new JSONObject();
							jsod.put("form_id", form.getUuid());
							jsod.put("percent", res);
							jsoAll.add(jsod);
							break;
						case EmployeeForm:
							double eFormFilled = 0;
							double eform_all = 0;
							for(OrganizationElement e:company.getEmployees()){
								double e_filled = form.fillPercent(e.getUuid());
								eFormFilled=eFormFilled+e_filled;
								eform_all+=100;
							}
							double resE = 0;
							if(eform_all!=0){
								resE = eFormFilled/eform_all*100;
							}else {
								resE =100;
							}
							filled = filled + resE;
							all+=100;
							JSONObject jsoe = new JSONObject();
							jsoe.put("form_id", form.getUuid());
							jsoe.put("percent", resE);
							jsoAll.add(jsoe);
							break;
						}
					}
					JSONObject jsoModule = new JSONObject();
					jsoModule.put("module_id", module.getId());
					if(all==0){
						jsoModule.put("percent", 0);
					}else{
						jsoModule.put("percent", filled/all*100);
					}
					jsoModule.put("form", jsoAll);
					jsoAllA.add(jsoModule);
				}
				response.setContentType("json");
				out.write(jsoAllA.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		
}
