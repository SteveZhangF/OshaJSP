package engine.htmlengine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import database.dao.factory.DAOFactoryImpl;
import model.TopicElement;

public class TemplatePool {

	public static void main(String[] args) {
		List<TopicElement> list;

		try {
			list = DAOFactoryImpl.getTopicElementDAO().findAll();
			for (TopicElement te : list) {
				System.out.println(te.toHtml());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private HashMap<String, String> templatePool = new HashMap<String, String>();

	private static class TemplatePoolFactory {
		private static TemplatePool instance = new TemplatePool();
	}

	public static TemplatePool getInstance() {
		return TemplatePoolFactory.instance;
	}

	public String getHtmlTemplate(String key) {
		String temp = null;
		String result = templatePool.get(key);
		if (result == null) {
			result = "";
			String path = "/../../resource/template/" + key.split(":")[0] + "/" + key.split(":")[1] + ".html";
			InputStream is = TemplatePool.class.getResourceAsStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			try {
				while ((temp = br.readLine()) != null) {
					result += temp;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			templatePool.put(key, result);
		}
		return result;
	}
}
