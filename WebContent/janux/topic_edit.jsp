<!-- start: Header -->
<%@page import="database.dao.factory.DAOFactoryImpl"%>
<%@page import="model.TopicElement"%>
<jsp:include page="/janux/layout/_header.jsp" />
<%@page import="model.ElementType"%>
<%@page import="java.util.List"%>
<%@page import="model.TopicElement"%>
<!-- end: Header -->

<div id="content" class="span10">
	<%
		//String id = request.getParameter("topic_id");
		TopicElement te = (TopicElement) request.getAttribute("topic_element");
	%>
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="index.html">Home</a> <i
			class="icon-angle-right"></i></li>
		<li><a href="#"> <%
 	String topicName = "";
 	if (te != null) {
 		topicName = te.getName();
 	} else {
 		topicName = "New Topic";
 	}
 %>
		</a></li>
	</ul>

	<div class="row-fluid sortable">
		<div class="box span12">
			<div class="box-header" data-original-title>
				<h2>
					<i class="halflings-icon white edit"></i><span class="break"></span><%=topicName%>
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
					action="<%=application.getContextPath()%>/TopicElementServlet?action=<%if (te == null)
				out.print("save");
			else
				out.print("update");%>">

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

						<!-- start: topictype -->
						<div class="control-group">
							<label class="control-label" for="topic_type">Topic Type:
							</label>
							<div class="controls">
								<select id="topic_type" data-rel="chosen" name="topic_type">
									<%
										List<ElementType> list = DAOFactoryImpl.getElementTypeDAO().findbyClass("topic_type");
										for (ElementType et : list) {
											out.print("<option value=" + et.getName());
											if (te != null && te.getType().equals(et.getValue())) {
												out.print(" selected=\"selected\"");
											}
											out.print(">" + et.getName() + "</option>");
										}
									%>
								</select>
							</div>
						</div>
						<!-- end: topictype -->
						<!-- start: description -->
						<div class="control-group">
							<label class="control-label" for="topic_desc">Description:</label>
							<div class="controls">
								<textarea class="form-control" rows="5" id="topic_desc"
									name="topic_desc">
					<%
						if (te != null)
							out.print(te.getDescription());
					%>
				</textarea>
							</div>
						</div>
						<!-- end: Description -->

						<input type="hidden"
							value="<%if (te != null)
				out.print(te.getId());%>"
							name="topic_id" /> <input type="hidden"
							value="<%if (te != null)
				out.print(te.getParentID());
			else%><%=request.getAttribute("topic_parent_id")%>"
							name="topic_parent_id" /> <input type="hidden"
							value="<%if (te != null)
				out.print(te.getSequenceCode());
			else%><%=request.getAttribute("sequence_code")%>"
							name="topic_sequence_code" />

						<!-- start: option table container -->
						<div id="option_table" class="box span12"></div>
						<!-- end: option table container -->
						
						
						<div class="form-actions">
							<button type="submit" class="btn btn-primary">
								<%
									if (te != null) {
								%>Save changes<%
									} else {
								%>
								Create<%
									}
								%>
							</button>
							<button type="reset" class="btn">Cancel</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="edit_modal.jsp"></jsp:include>
	<p>
		<a data-toggle="modal"
			onclick="showModal('modaledit','<%=application.getContextPath()%>/OptionElementServlet','0',<%=te.getId()%>)"
			href="javascript:void(0)" class="btn btn-primary btn-large">Add
			Option</a>
	</p>
	<!--/span-->
	<script type="text/javascript"
		src="<%=application.getContextPath()%>/janux/custom/js/edit_option_request.js">
									</script>


</div>
<script type="text/javascript">
jQuery(document).ready(function(){
	submitData('<%=application.getContextPath()%>/OptionElementServlet', "option_parent_id=<%=te.getId()%>", 'list');
	});
     </script>
<!-- start: footer-->
<jsp:include page="/janux/layout/_footer.jsp" />
<!-- end: footer-->


