package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.form.Form;
import bean.form.module.Module;
import database.dao.factory.DAOFactoryImpl;
import form.parser.FormInputHelper;
import form.parser.FormOutputHelper;
import global.UUIDGenerator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/form_operation")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormServlet() {
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
		System.out.println(action);
		switch (action.trim()) {
		case "getUUID":
			getUUID(request, response);
			break;
		case "viewform":
			viewForm(request, response);
			break;
		case "submitform":
			submitForm(request, response);
			break;
		case "list":
			list(request, response);
			break;
		case "listmodule":
			listModule(request, response);
			break;
		case "tablemodule":
			tableModule(request, response);
			break;
		case "moduleJSON":
			moduleJSON(request, response);
			break;
		case "editModule":
			editModule(request, response);
			break;
		case "formJSON":
			formJSON(request, response);
			break;
		case "tableForm":
			tableForm(request, response);
			break;
		case "editForm":
			editForm(request, response);
			break;
		default:
			break;
		}
	}
	// <li><a role="button" href="#"
	// onclick="getForm('./department','list');"><i
	// class="icon-file-alt"></i><span class="hidden-tablet">
	// Departments</span></a></li>
	// <li><a role="button" href="#"
	// onclick="getForm('./employee','list');"><i
	// class="icon-file-alt"></i><span class="hidden-tablet">
	// Employee</span></a></li>
	
	
	private void editForm(HttpServletRequest request, HttpServletResponse response){
		String oper = request.getParameter("oper");
		switch (oper) {
		case "create":
			try {
				request.getRequestDispatcher("Formbuild/formbuilders.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "add":
			saveForm(request,response);
			break;
		case "edit":
			String id = request.getParameter("id");
			String newname = request.getParameter("name");
			Module module2 = DAOFactoryImpl.getModuleDAO().getModuleById(id);
			module2.setName(newname);
			DAOFactoryImpl.getModuleDAO().save(module2);
			break;
		case "del":
			String d_id = request.getParameter("id");
			DAOFactoryImpl.getModuleDAO().delete(d_id);
			break;
		default:
			break;
		}
	}
	
	
	private void tableForm(HttpServletRequest request, HttpServletResponse response){
		try {
			request.getRequestDispatcher("dashboardlayout/formtable.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void formJSON(HttpServletRequest request, HttpServletResponse response) {
		String moduleID = request.getParameter("module_id");
		Module module = DAOFactoryImpl.getModuleDAO().getModuleById(moduleID);
		List<Form> forms = module.getForms();
		JSONArray jsonArray = new JSONArray();
		
		for(Form form:forms){
			JSONObject jso = new JSONObject();
			jso.put("id", form.getUuid());
			jso.put("name", form.getName());
			jso.put("form_type", form.getForm_type());
			jsonArray.add(jso);
		}
		
		
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void editModule(HttpServletRequest request, HttpServletResponse response) {
		String oper = request.getParameter("oper");
		switch (oper) {
		case "add":
			String name = request.getParameter("name");
			Module module = new Module();
			module.setName(name);
			DAOFactoryImpl.getModuleDAO().save(module);
			break;
		case "edit":
			String id = request.getParameter("id");
			String newname = request.getParameter("name");
			Module module2 = DAOFactoryImpl.getModuleDAO().getModuleById(id);
			module2.setName(newname);
			DAOFactoryImpl.getModuleDAO().save(module2);
			break;
		case "del":
			String d_id = request.getParameter("id");
			DAOFactoryImpl.getModuleDAO().delete(d_id);
			break;
		default:
			break;
		}
	}

	private void moduleJSON(HttpServletRequest request, HttpServletResponse response) {
		List<Module> moduleAll = DAOFactoryImpl.getModuleDAO().list();
		
		JSONArray ja = new JSONArray();
		for(Module module:moduleAll){
			JSONObject jso = new JSONObject();
			jso.put("id", module.getId());
			jso.put("name", module.getName());
			ja.add(jso);
		}
		System.out.println(ja.toString());
		try {
			response.getWriter().write(ja.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void tableModule(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("dashboardlayout/moduletable.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listModule(HttpServletRequest request, HttpServletResponse response) {
		List<Module> moduleAll = DAOFactoryImpl.getModuleDAO().list();

		request.setAttribute("module_all", moduleAll);
		try {
			request.getRequestDispatcher("dashboardlayout/module_menu.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		List<Form> formAll = DAOFactoryImpl.getFormDAO().findAll();
		try {
			PrintWriter out = response.getWriter();
			// <li><a role="button" href="#"
			// onclick="getForm('./department','list');"><i
			// class="icon-file-alt"></i><span
			// class="hidden-tablet">Departments</span></a></li>
			//
			for (Form form : formAll) {
				out.write("<li><a role=\"button\" href=\"#\" onclick=\"viewForm('" + form.getUuid() + "');\">");
				out.write("<i class=\"icon-file-alt\"></i><span class=\"hidden-tablet\">" + form.getName()
						+ "</span></a></li>");
			}
			out.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void submitForm(HttpServletRequest request, HttpServletResponse response) {
		String formid = request.getParameter("form_id");
		Map<String, String[]> paraMap = request.getParameterMap();
		for (String key : paraMap.keySet()) {
			System.out.println(key);
			System.out.println(request.getParameter(key));
		}
	}

	private void viewForm(HttpServletRequest request, HttpServletResponse response) {
		String form_id = request.getParameter("form_id");
		FormOutputHelper foh = new FormOutputHelper();
		String form = foh.getFormHtml(form_id);
		try {
			response.getWriter().write(form);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void saveForm(HttpServletRequest request, HttpServletResponse response) {
		String formDATA = request.getParameter("formDATA");// 传输进来的form data
															// （XML）
		String formType = request.getParameter("form_type");
		FormInputHelper fih = new FormInputHelper();
		Form form = fih.createForm(formDATA,formType);
		
		String moduleID = request.getParameter("module_id");
		Module module = DAOFactoryImpl.getModuleDAO().getModuleById(moduleID);
		module.addForm(form);
		
		DAOFactoryImpl.getModuleDAO().save(module);
		
	}

	private void getUUID(HttpServletRequest request, HttpServletResponse response) {
		String uuid = UUIDGenerator.generateUUID();
		try {
			response.getWriter().write(uuid);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
