//提交application.jsp 中的main_container 中的所有表单
function submitMainForm(){
	var forms = $("#main_container").find("form");
	$.each(forms, function(i, f) {
		submitForm($(f).attr("action"),$(f).serialize(),function(data){
			alert(data);
		})
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
//获取表单并将表单填充到application.jsp 中的 <div id=main_container></div> 中
function getForm(vurl,vaction){
	submitForm(vurl,{action:vaction},function(data){
		$("#main_container").html(data)
	});
}