<%@page import="model.TopicElement"%>
<%@page import="java.util.List"%>
<%@page import="database.dao.factory.DAOFactoryImpl"%>
<script src="./custom/js/movetable.js" type="text/javascript"></script>
<script src="./custom/js/updatedata.js" type="text/javascript"></script>
<div class="row-fluid sortable">
	<div class="box span12">
		<div class="box-header" data-original-title>

			<h2>
				<i class="halflings-icon white setting"></i><span class="break"></span>Topics
			</h2>
			<div class="box-icon">
				<a href="#" class="btn-setting"><i
					class="halflings-icon white wrench"></i></a> <a href="#"
					class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
				<a href="#" class="btn-close"><i
					class="halflings-icon white remove"></i></a>
			</div>

		</div>

		<!--/span-->
		<div class="box-content">

			<table
				class="table table-striped table-bordered bootstrap-datatable datatable">
				<thead>
					<tr>
						<th>Topic Name</th>
						<th>Description</th>
						<th>Sequence Code</th>
						<th>Type</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<TopicElement> list = DAOFactoryImpl.getTopicElementDAO().findAll();
						for (TopicElement te : list) {
					%>
					<tr>
						<td hidden="true" id="id"><%=te.getId() %></td>
					
						<td><%
								out.print(te.getName());
							%></td>
						<td class="center"><%
								out.print(te.getDescription());
							%></td>
						<td class="center" id="sequence_code"><%
								out.print(te.getSequenceCode());
							%></td>
						<td class="center"><%
								out.print(te.getClass().getSimpleName());
							%></td>
						<td class="center"><a class="btn btn-success" href="#"> <i
								class="halflings-icon white zoom-in"></i>
						</a> <a class="btn btn-info"
							href="topic_edit.jsp?topic_id=<%=te.getId()%>"> <i
								class="halflings-icon white edit"></i>
						</a> <a class="btn btn-danger" href="#"> <i
								class="halflings-icon white trash"></i>
						</a>
						
						<a class="btn btn-danger" href ="javascript:void(0)"onClick="moveUp('../TopicElementServlet',this)" > <i
								class="halflings-icon arrow-up"></i>
						</a>
						<a class="btn btn-danger" href ="javascript:void(0)"onClick="moveDown('../TopicElementServlet',this)"> <i
								class=" halflings-icon arrow-down"></i>
						</a>
						
						
						</td>
						
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>

	</div>
</div>
<div class="modal hide fade" id="myModal">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
	</div>
	<div class="modal-body"></div>
	<div class="modal-footer">
		<a href="#" class="btn" data-dismiss="modal">Close</a> <a href="#"
			class="btn btn-primary">Save changes</a>
	</div>
</div>
