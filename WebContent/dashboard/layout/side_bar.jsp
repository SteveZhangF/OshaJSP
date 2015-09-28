
<div id="sidebar-nav">
	<ul id="dashboard-menu">
		<li >
			 <a href="index.html"> <i class="icon-home"></i> <span>Home</span>
		</a>
		</li>
		<li><a class="dropdown-toggle" href="#"> <i
				class="icon-group"></i> <span>Users</span> <i
				class="icon-chevron-down"></i>
		</a>
			<ul class="submenu">
				<li><a href="javascript:void(0)" onclick="showContent('layout/user-list.jsp',this);">User
						list</a></li>
				<li><a href="javascript:void(0)" onclick="userlist(this);">New
						user form</a></li>
				<li><a href="javascript:void(0)" onclick="userlist(this);">User
						profile</a></li>
			</ul></li>
		<li><a class="dropdown-toggle" href="#"> <i class="icon-edit"></i>
				<span>Forms</span> <i class="icon-chevron-down"></i>
		</a>
			<ul class="submenu">
				<li><a href="javascript:void(0)" onclick="showContent('../form_operation?action=listmodule',this);">All Modules</a></li>
				<li><a href="javascript:void(0)" onclick="userlist(this);">New
						user form</a></li>
				<li><a href="javascript:void(0)" onclick="userlist(this);">User
						profile</a></li>
			</ul></li>
	</ul>
</div>

<script>
	$pointer = $("<div class=\"pointer\"> <div class=\"arrow\"></div><div class=\"arrow_border\"></div></div>");

	function showContent(vurl,obj) {
		$this = $(obj);
		$.ajax({
			cache : true,
			type : "POST",
			url : vurl,
			async : false,
			error : function(request) {

			},
			success : function(data) {
				$("#pad-wrapper").html(data);
				$this.append($pointer);
				
				var lis =$($($this.parent()).parent()).children("li");
				$.each(lis,function(i,li){
					$($(li).children("a")).removeClass("active");
				});
				$this.addClass("active");
			}
		});

	}
</script>