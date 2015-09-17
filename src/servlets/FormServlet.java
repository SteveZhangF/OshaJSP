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

import database.dao.factory.DAOFactoryImpl;
import form.bean.Form;
import form.parser.FormInputHelper;
import form.parser.FormOutputHelper;
import global.UUIDGenerator;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		switch (action.trim()) {
		case "save":
			saveForm(request, response);
			break;
		case "getUUID":
			getUUID(request, response);
			break;
		case "viewform":
			viewForm(request,response);
			break;
		case "submitform":
			submitForm(request, response);
			break;
		case "list":
			list(request, response);
			break;
		default:
			break;
		}
	}
	
	
	private void list(HttpServletRequest request,HttpServletResponse response){
		List<Form> formAll = DAOFactoryImpl.getFormDAO().findAll();
		try {
			PrintWriter out = response.getWriter();
//			<li><a role="button" href="#" onclick="getForm('./department','list');"><i class="icon-file-alt"></i><span class="hidden-tablet">Departments</span></a></li>
//			
			for(Form form:formAll){
				out.write("<li><a role=\"button\" href=\"#\" onclick=\"viewForm('"+form.getUuid()+"');\">");
				out.write("<i class=\"icon-file-alt\"></i><span class=\"hidden-tablet\">"+form.getName()+"</span></a></li>");
			}
			out.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void submitForm(HttpServletRequest request,HttpServletResponse response){
		String formid = request.getParameter("form_id");
		Map<String,String[]> paraMap = request.getParameterMap();
		for(String key:paraMap.keySet()){
			System.out.println(key);
			System.out.println(request.getParameter(key));
		}
	}
	
	private void viewForm(HttpServletRequest request, HttpServletResponse response){
		String form_id = request.getParameter("form_id");
		FormOutputHelper foh = new FormOutputHelper();
		String form=foh.getFormHtml(form_id);
		try {
			response.getWriter().write(form);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void saveForm(HttpServletRequest request, HttpServletResponse response){
		String formDATA = request.getParameter("formDATA");// 传输进来的form data （XML）
		FormInputHelper fih = new FormInputHelper();
		fih.save(formDATA);
	}
	
	private void getUUID(HttpServletRequest request, HttpServletResponse response){
		String uuid = UUIDGenerator.generateUUID();
		try {
			response.getWriter().write(uuid);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
