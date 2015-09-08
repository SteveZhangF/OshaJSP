<%@page import="model.OptionElement"%>
<script type="text/javascript" src="<%=application.getContextPath()%>/janux/custom/js/edit_option_request.js">
<!--

//-->
</script>
<%
	OptionElement te = (OptionElement)request.getAttribute("option_element");
%>
<form class="form-horizontal" method="post" id="form_option_edit"
	action="javascript:submitForm('<%=application.getContextPath() %>/OptionElementServlet','form_option_edit','update')">
	<fieldset>
		<div class="control-group">
			<label class="control-label" for="option_name">Option Name: </label>
			<div class="controls">
				<input type="text" class="span6 typeahead" id="option_name"
					name="option_name"
					value="<%if (te != null)
				out.print(te.getName());%>" />
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="option_desc">Description:</label>
			<div class="controls">
				<textarea class="form-control" rows="5" id="option_desc"
					name="option_desc">
					<%
						if (te != null)
							out.print(te.getDescription());
					%>
				</textarea>
			</div>
		</div>
		<input type="hidden"
			value="<%if (te != null)
				out.print(te.getId());%>"
			name="option_id" /> <input type="hidden"
			value="<%if (te != null)
				out.print(te.getParentID());%>"
			name="option_parent_id" /> <input type="hidden"
			value="<%if (te != null)
				out.print(te.getSequenceCode());%>"
			name="option_sequence_code" /> <input type="hidden"
			value="<%if (te != null)
				out.print(te.getType());%>"
			name="option_type" />
	</fieldset>
</form>