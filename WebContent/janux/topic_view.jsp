<!-- start: Header -->
<%@page import="database.dao.factory.DAOFactoryImpl"%>
<%@page import="model.TopicElement"%>
<jsp:include page="/janux/layout/_header.jsp" />
<!-- end: Header -->

<div id="content" class="span10">
	<%
		String id = request.getParameter("topic_id");
		TopicElement te = DAOFactoryImpl.getTopicElementDAO().findById(id);
	%>
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="index.html">Home</a> <i
			class="icon-angle-right"></i></li>
		<li><a href="#"> <%
 	if (te != null)
 		out.println(te.getName());
 %>
		</a></li>
	</ul>

	<div class="row-fluid sortable">
		<div class="box span12">
			<div class="box-header" data-original-title>
				<h2>
					<i class="halflings-icon white edit"></i><span class="break"></span>Form
					Elements
				</h2>
				<div class="box-icon">
					<a href="#" class="btn-setting"><i
						class="halflings-icon white wrench"></i></a> <a href="#"
						class="btn-minimize"><i
						class="halflings-icon white chevron-up"></i></a> <a href="#"
						class="btn-close"><i class="halflings-icon white remove"></i></a>
				</div>
			</div>
			<div class="box-content">
				<form class="form-horizontal" method="post"
					action="../TopicElementServlet">
					<fieldset>
						<div class="control-group">
							<label class="control-label" for="topic_name">Topic Name:
							</label>
							<div class="controls">
								<input type="text" class="span6 typeahead" id="topic_name"
									name="topic_name"
									value="<%if (te != null)
				out.print(te.getName());%>" />
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="topic_desc">Description:</label>
							<div class="controls">
								<textarea class="form-control" rows="5" id="topic_desc"
									name="topic_desc"><%
										if (te != null)
											out.print(te.getDescription());
									%></textarea>
							</div>
						</div>
						<input type="hidden"
							value="<%if (te != null)
				out.print(te.getId());%>" name="topic_id" />
						<input type="hidden"
							value="<%if (te != null)
				out.print(te.getParentID());%>"
							name="topic_parent_id" /> <input type="hidden"
							value="<%if (te != null)
				out.print(te.getSequenceCode());%>"
							name="topic_sequence_code" /> <input type="hidden"
							value="<%if (te != null)
				out.print(te.getClass().getName());%>"
							name="topic_type" />
						<div class="form-actions">
							<button type="submit" class="btn btn-primary">Save
								changes</button>
							<button type="reset" class="btn">Cancel</button>
						</div>
					</fieldset>
				</form>

			</div>
		</div>

	</div>

	<!--/span-->

</div>
<!-- start: footer-->
<jsp:include page="/janux/layout/_footer.jsp" />
<!-- end: footer-->

