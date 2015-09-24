<%@page import="bean.form.module.Module"%>
<%@page import="bean.user.data.OrganizationElement"%>
<%@page import="bean.user.data.ShowEmployee"%>
<%@page import="bean.user.data.Employee"%>
<%@page import="bean.user.data.ShowDepartment"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="bean.user.data.Department"%>
<%@page import="bean.user.data.Company"%>

<%List<Module> modules =(List) request.getAttribute("modules");
%>

<div class="tree">
	<%for(Module module: modules){
		out.println(module.show());
	} %>
</div>

