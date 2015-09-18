<jsp:useBean id="user" scope="session" class="bean.user.User" />
<!-- start: Content -->
<!DOCTYPE html>
<html lang="en">

<jsp:include page="/layout/_head.jsp" />
<body>
	<jsp:include page="/layout/_header_menu.jsp" />

	<div class="container-fluid">
		<div class="row">
		<%if(user.getUser_email()!=null){ %>
			<jsp:include page="/layout/_left_menu.jsp" />
		<%} %>
			<div class="main col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 ">

				<ul class="breadcrumb">
					<li><i class="icon-home"></i> <a href="application.jsp">Home</a> <i
						class="icon-angle-right"></i></li>
					<li><i class="icon-edit"></i> <a href="#">XXX</a></li>
				</ul>

				<!--start  topic container -->
				<div id="main_container">
					<!--end  topic container -->
				</div>
				<div id="form_submit_button_group" class="container-fluid center">
					<button id="bt_submit" onclick="submitMainForm();"
						class="btn btn-primary">Save</button>
					<button id="bt_cancel" onclick="" class="btn btn-primary">Cancel</button>
				</div>
				<nav>
					<ul class="pager">
						<li><a href="#">&larr; Previous</a></li>
						<li><a href="#">Next &rarr;</a></li>
					</ul>
				</nav>
			</div>

		</div>
		<!--/row-->
	</div>

	<jsp:include page="/layout/_footer.jsp" />
	<script type="text/javascript"
		src="<%=application.getContextPath()%>/custom/js/submitForm.js"></script>
</body>
</html>