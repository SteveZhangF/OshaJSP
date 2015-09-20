<%@page import="bean.dao.BaseDao"%>
<%@page import="bean.form.record.component.FormRecordComponent"%>
<%@page import="bean.form.record.EmployeeRecord"%>
<%@page import="bean.form.record.FormRecord"%>
<%@page import="bean.user.data.Employee"%>
<%@page import="database.dao.factory.DAOFactoryImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bean.form.Form"%>
<jsp:useBean id="user" scope="session" type="bean.user.User" />
<jsp:useBean id="employeeForm" scope="request" type="java.util.ArrayList<Form>"/>
<ul class="list-group">
	<%for(Form form:employeeForm){
	
	
		Employee employee=  DAOFactoryImpl.getEmployeeDAO().getEmployeebyID("402880914fe96e2f014fe96fb4190002");
		EmployeeRecord fr = new EmployeeRecord();
		fr.setEmployee(employee);
		
		FormRecordComponent frc = new FormRecordComponent();
		frc.setfComponent(form.getChildren().get(0));
		frc.setValue("asd");
		fr.add(frc);
		
		BaseDao bd = new BaseDao(){};
		bd.saveObject(fr);
		
	
	%>
		<li class="list-group-item"><%=form.getName() %></li>
	<%
	out.println(form.toHtml());
	} %>
	
</ul>
