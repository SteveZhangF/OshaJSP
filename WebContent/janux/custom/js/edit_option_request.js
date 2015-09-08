function editElement(url, id, obj) {
	$.post(url, {
		option_id : id,
		action : "edit"
	}, function(data, status) {
		$("#" + obj).find("#modal_body_form").empty().append(data);
	});
}
function createElement(url, parent_id, obj) {
	$.post(url, {
		option_parent_id : parent_id,
		action : "create"
	}, function(data, status) {
		$("#" + obj).find("#modal_body_form").empty().append(data);
	});
}
function updataElement(obj) {
	$("#" + obj).find("form").submit();
	$("#" + obj).modal('hide');
}

function showModal(obj, url, action, id) {
	$("#" + obj).find("#modal_body_form").empty();
	
	$("#" + obj).find("#modal_body_form").append("Loading...");
	$("#" + obj).modal('show').on('show.bs.modal', function() {
		if (action == 0) {
			createElement(url, id, obj);
		} else {
			editElement(url, id, obj);
		}
	});
	
}
function submitForm(vurl, vform, vaction) {
	$.ajax({
		cache : true,
		type : "POST",
		url : vurl,
		data : $("#" + vform).serialize() + "&action=" + vaction,
		async : false,
		error : function(request) {
		},
		success : function(data) {
			$("#option_table").html(data);
		}
	});
}
function submitData(vurl, vdata, vaction) {
	$.ajax({
		cache : true,
		type : "POST",
		url : vurl,
		data : vdata + "&action=" + vaction,
		async : false,
		error : function(request) {
		},
		success : function(data) {
			$("#option_table").html(data);
		}
	});
}