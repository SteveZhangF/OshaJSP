package atest;


import bean.user.data.Employee;
import database.dao.factory.DAOFactoryImpl;

public class Test {

	@org.junit.Test
	public void test(){
		Employee e = new Employee();
		
		System.out.println(e.getRecords().size());
	}
	
}
