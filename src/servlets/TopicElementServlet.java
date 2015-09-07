package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		TopicElementController.save(request.getParameterMap());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("topic_name");
		String desc = request.getParameter("topic_desc");
		String type = request.getParameter("topic_type");
		TopicElement te;
		try {
			te = new RadioTopicElement();
			System.out.println(te.getClass().getName());
			te = (TopicElement) Class.forName(te.getClass().getName()).newInstance();
			te.setParentID(request.getParameter("topic_parent_id"));
			te.setId(request.getParameter("topic_id"));
			te.setDescription(desc);
			te.setName(name);
			te.setSequenceCode(request.getParameter("topic_sequence_code"));
			DAOFactoryImpl.getTopicElementDAO().update(te);
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
