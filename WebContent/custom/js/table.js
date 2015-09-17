function showTable(tablesource){
	switch(tablesource){
	case "department":
		showDepartment();
		break;
	case "employee":
		showEmployee();
		break;
	}
}

function showEmployee(){
	var template = "<div style='margin-left:15px;'><div> Employee ID <sup>*</sup>:</div><div> {uuid} </div>";
	template += "<div> Employee Name: </div><div>{employeename} </div>";
	template += "<div> Phone: </div><div>{phone} </div>";
	template += "<div> Address: </div><div>{address} </div>";
	template += "<hr style='width:100%;'/>";
	template += "<div> {sData} {cData}  </div></div>";
	$("#jqGrid")
			.jqGrid(
					{
						url : '',
						// we set the changes to be made at
						// client side using predefined word
						// clientArray
						editurl : 'clientArray',
						datatype : "json",
						colModel : [ {
							label : 'Employee ID',
							name : 'uuid',
							width : 75,
							key : true,
							editable : true,
							editrules : {
								required : true
							}
						}, {
							label : 'Employee Name',
							name : 'employeename',
							width : 140,
							editable : true
						// must set editable to true if you
						// want to make the field editable
						}, {
							label : 'Phone',
							name : 'phone',
							width : 100,
							editable : true
						}, {
							label : 'Address',
							name : 'address',
							width : 80,
							editable : true
						}],
						sortname : 'employeename',
						sortorder : 'asc',
						loadonce : true,
						viewrecords : true,
						width : 780,
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
		editCaption : "The Edit Dialog",
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
function showDepartment(){
	var template = "<div style='margin-left:15px;'><div> Department ID <sup>*</sup>:</div><div> {uuid} </div>";
	template += "<div> Department Name: </div><div>{department_name} </div>";
	template += "<div> Phone: </div><div>{department_telephone} </div>";
	template += "<div> Address Code: </div><div>{department_address} </div>";
	template += "<hr style='width:100%;'/>";
	template += "<div> {sData} {cData}  </div></div>";
	$("#jqGrid")
			.jqGrid(
					{
						url : '',
						// we set the changes to be made at
						// client side using predefined word
						// clientArray
						editurl : 'clientArray',
						datatype : "json",
						colModel : [ {
							label : 'Department ID',
							name : 'uuid',
							width : 75,
							key : true,
							editable : true,
							editrules : {
								required : true
							}
						}, {
							label : 'Department Name',
							name : 'department_name',
							width : 140,
							editable : true
						// must set editable to true if you
						// want to make the field editable
						}, {
							label : 'Phone',
							name : 'department_telephone',
							width : 100,
							editable : true
						}, {
							label : 'Address',
							name : 'department_address',
							width : 80,
							editable : true
						}],
						sortname : 'department_name',
						sortorder : 'asc',
						loadonce : true,
						viewrecords : true,
						width : 780,
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
		editCaption : "The Edit Dialog",
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

function ontableLoading() {
	var template = "<div style='margin-left:15px;'><div> Customer ID <sup>*</sup>:</div><div> {CustomerID} </div>";
	template += "<div> Company Name: </div><div>{CompanyName} </div>";
	template += "<div> Phone: </div><div>{Phone} </div>";
	template += "<div> Postal Code: </div><div>{PostalCode} </div>";
	template += "<div> City:</div><div> {City} </div>";
	template += "<hr style='width:100%;'/>";
	template += "<div> {sData} {cData}  </div></div>";
	$("#jqGrid")
			.jqGrid(
					{
						url : 'http://trirand.com/blog/phpjqgrid/examples/jsonp/getjsonp.php?callback=?&qwery=longorders',
						// we set the changes to be made at
						// client side using predefined word
						// clientArray
						editurl : 'clientArray',
						datatype : "json",
						colModel : [ {
							label : 'Customer ID',
							name : 'CustomerID',
							width : 75,
							key : true,
							editable : true,
							editrules : {
								required : true
							}
						}, {
							label : 'Company Name',
							name : 'CompanyName',
							width : 140,
							editable : true
						// must set editable to true if you
						// want to make the field editable
						}, {
							label : 'Phone',
							name : 'Phone',
							width : 100,
							editable : true
						}, {
							label : 'Postal Code',
							name : 'PostalCode',
							width : 80,
							editable : true
						}, {
							label : 'City',
							name : 'City',
							width : 140,
							editable : true
						} ],
						sortname : 'CustomerID',
						sortorder : 'asc',
						loadonce : true,
						viewrecords : true,
						width : 780,
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
		editCaption : "The Edit Dialog",
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