
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="bean.form.module.Module"%>

<%
	List<Module> modlueAll = (List<Module>) request.getAttribute("module_all");
	for (Module module : modlueAll) {
%>

	<li><a role="button" href="#"
	onclick="showModule('<%=module.getId()%>');"><i class="icon-file-alt"></i><span
		class="hidden-tablet"> <%= module.getName() %></span></a></li>
<%
	}
%>
