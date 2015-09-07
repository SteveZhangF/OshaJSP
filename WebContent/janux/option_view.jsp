<!-- start: Header -->
<%@page import="database.dao.factory.DAOFactoryImpl"%>
<%@page import="model.OptionElement"%>
<jsp:include page="/janux/layout/_header.jsp" />
<!-- end: Header -->

<div id="content" class="span10">
	<%
		String id = request.getParameter("option_id");
		OptionElement te = DAOFactoryImpl.getOptionElementDAO().findById(id);
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
				
			</div>
		</div>

	</div>

	<!--/span-->

</div>
<!-- start: footer-->
<jsp:include page="/janux/layout/_footer.jsp" />
<!-- end: footer-->

