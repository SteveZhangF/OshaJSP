function editElement(url, id, obj) {
	$.post(url, {
		option_id : id,
		action : "edit"
	}, function(data, status) {
		$("#" + obj).find("#modal_body_form").empty().append(data);
	});
}
function updataElement(obj) {
	$("#" + obj).find("form").submit();
	$("#" + obj).modal('hide');
}
function showModal(obj, url, optionid) {
	$("#" + obj).modal('show').on('shown', function() {
		editElement(url, optionid, obj);
	})
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
function submitData(vurl, vdata, vaction){
	alert("s");
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