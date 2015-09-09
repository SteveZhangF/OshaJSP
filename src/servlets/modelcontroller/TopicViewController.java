package servlets.modelcontroller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

import database.dao.factory.DAOFactoryImpl;
import model.OptionElement;
import model.TopicElement;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TopicViewController {
	public static String find(String id) {
		try {
			TopicElement te = DAOFactoryImpl.getTopicElementDAO().findById(id);
			List<OptionElement> children = DAOFactoryImpl.getOptionElementDAO().findbyParentID(id);
			for (OptionElement oe : children) {
				te.addChild(oe);
			}
			return te==null?"":te.toHtml();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String findPage(String pageid){
		
		try {
			JSONArray jsa = new JSONArray();
			List<TopicElement> page = DAOFactoryImpl.getTopicElementDAO().findbyParentID(pageid);
			for(TopicElement te:page){
				List<OptionElement> children = DAOFactoryImpl.getOptionElementDAO().findbyParentID(te.getId());
				for (OptionElement oe : children) {
					te.addChild(oe);
				}
				JSONObject jso = new JSONObject();
				jso.accumulate("topic_id", te.getId());
				jso.accumulate("topic_value", te.toHtml());
				jsa.add(jso);
			}
			return jsa.toString();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}