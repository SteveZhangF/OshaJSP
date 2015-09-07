package engine.htmlengine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import database.dao.factory.DAOFactoryImpl;
import model.TopicElement;
import model.topic.RadioTopicElement;

public class TemplatePool {
	
	public static void main(String[] args){
		List<TopicElement> list;
		
		try {
			list = DAOFactoryImpl.getTopicElementDAO().findAll();
			System.out.println(list.size());
			for (TopicElement te : list) {
				System.out.println(te.toHtml());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private HashMap<String, String> templatePool = new HashMap<String,String>();
	
	private static class TemplatePoolFactory{
		private static TemplatePool instance = new TemplatePool();
	}
	
	public static TemplatePool getInstance(){
		return TemplatePoolFactory.instance;
	}
	
	
	public String getHtmlTemplate(String key){
		String temp = null;
		String result = templatePool.get(key);
		if(result == null){
			result = "";
			URL uri = Thread.currentThread().getContextClassLoader().getResource("");
//			System.err.println(uri.getPath());
			
			File file2 = new File(uri.getPath()).getParentFile().getParentFile();
			file2 = new File(file2.getAbsolutePath()+"/resource/template/topic/"+key+".html");
			FileReader fr;
			try {
				fr = new FileReader(file2);
				BufferedReader br = new BufferedReader(fr);
				while((temp = br.readLine())!=null){
					result+=temp;
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