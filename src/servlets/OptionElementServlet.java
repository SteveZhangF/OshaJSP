package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.dao.factory.DAOFactoryImpl;
import model.OptionElement;
import model.option.RadioOptionElement;

/**
 * Servlet implementation class OptionElementServlet
 */
@WebServlet("/OptionElementServlet")
public class OptionElementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptionElementServlet() {
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
		String name = request.getParameter("option_name");
		String desc = request.getParameter("option_desc");
		String type = request.getParameter("option_type");
		OptionElement te = null;
		try {
			te = new OptionElement();
			te.setType(type);
			te.setParentID(request.getParameter("option_parent_id"));
			te.setId(request.getParameter("option_id"));
			te.setDescription(desc);
			te.setName(name);
			te.setSequenceCode(request.getParameter("option_sequence_code"));
			DAOFactoryImpl.getOptionElementDAO().update(te);
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
