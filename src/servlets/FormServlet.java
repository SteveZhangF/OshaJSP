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

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bean.form.Form;
import bean.form.module.Module;
import database.dao.factory.DAOFactoryImpl;
import form.parser.FormInputHelper;
import form.parser.FormOutputHelper;
import global.UUIDGenerator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import servlets.form.helpers.recordgenerator.RecordGenerator;

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
		case "changeParentID":
			changeParentID(request, response);
			break;
		case "getUUID":
			getUUID(request, response);
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
	private void changeParentID(HttpServletRequest request, HttpServletResponse response) {
		String parentid = request.getParameter("parentid");
		String myid = request.getParameter("myid");
		String changetype = request.getParameter("changeType");
		Module parent = DAOFactoryImpl.getModuleDAO().getModuleById(parentid);
		switch (changetype) {
		case "form":
			Form form = DAOFactoryImpl.getFormDAO().findFormbyID(myid);
			
			Module old = 	form.getModule();
			if(old!=null){
				old.getForms().remove(form);
			}
			form.setModule(parent);
			DAOFactoryImpl.getFormDAO().save(form);
			break;
		case "module":
			Module module = DAOFactoryImpl.getModuleDAO().getModuleById(myid);
			Module old2 = 	module.getSuperModule();
			if(old2!=null){
				old2.getSubModules().remove(module);
			}
			module.setSuperModule(parent);
			DAOFactoryImpl.getModuleDAO().save(module);
			break;
		}
		listModule(request, response);
	}

	private void editForm(HttpServletRequest request, HttpServletResponse response) {
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
			saveForm(request, response);
			break;
		case "edit":
			break;
		case "delete":
			String d_id = request.getParameter("form_id");
			System.out.println(d_id);
			DAOFactoryImpl.getFormDAO().delete(d_id);
			listModule(request, response);
			break;
		default:
			break;
		}
	}


	private void tableForm(HttpServletRequest request, HttpServletResponse response) {
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
		for (Form form : forms) {
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
		
		
		case "save":
			Module module = new Module();
			String nameNew = request.getParameter("name");
			String parent_id=request.getParameter("parent_id");
			
			module.setName(nameNew);
			module.setSuperModule(DAOFactoryImpl.getModuleDAO().getModuleById(parent_id));
			DAOFactoryImpl.getModuleDAO().save(module);
			break;
		
		case "add":
			String parentid=request.getParameter("parent_id");
			request.setAttribute("oper", "save");
			request.setAttribute("parent_id", parentid);
			Module parentModule = DAOFactoryImpl.getModuleDAO().getModuleById(parentid);
			request.setAttribute("parent", parentModule);
			try {
				request.getRequestDispatcher("/dashboard/layout/module_edit.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "edit":
			String id = request.getParameter("module_id");
			Module module2 = DAOFactoryImpl.getModuleDAO().getModuleById(id);
			request.setAttribute("module", module2);
			request.setAttribute("oper", "update");
			try {
				request.getRequestDispatcher("/dashboard/layout/module_edit.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "update":
			String m_id = request.getParameter("module_id");
			Module m = DAOFactoryImpl.getModuleDAO().getModuleById(m_id);
			String name_update = request.getParameter("name");
			String pid_update = request.getParameter("parent_id");
			m.setName(name_update);
			m.getSuperModule().getSubModules().remove(m);
			m.setSuperModule(DAOFactoryImpl.getModuleDAO().getModuleById(pid_update));
			DAOFactoryImpl.getModuleDAO().save(m);
			break;
		case "delete":
			String d_id = request.getParameter("module_id");
			DAOFactoryImpl.getModuleDAO().delete(d_id);
			listModule(request, response);
			break;
		default:
			break;
		}
	}

	private String showModuleJSON(Module module) {
		JSONObject json = new JSONObject();
		json.put("id", module.getId());
		json.put("name", module.getName());
		JSONArray subJSONS = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		for (Module sub : module.getSubModules()) {
			subJSONS.add(JSONObject.fromObject(showModuleJSON(sub)));
		}
		json.put("submodule", subJSONS);
		JSONArray forms = new JSONArray();
		for (Form form : module.getForms()) {
			try {
				String formJSON = mapper.writeValueAsString(form);
				forms.add(JSONObject.fromObject(formJSON));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		json.put("forms", forms);
		return json.toString();
	}

	private void moduleJSON(HttpServletRequest request, HttpServletResponse response) {
		List<Module> moduleAll = DAOFactoryImpl.getModuleDAO().list();
		JSONArray ja = new JSONArray();
		for (Module module : moduleAll) {
			if (module.getSuperModule() == null)
				ja.add(JSONObject.fromObject(showModuleJSON(module)));
		}
		try {
			response.setContentType("json");
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
//		List<Module> moduleAll = DAOFactoryImpl.getModuleDAO().list();
		Module moduleAll = DAOFactoryImpl.getModuleDAO().getModuleById("0");
		request.setAttribute("modules", moduleAll);
		try {
			request.getRequestDispatcher("dashboard/layout/module_menu.jsp").forward(request, response);
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

	private void saveForm(HttpServletRequest request, HttpServletResponse response) {
		String formDATA = request.getParameter("formDATA");// 传输进来的form data
															// （XML）
		String formType = request.getParameter("form_type");
		String moduleID = request.getParameter("module_id");
		String formHtml = request.getParameter("formHtml");
		FormInputHelper fih = new FormInputHelper();

		fih.saveForm(moduleID, formType,  formHtml);

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
