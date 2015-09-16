package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import form.parser.FormInputHelper;

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

		default:
			break;
		}
	}
	
	private void viewForm(HttpServletRequest request, HttpServletResponse response){
		String form_id = request.getParameter("form_id");
		
	}
	
	private void saveForm(HttpServletRequest request, HttpServletResponse response){
		String formDATA = request.getParameter("formDATA");// 传输进来的form data （XML）
		FormInputHelper fih = new FormInputHelper();
		fih.save(formDATA);
	}

}
