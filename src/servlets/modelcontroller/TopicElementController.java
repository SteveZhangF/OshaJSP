package servlets.modelcontroller;

import java.sql.SQLException;
import java.util.Map;

import database.dao.factory.DAOFactoryImpl;
import model.TopicElement;

public class TopicElementController {
	public boolean update(Map<String, String[]> map) {
		String name = map.get("topic_name")[0];
		String desc = map.get("topic_desc")[0];
		String type = map.get("topic_type")[0];
		TopicElement te;
		try {
			te = (TopicElement) Class.forName(type).newInstance();
			te.setParentID(map.get("topic_parent_id")[0]);
			te.setId(map.get("topic_id")[0]);
			te.setDescription(desc);
			te.setName(name);
			te.setSequenceCode(map.get("topic_sequence_code")[0]);
			DAOFactoryImpl.getTopicElementDAO().update(te);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
}
