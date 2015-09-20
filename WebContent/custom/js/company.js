function editcompany() {
	getForm("./company", "edit");
}
function addDepartment(parentid, myid) {
	submitForm("./department", {
		action : "edit",
		superDepartmentID : parentid,
		department_id : myid
	}, function(data) {
		
		$("#showeditModal").find('.modal-title').text('Department');
		$("#showeditModal").find('.modal-body').html(data);
		$("#showeditModal").modal('toggle')
	});
}

function deleteDepartment(id) {
	submitForm("./department", {
		action : "delete",
		department_id : id
	}, function(data) {
		alert("delete");
	});
}

function addEmployee(departmentID, myid) {
	submitForm("./employee", {
		action : "edit",
		department_id : departmentID,
		employee_id : myid
	}, function(data) {
		$("#showeditModal").find('.modal-title').text('Employee');
		$("#showeditModal").find('.modal-body').html(data);
		$("#showeditModal").modal('toggle');
	});
}

function subOrganazation() {
	var action = $("#showeditModal").find("form").attr("action");
	submitForm(action, $("#showeditModal").find("form").serialize(), function(
			data) {
		alert(data);
		$("#showeditModal").modal('toggle');
	});
}

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