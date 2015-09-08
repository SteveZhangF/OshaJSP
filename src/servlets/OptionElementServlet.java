package servlets;

import java.io.IOException;
import java.security.cert.PKIXRevocationChecker.Option;
import java.sql.SQLException;
import java.util.List;

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
		String action = request.getParameter("action");
		if (action == null) {
			list(request, response);
		} else if (action.equals("edit")) {
			edit(request, response);
		} else if (action.equals("list")) {
			list(request, response);
		} else if (action.equals("delete")) {
			delete(request, response);
		} else if (action.equals("update")) {
			update(request, response);
		} else if (action.equals("create")) {
			create(request, response);
		} else if (action.equals("save")) {
			save(request, response);
		}
	}

	private void create(HttpServletRequest request, HttpServletResponse response) {
		String parent_id = request.getParameter("option_parent_id");
		request.setAttribute("option_parent_id", parent_id);
		try {
			List<OptionElement> list = DAOFactoryImpl.getOptionElementDAO().findbyParentID(parent_id);

			int lastCode = 0;
			if (list.size() != 0)
				lastCode = Integer.valueOf(list.get(list.size() - 1).getSequenceCode());
			request.setAttribute("sequence_code", lastCode + 1);
			request.getRequestDispatcher("/janux/option_edit.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("option_id");
		try {
			OptionElement te = DAOFactoryImpl.getOptionElementDAO().findById(id);
			request.setAttribute("option_element", te);
			request.getRequestDispatcher("/janux/option_edit.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String option_id = request.getParameter("option_id");
		System.err.println("optionid=" + option_id);
		try {
			DAOFactoryImpl.getOptionElementDAO().delete(option_id.trim());
			list(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("option_name");
		String desc = request.getParameter("option_desc");
		String type = request.getParameter("option_type");
		System.out.println("saveing");
		System.out.println(request.getParameterNames());
		OptionElement te;
		try {
			te = new OptionElement();
			te.setType(type);
			te.setParentID(request.getParameter("option_parent_id"));
			te.setId(request.getParameter("option_id"));
			te.setDescription(desc);
			te.setName(name);
			te.setSequenceCode(request.getParameter("option_sequence_code"));
			DAOFactoryImpl.getOptionElementDAO().add(te);
			list(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("option_name");
		String desc = request.getParameter("option_desc");
		String type = request.getParameter("option_type");
		OptionElement te;
		try {
			te = new OptionElement();
			te.setType(type);
			te.setParentID(request.getParameter("option_parent_id"));
			te.setId(request.getParameter("option_id"));
			te.setDescription(desc);
			te.setName(name);
			te.setSequenceCode(request.getParameter("option_sequence_code"));
			DAOFactoryImpl.getOptionElementDAO().update(te);
			list(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 */
	public void list(HttpServletRequest request, HttpServletResponse response) {

		List<OptionElement> list;
		String parent_id = request.getParameter("option_parent_id");
		try {
			list = DAOFactoryImpl.getOptionElementDAO().findbyParentID(parent_id);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/janux/option_view_all.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
