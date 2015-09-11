<%@page import="model.TopicElement"%>
<%@page import="java.util.List"%>
<%@page import="database.dao.factory.DAOFactoryImpl"%>
<script
	src="<%=application.getContextPath()%>/janux/custom/js/movetable.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/janux/custom/js/updatedata.js"
	type="text/javascript"></script>
<!-- start: Header -->
<jsp:include page="/janux/layout/_header.jsp" />
<!-- end: Header -->
<!-- start: Content -->
<div id="content" class="span10">
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="index.html">Home</a> <i
			class="icon-angle-right"></i></li>
		<li><a href="#">Tables</a></li>
	</ul>

	<%
		String parent_id = request.getParameter("topic_parent_id");
	%>
	<div class="row-fluid sortable">
		<div class="box span12">
			<div class="box-header" data-original-title>

				<h2>
					<i class="halflings-icon white setting"></i><span class="break"></span>Topics
				</h2>
				<div class="box-icon">
					<a
						href="<%=application.getContextPath()%>/TopicElementServlet?action=create&topic_parent_id=<%=parent_id %>"
						class="btn-setting"><i class=" halflings-icon pencil"></i></a> <a
						href="#" class="btn-minimize"><i
						class="halflings-icon white chevron-up"></i></a> <a href="#"
						class="btn-close"><i class="halflings-icon white remove"></i></a>
				</div>
			</div>

			<!--/span-->
			<div class="box-content">
				<table class="table table-striped table-bordered bootstrap-datatable datatable">
					<thead>
						<tr><th>ID</th>
							<th>Topic Name</th>
							<th>Description</th>
							<th>Sequence Code</th>
							<th>Type</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<TopicElement> list = (List<TopicElement>) request.getAttribute("list");
							for (TopicElement te : list) {
						%>
						<tr>
							<td  id="id"><%=te.getId()%></td>

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
									out.print(te.getType());
								%>
							</td>
							<td class="center"><a class="btn btn-success" href="#">
									<i class="halflings-icon white zoom-in"></i>
							</a> <a class="btn btn-info"
								href="<%=application.getContextPath()%>/TopicElementServlet?action=edit&topic_id=<%=te.getId()%>">
									<i class="halflings-icon white edit"></i>
							</a> <a class="btn btn-danger"
								href="<%=application.getContextPath()%>/TopicElementServlet?action=delete&topic_id=<%=te.getId()%>&topic_parent_id=<%=parent_id%>">
									<i class="halflings-icon white trash"></i>
							</a> <a class="btn btn-danger" href="javascript:void(0)"
								onClick="moveUp('<%=application.getContextPath()%>/TopicElementServlet',this)"> <i
									class="halflings-icon arrow-up"></i>
							</a> <a class="btn btn-danger" href="javascript:void(0)"
								onClick="moveDown('<%=application.getContextPath()%>/TopicElementServlet',this)"> <i
									class=" halflings-icon arrow-down"></i>
							</a></td>

						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!-- end: Content -->
<!-- start: footer-->
<jsp:include page="/janux/layout/_footer.jsp" />
<!-- end: footer-->

