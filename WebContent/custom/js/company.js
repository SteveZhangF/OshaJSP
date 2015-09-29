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
