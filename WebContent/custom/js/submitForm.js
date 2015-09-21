
// 浏览自定义表单 param formid
function viewForm(formid){
	submitForm("form_operation", {action:"viewform",form_id:formid},function(data) {
		$("#main_container").html(data);
	});
}

//提交表单
/**
 * @param vurl: 表单action地址
 * @param vdata: 表单数据
 * @param callback: 提交成功后回调函数
 * */
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

