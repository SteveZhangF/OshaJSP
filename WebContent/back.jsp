
<jsp:include page="/layout/_head.jsp" />
<style>
h3 {
	margin-top: 0;
}

.nav-tabs {
	float: left;
	border-bottom: 0;
}

.nav-tabs li {
	float: none !important;
	margin: 0;
}

.nav-tabs li a {
	margin-right: 0 !important;
	border: 0 !important;
	background-color: #333;
	border-radius: 0 !important;
}

.side li.active {
	border-right: 3px solid #000000 !important;
}

.nav-tabs li a:hover {
	background-color: #444;
	border: 0 !important;
}

.nav-tabs .glyphicon {
	color: #fff;
}

.nav-tabs .active .glyphicon {
	color: #333;
}

.nav-tabs>li.active>a, .nav-tabs>li.active>a:hover, .nav-tabs>li.active>a:focus
	{
	border: 0 !important;
}

.tab-content .tab-pane {
	display: none;
	background-color: #fff;
	/* height: 246px; */
	padding-top: 0;
}

.tab-content .active {
	display: block;
}

.side {
	border-right: 1px solid #eee;
	padding-right: 0px;
}
</style>
<script src="<%=application.getContextPath()%>/custom/js/leftmenu.js"></script>
<body>
	<jsp:include page="/layout/_header_menu.jsp" />

	<div class="container-fluid">
		<div class="row" id="asd"></div>
	</div>
	<script>
		$(document).ready(function() {
			$.getJSON("./form_operation", {
				action : "moduleJSON"
			}, function(data) {
				$.each(data, function(i, e) {
					showModuleMenu(e, $("#asd"));
				})

			})
		});
		function showModuleMenu(e, parent) {
			$all = $(parent);
			$all.createleftmenu("createli", {
				li_toggle : "showmodule" + e.id,
				data : e
			});
			
			$content = $("<div></div>");
			var submodules = e.submodule;
			
			var forms = e.forms;
			
			$all.createleftmenu("createcontent", {
				id : "showmodule" + e.id,
				data : $content
			});
			$.each(submodules, function(g, sm) {
				showModuleMenu(sm, $content);
			});
			$.each(forms, function(j, f) {
				$content.createleftmenu("createli", {
					li_toggle : "showform" + f.uuid,
					data : f
				});
				var formedit;
				$.ajax({
					cache : true,
					type : "POST",
					url : "./form_operation",
					data : {action:"editForm",oper:"create"},
					async : false,
					error : function(request) {
					},
					success : function(data) {
						formedit=data;
					}
				});
				$content.createleftmenu("createcontent",{id:"showform"+f.uuid,data:formedit});
			})
		}
	</script>
	<!-- /container -->
	<jsp:include page="/layout/_footer.jsp" />
</body>