
<!-- start: Header -->
<jsp:include page="layout/_header.jsp" />
<!-- end: Header -->
<!-- start: Content -->
<div id="content" class="span10">
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="index.html">Home</a> <i
			class="icon-angle-right"></i></li>
		<li><a href="#">Tables</a></li>
	</ul>
	<jsp:forward page="/TopicElementServlet?action=list&topic_parent_id=111"/>
</div>
<!-- end: Content -->

<!-- start: footer-->
<jsp:include page="/janux/layout/_footer.jsp" />
<!-- end: oo footer-->
