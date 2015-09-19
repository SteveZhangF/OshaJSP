function moduleOnClick() {
	submitForm('./form_operation', {
		action : 'listmodule'
	}, function(data) {
		$('#module_collapse').html(data)
	});

	submitForm('./form_operation', {
		action : 'tablemodule'
	}, function(data) {
		$('#main_container').html(data)
	});
}

function showModuleTable() {
	var template = "<div style='margin-left:15px;'>";
	template += "<div> Module Name: </div><div>{name} </div>";
	template += "<hr style='width:100%;'/>";
	template += "<div> {sData} {cData}  </div></div>";
	$("#jqGrid").jqGrid({
		url : './form_operation?action=moduleJSON',
		// we set the changes to be made at
		// client side using predefined word
		// clientArray
		editurl : './form_operation?action=editModule',
		datatype : "json",
		colModel : [ {
			label : 'Module ID',
			name : 'id',
			width : 300,
			key : true,
			editable : false,
			editrules : {
				required : true
			}
		}, {
			label : 'Module Name',
			name : 'name',
			width : 400,
			editable : true
		} ],
		sortname : 'name',
		sortorder : 'asc',
		loadonce : true,
		viewrecords : true,
		width : 700,
		height : 200,
		rowNum : 10,
		pager : "#jqGridPager"
	});

	$('#jqGrid').navGrid('#jqGridPager',
	// the buttons to appear on the toolbar of the grid
	{
		edit : true,
		add : true,
		del : true,
		search : false,
		refresh : false,
		view : false,
		position : "left",
		cloneToTop : false
	},
	// options for the Edit Dialog
	{
		editCaption : "Edit Module",
		template : template,
		errorTextFormat : function(data) {
			return 'Error: ' + data.responseText
		}
	},
	// options for the Add Dialog
	{
		template : template,
		errorTextFormat : function(data) {
			return 'Error: ' + data.responseText
		}
	},
	// options for the Delete Dailog
	{
		errorTextFormat : function(data) {
			return 'Error: ' + data.responseText
		}
	});
}

var moduleid_quanju;

function showFormTable(moduleid) {
	moduleid_quanju = moduleid;
	var template = "<div style='margin-left:15px;'>";
	template += "<div> Module Name: </div><div>{name} </div>";
	template += "<hr style='width:100%;'/>";
	template += "<div> {sData} {cData}  </div></div>";
	$("#jqGrid").jqGrid({
		url : './form_operation?action=formJSON&module_id=' + moduleid,
		// we set the changes to be made at
		// client side using predefined word
		// clientArray
		editurl : './form_operation?action=editModule',
		datatype : "json",
		colModel : [ {
			label : 'Form ID',
			name : 'id',
			width : 300,
			key : true,
			editable : false,
			editrules : {
				required : true
			}
		}, {
			label : 'Form Name',
			name : 'name',
			width : 400,
			editable : true
		}, {
			label : 'Form Type',
			name : 'form_type',
			width : 400,
			editable : true
		} ],
		sortname : 'name',
		sortorder : 'asc',
		loadonce : true,
		viewrecords : true,
		width : 700,
		height : 200,
		rowNum : 10,
		pager : "#jqGridPager"
	});

	$('#jqGrid').navGrid('#jqGridPager',
	// the buttons to appear on the toolbar of the grid
	{
		edit : false,
		add : false,
		del : true,
		search : true,
		refresh : true,
		view : false,
		position : "left",
		cloneToTop : false
	},
	// options for the Edit Dialog
	{
		editCaption : "Edit Module",
		template : template,
		errorTextFormat : function(data) {
			return 'Error: ' + data.responseText
		}
	},
	// options for the Add Dialog
	{
		template : template,
		errorTextFormat : function(data) {
			return 'Error: ' + data.responseText
		}
	},
	// options for the Delete Dailog
	{
		errorTextFormat : function(data) {
			return 'Error: ' + data.responseText
		}
	});
	$('#jqGrid').navButtonAdd('#jqGridPager', {
		buttonicon : "ui-icon-mail-closed",
		title : "New",
		caption : "New",
		position : "last",
		onClickButton : createFormonClick
	});

	// / add second custom button
	$('#jqGrid').navButtonAdd('#jqGridPager', {
		buttonicon : "ui-icon-pencil",
		title : "Edit",
		caption : "Edit",
		position : "last",
		onClickButton : createFormonClick
	});

}
function createFormonClick() {
	$.post("./form_operation", {
		action : 'editForm',
		module_id : moduleid_quanju,
		oper : "create"
	}, function(dataz) {
		$("#main_container").html(dataz);
	});
}
function showModule(vid) {
	$.post("./form_operation", {
		action : 'tableForm',
		module_id : vid
	}, function(dataz) {
		// alert(dataz);
		$("#main_container").html(dataz);
	});
}

function saveForm() {
	var xml = parseForm();
	var whom = $("#whom").val();
	$.post("./form_operation", {
		action : "editForm",
		oper : "add",
		module_id : moduleid_quanju,
		form_type : whom,
		formDATA : xml
	}, alert("success"));

}

function showUserTable() {
	// var template = "<div style='margin-left:15px;'>";
	// template += "<div> Module Name: </div><div>{name} </div>";
	// template += "<hr style='width:100%;'/>";
	// template += "<div> {sData} {cData} </div></div>";

	$("#jqGrid").jqGrid({
		url : './user_admin?action=userJSON',
		editurl : './user_admin?action=editUser',
		datatype : "json",
		colModel : [ {
			label : 'User ID',
			name : 'id',
			width : 300,
			key : true,
			editable : false,
			editrules : {
				required : true
			}
		}, {
			label : 'User Email',
			name : 'email',
			width : 400,
			editable : true
		}, {
			label : "Company Name",
			name : "company_name"
		} ],
		sortname : 'name',
		sortorder : 'asc',
		loadonce : true,
		viewrecords : true,
		width : 700,
		height : 200,
		rowNum : 10,
		pager : "#jqGridPager"
	});

	$('#jqGrid').navGrid('#jqGridPager',
	// the buttons to appear on the toolbar of the grid
	{
		edit : false,
		add : false,
		del : false,
		search : true,
		refresh : true,
		view : false,
		position : "left",
		cloneToTop : false
	}
	// options for the Edit Dialog
	// options for the Add Dialog
	// options for the Delete Dailog
	);
}