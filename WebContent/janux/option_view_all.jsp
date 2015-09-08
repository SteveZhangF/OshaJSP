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
				<th>Default Value</th>
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
				<td class="center">
					<%
						out.print(te.getParentID());
					%>
				</td>
				<td class="center"><a class="btn btn-success" href="#"> <i
						class="halflings-icon white zoom-in"></i>
				</a> <a class="btn btn-info"
					href="option_edit.jsp?option_id=<%=te.getId()%>"> <i
						class="halflings-icon white edit"></i>
				</a> <a class="btn btn-danger" href="#"> <i
						class="halflings-icon white trash"></i>
				</a> <a class="btn btn-danger" href="javascript:void(0)"
					onClick="moveUp('../OptionElementServlet',this)"> <i
						class="halflings-icon arrow-up"></i>
				</a> <a class="btn btn-danger" href="javascript:void(0)"
					onClick="moveDown('../OptionElementServlet,this)"> <i
						class=" halflings-icon arrow-down"></i>
				</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</div>