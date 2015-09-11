<%@page import="model.OptionElement"%>
<%@page import="model.TopicElement"%>
<%@page import="java.util.List"%>
<%@page import="database.dao.factory.DAOFactoryImpl"%>
<script
	src="<%=application.getContextPath()%>/janux/custom/js/movetable.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/janux/custom/js/updatedata.js"
	type="text/javascript"></script>
<div class="box-content">
	<table
		class="table table-striped table-bordered bootstrap-datatable datatable ">
		<thead>
			<tr>
				<th>ID</th>
				<th>Option Name</th>
				<th>Description</th>
				<th>Sequence Code</th>
				<th>Option Type</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<OptionElement> list = (List<OptionElement>) request.getAttribute("list");
				for (OptionElement te : list) {
			%>
			<tr>
				<td id="id"><%=te.getId()%></td>
				<td>
					<%
						out.print(te.getName());
					%>
				</td>
				<td class="center">
					<%
						out.print(te.getDescription());
					%>
				</td>
				<td class="center" id="sequence_code">
					<%
						out.print(te.getSequenceCode());
					%>
				</td>
				<td class="center" ><%=te.getClass().getSimpleName() %></td>
				
				<td class="center"><a class="btn btn-success" href="#"> <i
						class="halflings-icon white zoom-in"></i>
				</a> <a class="btn btn-info"
					onclick="showModal('modaledit','<%=application.getContextPath()%>/OptionElementServlet','edit',<%=te.getId()%>)"
					href="javascript:void(0)"> <i
						class="halflings-icon white edit"></i>
				</a> <a class="btn btn-danger" href="#"> <i
						class="halflings-icon white trash"></i>
				</a> <a class="btn btn-danger" href="javascript:void(0)"
					onClick="moveUp('<%=application.getContextPath()%>/OptionElementServlet',this)">
						<i class="halflings-icon arrow-up"></i>
				</a> <a class="btn btn-danger" href="javascript:void(0)"
					onClick="moveDown('<%=application.getContextPath()%>/OptionElementServlet,this)">
						<i class=" halflings-icon arrow-down"></i>
				</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>