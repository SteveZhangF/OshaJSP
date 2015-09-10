package servlets;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import servlets.modelcontroller.TopicViewController;

/**
 * Servlet implementation class TopicViwServlet
 */
@WebServlet("/topicview_servlet.do")
public class TopicViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("page_id");
		String data = TopicViewController.findPage(id);
		HashMap<String, Object> dic = new HashMap<String, Object>();  
		dic.put("Data", data); 
		response.getWriter().print(dic);
		response.getWriter().flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("page_id");
		String data = TopicViewController.findPage(id+"11");
		
		
		HashMap<String, Object> dic = new HashMap<String, Object>();  
		dic.put("page_id", id);// 
		dic.put("Data", data); 
		
		JSONObject jsoresult = new JSONObject();
		jsoresult.put("page_id", id);
		jsoresult.put("Data",data);
		
		response.setContentType("application/x-json");
		
		response.getWriter().print(jsoresult.toString());
		response.getWriter().flush();
	}
	
	
	private void submitForm(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	private void viewForm(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("page_id");
		String data = TopicViewController.findPage(id);
		
		JSONObject jsoresult = new JSONObject();
		jsoresult.put("page_id", id);
		jsoresult.put("Data",data);
		jsoresult.put("next_page", "#nextpageid");
		response.setContentType("application/x-json");
		
		try {
			response.getWriter().print(jsoresult.toString());
			response.getWriter().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
