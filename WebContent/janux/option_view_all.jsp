<%@page import="model.TopicElement"%>
<%@page import="java.util.List"%>
<%@page import="database.dao.factory.DAOFactoryImpl"%><div class="box-content">
	<table
		class="table table-striped table-bordered bootstrap-datatable datatable">
		<thead>
			<tr>
				<th>Option Name</th>
				<th>Description</th>
				<th>Sequence Code</th>
				<th>Default Value</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<% List<TopicElement> list = DAOFactoryImpl.getTopicElementDAO().findAll(); 
									for(TopicElement te : list) { %>
			<tr>
				<td>
					<%out.println(te.getName());%>
				</td>
				<td class="center">
					<% out.println(te.getDescription()) ;%>
				</td>
				<td class="center">
					<%out.println(te.getSequenceCode()) ;%>
				</td>
				<td class="center">
					<%out.println(te.getParentID()) ;%>
				</td>
				<td class="center"><a class="btn btn-success" href="#"> <i
						class="halflings-icon white zoom-in"></i>
				</a> <a class="btn btn-info" href="#"> <i
						class="halflings-icon white edit"></i>
				</a> <a class="btn btn-danger" href="#"> <i
						class="halflings-icon white trash"></i>
				</a></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</div>