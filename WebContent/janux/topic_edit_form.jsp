<%@page import="model.TopicElement"%>
<%@page import="database.dao.factory.DAOFactoryImpl"%>
<%
		String id = request.getParameter("topic_id");
		TopicElement te = DAOFactoryImpl.getTopicElementDAO().findById(id);
	%>
<form class="form-horizontal" method="post"
	action="../TopicElementServlet">

	<fieldset>
		<div class="control-group">
			<label class="control-label" for="topic_name">Topic Name: </label>
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
				out.print(te.getId());%>"
			name="topic_id" /> <input type="hidden"
			value="<%if (te != null)
				out.print(te.getParentID());%>"
			name="topic_parent_id" /> <input type="hidden"
			value="<%if (te != null)
				out.print(te.getSequenceCode());%>"
			name="topic_sequence_code" /> <input type="hidden"
			value="<%if (te != null)
				out.print(te.getType());%>"
			name="topic_type" />

		<jsp:include page="option_view_all.jsp" />
		<div class="form-actions">
			<button type="submit" class="btn btn-primary">Save changes</button>
			<button type="reset" class="btn">Cancel</button>
		</div>
	</fieldset>
</form>