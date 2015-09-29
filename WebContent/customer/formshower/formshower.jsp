<%@page import="database.dao.factory.DAOFactoryImpl"%>
<%@page import="bean.user.data.OrganizationElement"%>
<%@page import="bean.user.data.Employee"%>
<%
	String oe_id = request.getParameter("oe_id");
	OrganizationElement oe = DAOFactoryImpl.getOrganizationElementDAO().getOEbyID(oe_id);
%>
<style>

#form_menu_side {
	position: fixed;
	width: 180px;
	padding: 20px;
	top:120px;
	right:0px;
	border: 2px solid #b2afaf;
}
</style>
<input id="onload_oe_id" type="hidden" name="oe_id" value="<%=oe_id%>">

<div id="form_content">
</div>
<div id="form_submit_button_group" class="span2">
				<button id="bt_submit" onclick="submitCustomizedForm();"
					class="btn btn-primary">Save</button>
				<button id="bt_cancel" onclick="" class="btn btn-primary">Cancel</button>
				
				<button id="bt_preview" 
					class="btn btn-primary">Preview</button>
			</div>
<div id="form_menu_side">

	<ul class="nav navbar-nav" id="form_menu_side_ul">
	</ul>

</div>

<!-- preview modal start -->
<div class="modal fade" id="preview_container" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog">
	
	</div>
</div>
<!-- preview modal end -->






<script src="<%=application.getContextPath()%>/custom/js/leftmenu.js">
</script>
<script>

$(document).ready(function(){
	var oe_id = $("#onload_oe_id").attr("value");
	$.getJSON('<%=application.getContextPath()%>/userform', {
			action : 'showFormSelectJson',
			oe_id : oe_id
		}, function(data) {
			$.each(data, function(j,m) {
				var moduleid = m.id;
				var modulename = m.name;
				var forms = m.forms;
/* 				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Separated link</a></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li> */
					
				$module_li = $("<li class='dropdown'><a href='#' class='dropdown-toggle'	data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>"+modulename+" <span class='caret'></span></a></li>");
				$module_ul=$("<ul class='dropdown-menu'></ul>");
				$module_li.append($module_ul);
				
				$("#form_menu_side_ul").append($module_li);
				$.each(forms,function(i,f){
					var form_name = f.name;
					var form_id = f.uuid;
					$form_li=$("<li></li>");
					$form_li_a = $("<a href='javascript:void(0)'></a>");
					$form_li_a.text(form_name);
					$form_li_a.attr("onclick",'viewForm(\''+form_id+'\',\''+oe_id+'\')');
					$form_li.append($form_li_a);
					$module_ul.append($form_li);
				})
			})
		});
	});
</script>
