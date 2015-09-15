
<!-- start: Content -->
<!DOCTYPE html>
<html lang="en">

<jsp:include page="/layout/_head.jsp" />
<body>
	<jsp:include page="/layout/_header_menu.jsp" />

	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/layout/_left_menu.jsp" />

			<div class="main col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 ">

				<ul class="breadcrumb">
					<li><i class="icon-home"></i> <a href="index.html">Home</a> <i
						class="icon-angle-right"></i></li>
					<li><i class="icon-edit"></i> <a href="#">Forms</a></li>
				</ul>

				<!--start  topic container -->
				<div id="main_container">
				<form id="topic_content_form">
				<input type="hidden" name="page_id" value="1"/>
					<div id="topic_content">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">WQE</h3>
							</div>
							<div class="panel-body">Loading...</div>
						</div>
					</div>
				</form>
				<!--end  topic container -->
				</div>
				<button id="bt_submit" onclick="submitMainForm();" class="btn btn-primary">Save</button>
				<button id="bt_cancel" onclick="" class="btn btn-primary">Cancel</button>
				<nav>
					<ul class="pager">
						<li><a href="#">&larr; Previous</a></li>
						<li><a href="javascript:void(0)" onClick="submit_form(topic_content_form,'<%=application.getContextPath()%>/topicview_servlet.do',topic_content,'next')">Next &rarr;</a></li>
					</ul>
				</nav>
			</div>

		</div>
		<!--/row-->
	</div>

	<jsp:include page="/layout/_footer.jsp" />
	<script type="text/javascript" src="<%=application.getContextPath()%>/custom/js/submitForm.js"></script>
	<script type="text/javascript">
		$.get("<%=application.getContextPath()%>/topicview_servlet.do", {
			page_id : 1,
		}, function(data, status) {
			$("#topic_content").append(data);
		});
	</script>
</body>
</html>