function submitForm(vurl, vdata,callback) {
	$.ajax({
		cache : true,
		type : "POST",
		url : vurl,
		data : vdata,
		async : false,
		error : function(request) {
		},
		success : function(data) {
			callback(data);
		}
	});
}
