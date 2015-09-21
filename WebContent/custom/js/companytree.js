$(document).ready(function() {
	$('#showeditModal').on('hidden.bs.modal', function(e) {
		editcompany();
	});

	var spans_department = $(".tree").find(".department");
	$.each(spans_department, function(i, se) {
		$(se).contextmenu({
			target : '#context-menu-department',
			onItem : function(context, e) {
				var id = $(e.target).attr('id');
				switch (id) {
				case "add_department":
					addDepartment($(context.find("input")).attr("value"), 0);
					break;
				case "edit_department":
					addDepartment('0', $(context.find("input")).attr("value"));
					break;
				case "delete":
					deleteDepartment($(context.find("input")).attr("value"));
					break;
				case "add_employee":
					addEmployee($(context.find("input")).attr("value"), '0');
					break;
				}

			}
		});
	});
	var spans_company = $(".tree").find(".company");
	$.each(spans_company, function(i, se) {
		$(se).contextmenu({
			target : '#context-menu-company',
			onItem : function(context, e) {
				var id = $(e.target).attr('id');
				switch (id) {
				case "add_department":
					addDepartment($(context.find("input")).attr("value"), 0);
					break;
				case "add_employee":
					addEmployee($(context.find("input")).attr("value"), '0');
					break;
				}

			}
		});
	});

	var spans_employee = $(".tree").find(".employee");
	$.each(spans_employee, function(i, se) {
		$(se).contextmenu({
			target : '#context-menu-employee',
			onItem : function(context, e) {
				var id = $(e.target).attr('id');
				switch (id) {
				case "edit_employee":
					addEmployee(0, $(context.find("input")).attr("value"));
					break;
				}

			}
		});
	});
});