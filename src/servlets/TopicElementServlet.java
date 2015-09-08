package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import database.dao.factory.DAOFactoryImpl;
import model.TopicElement;
import model.topic.RadioTopicElement;
import servlets.modelcontroller.TopicElementController;

/**
 * Servlet implementation class TopicElementServlet
 */
@WebServlet("/TopicElementServlet")
public class TopicElementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopicElementServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		String parent_id = request.getParameter("topic_parent_id");
		request.setAttribute("topic_parent_id", parent_id);
		try {
			List<TopicElement> list = DAOFactoryImpl.getTopicElementDAO().findbyParentID(parent_id);

			int lastCode = 0;
			if (list.size() != 0)
				lastCode = Integer.valueOf(list.get(list.size() - 1).getSequenceCode());
			request.setAttribute("sequence_code", lastCode + 1);
			request.getRequestDispatcher("/janux/topic_edit.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("topic_id");
		try {
			TopicElement te = DAOFactoryImpl.getTopicElementDAO().findById(id);
			request.setAttribute("topic_element", te);
			request.getRequestDispatcher("/janux/topic_edit.jsp").forward(request, response);
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
		String topic_id =  request.getParameter("topic_id");
		System.err.println("topicid="+topic_id);
		try {
			DAOFactoryImpl.getTopicElementDAO().delete(topic_id.trim());
			list(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("topic_name");
		String desc = request.getParameter("topic_desc");
		String type = request.getParameter("topic_type");
		TopicElement te;
		try {
			te = new TopicElement();
			te.setType(type);
			te.setParentID(request.getParameter("topic_parent_id"));
			te.setId(request.getParameter("topic_id"));
			te.setDescription(desc);
			te.setName(name);
			te.setSequenceCode(request.getParameter("topic_sequence_code"));
			DAOFactoryImpl.getTopicElementDAO().add(te);
			list(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("topic_name");
		String desc = request.getParameter("topic_desc");
		String type = request.getParameter("topic_type");
		TopicElement te;
		try {
			te = new TopicElement();
			te.setType(type);
			te.setParentID(request.getParameter("topic_parent_id"));
			te.setId(request.getParameter("topic_id"));
			te.setDescription(desc);
			te.setName(name);
			te.setSequenceCode(request.getParameter("topic_sequence_code"));
			DAOFactoryImpl.getTopicElementDAO().update(te);
			list(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 */
	public void list(HttpServletRequest request, HttpServletResponse response) {

		List<TopicElement> list;
		String parent_id = request.getParameter("topic_parent_id");
		try {
			list = DAOFactoryImpl.getTopicElementDAO().findbyParentID(parent_id);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/janux/topic_view_all.jsp").forward(request, response);
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
