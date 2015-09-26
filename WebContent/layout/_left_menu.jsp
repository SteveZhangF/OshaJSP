<%@page import="bean.user.data.ShowEmployee"%>
<%@page import="bean.user.data.Employee"%>
<%@page import="bean.user.data.ShowDepartment"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="bean.user.data.Department"%>
<%@page import="bean.user.data.Company"%>
<jsp:useBean id="user" scope="session" class="bean.user.User" />
<link href="<%=application.getContextPath()%>/custom/css/menu_tree.css"
	rel="stylesheet">

<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/custom/js/bootstrap-contextmenu.js"></script>
<div class="sidebar ">
</div>

