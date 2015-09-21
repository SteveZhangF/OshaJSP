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

				<!--start  topic container -->
				<div id="main_container">
					<!--end  topic container -->
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