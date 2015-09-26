<%@page import="database.dao.factory.DAOFactoryImpl"%>
<%@page import="bean.form.module.Module"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<Module> modulesAll = DAOFactoryImpl.getModuleDAO().list(); for(Module module: modulesAll){
	out.println(module.show());
}%>
</body>
</html>