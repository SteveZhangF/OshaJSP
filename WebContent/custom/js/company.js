/**
 * when Profile->Company is clicked
 */
function editcompany() {
	submitForm("./company", {
		action : "edit"
	}, function(data) {
		$("#main_container").html(data)
	});
	showTreeMenu();
}

/**
 * request the company's organazation information in a tree format and set it to
 * the left menu
 */
function showTreeMenu() {
	submitForm("./company", {
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
/**
 * delete the department
 * 
 * @param id :
 *            the department id
 */
function deleteDepartment(id) {
	submitForm("./department", {
		action : "delete",
		department_id : id
	}, function(data) {
		alert("delete");
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
	submitForm("./employee", {
		action : "edit",
		department_id : departmentID,
		employee_id : myid
	}, function(data) {
		// $("#showeditModal").find('.modal-title').text('Employee');
		// $("#showeditModal").find('.modal-body').html(data);
		$("#main_container").html(data);
	});
}

function subOrganazation() {
	var action = $("#main_container").find("form").attr("action");
	submitForm(action, $("#main_container").find("form").serialize(), function(
			data) {
		alert(data);
		showTreeMenu();
	});
}
