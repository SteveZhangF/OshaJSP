function submit_Page(){
	
}


function submit_form(form_id, vurl, receiver_id, action) {
	$(receiver_id).empty().html("<h2>Loading...</h2>");
	$.ajax({
		type : 'POST',
		async : false,
		cache : false,
		url : vurl,
		dataType : 'json',
		data : $(form_id).serialize() + "&action=" + action,
		success : function(dataz) {
			if (dataz.Data!= null) {
				var str = '';
				for (var i = 0; i < dataz.Data.length; i++) {
					str += dataz.Data[i].topic_value;
				}
				$(receiver_id).empty().html(str);
			}
			
		}
	});
}
