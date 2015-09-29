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
					alert();
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
				case "delete_employee":
					deleteEmployee($(context.find("input")).attr("value"));
					break;
				}

			}
		});
	});
});




/**
 * request the company's organazation information in a tree format and set it to
 * the left menu
 */
function showTreeMenu() {
	submitForm("../company", {
		action : "showTreeMenu"
	}, function(data) {
		$(".sidebar").html("");
		$(".sidebar").html(data);
		$.getScript('./custom/js/menu_tree.js', function() {
		});
		$.getScript('./custom/js/companytree.js', function() {
		});
	});
}

/**
 * add or edit the department
 * 
 * @param parentid:
 *            the parent department id(set it to '-1' if add the department to
 *            the company)
 * @param myid :
 *            the id of edited department(set it to '-1' if create a new one)
 */
function addDepartment(parentid, myid) {
	submitForm("../department", {
		action : "edit",
		superDepartmentID : parentid,
		department_id : myid
	}, function(data) {
		alert();
		$(".form_shower").html(data);
	});
}
/**
 * delete the department
 * 
 * @param id :
 *            the department id
 */
function deleteDepartment(id) {
	submitForm("../department", {
		action : "delete",
		department_id : id
	}, function(data) {
		showTreeMenu();
	});
}
/**
 * add or edit the employee
 * 
 * @param departmentID:
 *            add the employee to which department (set it to '-1' if add the
 *            employee to the company)
 * @param myid:
 *            the employee id (set it to '-1' if create a new employee)
 * 
 * the form will be shown in the right frame (<div "#main_container"> in
 * application.jsp)
 */
function addEmployee(departmentID, myid) {
	submitForm("../employee", {
		action : "edit",
		department_id : departmentID,
		employee_id : myid
	}, function(data) {
		// $("#showeditModal").find('.modal-title').text('Employee');
		// $("#showeditModal").find('.modal-body').html(data);
		$(".form_shower").html(data);
	});
}
function deleteEmployee(id) {
	submitForm("../employee", {
		action : "delete",
		employee_id : id
	}, function(data) {
		showTreeMenu();
	});
}

function subOrganazation() {
	var action = $("#main_container").find("#contactForm").attr("action");
	submitForm(action, $("#main_container").find("#contactForm").serialize(), function(
			data) {
		alert(data);
		showTreeMenu();
	});
}
