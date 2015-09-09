var RecordCount;//全局变量  总条数  
var PageSize = 5;//全局变量 每页显示多少条数据  

//点击查询时，开始分页  
function btnSearch_Query() {
	AjaxPage(1, PageSize);
}
//分页方法  
function AjaxPage(CurPage, PageSize) {
	//清空数据显示Table  
	$('#topic-content-form').empty();
//	$('#MainContent_AspNetPager_Msg')
//			.html(
//					" <a disabled='disabled' style='margin- right:5px;'>← 上一页</a><span class='cpb' style='margin- right:5px;'>1</span><a disabled='disabled' style='margin- right:5px;'>下一页 →</a>");
	$('#CurrentPageSize').html(CurPage);//页  

	//名称  
	var Name = $('#Search_NameContains').val();

	//组合Json查询条件，查询分页数据 （CurPage、CurPage为必要条件）  
	var CacceyJson = '{"page_id":"' + 1 + '","CurPage":' + CurPage
			+ ',"PageSize":' + PageSize + '}';
	$
			.ajax({
				type : 'POST',
				async : false,
				cache : false,
				url : "AjaxPage/PostAjax.aspx?z=SearchQueryByAjaxPage&a="
						+ Math.random(),
				dataType : 'json',
				data : escape(CacceyJson),
				success : function(data) {
					if (data == null) {
						$('#SearchQuery_Table tbody')
								.html(
										"<tr><td colspan='6' class='red'>未查询到数据！</td></tr>");
					} else if (data != null && data.msg != 'login_timeout') {
						//返回的数据组合形式，然后将对象转换JSON字符串  
						//Dictionary<string, object> dic = new Dictionary<string, object>();  
						//dic.Add("RecordCount", pageArgs.RecordCount);//总条数  
						//dic.Add("Data", list);  
						if (data["Data"] != null) {
							var str = '';
							for (var i = 0; i < data["Data"].length; i++) {
								str += "<tr><td></td></tr>";//组合显示数据  
							}
							$('#SearchQuery_Table tbody').html(str);
							RecordCount = data["RecordCount"];
							$('#pageCount').html(RecordCount);
							//最大页数  
							var maxpage = RecordCount % PageSize == 0 ? parseInt(RecordCount
									/ PageSize)
									: (parseInt(RecordCount / PageSize) + 1);

							$('#MainContent_AspNetPager_Msg').html('');//分页链接  
							var span = "<a style='margin- right: 5px; cursor: pointer;' href='javascript:void(0)' onclick='PageIndexClick(this)' id='TopPage' pageindex='0'& gt;← 上一页</a>";
							var firstPage = 0;
							var pagecount = 0;//循环的次数  
							if (maxpage > 10) {
								pagecount = 10;
							} else {
								pagecount = maxpage;
							}
							if (CurPage > 10) {
								pagecount = CurPage;
								var firstPage = CurPage - 10;
								if (firstPage >= 1) {
									span += "<a style='margin-right: 5px; cursor: pointer;' href='javascript:void(0)'  onclick='CurPageSizeClick("
											+ firstPage + ",this)' >...</a>";
								}
							}
							for (var j = firstPage + 1; j < pagecount + 1; j++) {
								if (j == CurPage) {
									span += "<span class='cpb' style='margin-right: 5px; cursor: pointer;' onclick='CurPageSizeClick("
											+ j + ",this)'>" + j + "</span>";
								} else {
									span += "<a style='margin-right: 5px; cursor: pointer;' href='javascript:void(0)'  onclick='CurPageSizeClick("
											+ j + ",this)' >" + j + "</a>";
								}
							}
							pagecount = pagecount + 1;
							if (maxpage > pagecount) {
								span += "<a style='margin-right: 5px; cursor: pointer;' href='javascript:void(0)'  onclick='CurPageSizeClick("
										+ pagecount + ",this)' >...</a>";
							}
							span += "<a style='margin- right: 5px; cursor: pointer;' href='javascript:void(0)' onclick='PageIndexClick(this)' id='NextPage' pageindex='0'& gt;→ 下一页</a>";
							$('#MainContent_AspNetPager_Msg').html(span);
						} else {
							$('#SearchQuery_Table tbody')
									.html(
											"<tr><td colspan='6' class='red'>未查询到数据！</td></tr>");
						}
					} else if (data.msg == 'login_timeout') {
						LoginTimeout();
					}

				}
			});
}

//首页、上一页、下一页、尾页点击  
function PageIndexClick(obj) {
	//当前第几页  
	var CurrenPageSize = $.trim($('#CurrentPageSize').html());
	if (CurrenPageSize != '') {
		CurrenPageSize = parseInt(CurrenPageSize);
	}
	//id  
	var type = $(obj).attr('id');
	//首页  
	if (type == 'FirstPage') {
		CurrenPageSize = 1;
		AjaxPage(CurrenPageSize, PageSize);
		$('#CurrentPageSize').html('1');
	}
	//上一页  
	else if (type == 'TopPage') {
		if (CurrenPageSize > 1) {
			CurrenPageSize = CurrenPageSize - 1;
		} else {
			CurrenPageSize = 1;
		}
		AjaxPage(CurrenPageSize, PageSize);
		$('#CurrentPageSize').html(CurrenPageSize);
	}
	//下一页  
	else if (type == 'NextPage') {
		var size = CurrenPageSize + 1;
		var maxpage = RecordCount % PageSize == 0 ? parseInt(RecordCount
				/ PageSize) : (parseInt(RecordCount / PageSize) + 1);
		if (size <= maxpage) {
			CurrenPageSize = CurrenPageSize + 1
		}
		AjaxPage(CurrenPageSize, PageSize);
		$('#CurrentPageSize').html(CurrenPageSize);
	}
	//尾页  
	else if (type == 'LastPage') {
		CurrenPageSize = (RecordCount % PageSize == 0 ? parseInt(RecordCount
				/ PageSize) : parseInt(RecordCount / PageSize) + 1);
		AjaxPage(CurrenPageSize, PageSize);
		$('#CurrentPageSize').html(CurrenPageSize);
	}
}

//页数点击   
function CurPageSizeClick(CurPage, obj) {
	$('#CurrentPageSize').html(CurPage);
	AjaxPage(CurPage, PageSize);
}