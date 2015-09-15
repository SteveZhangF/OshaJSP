package servlets.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.user.User;
import bean.user.data.Company;
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
		doGet(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response){
		User user = (User) request.getSession().getAttribute("user");
		String company_id = user.getCompany_id();
		//if the user didn't create the company information
		if(company_id== null || company_id.trim().equals("")){
			try {
				request.getRequestDispatcher("/company_edit.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void save(HttpServletRequest request, HttpServletResponse response){}
	
	private void update(HttpServletRequest request, HttpServletResponse response){}

}
