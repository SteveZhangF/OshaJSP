package engine.htmlengine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TemplatePool {
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
			File file = new File("");
			FileReader fr;
			try {
				fr = new FileReader(file);
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
