<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收排标准</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function doAdd() {
		//alert("增加...");
		$("#id").val("");
		$("#name").val("");
		$("#minweight").numberbox("setValue", null);
		$("#maxweight").numberbox("setValue", null);
		$('#addStandardWindow').window("open");
		$('#addStandardWindow').window("setTitle", "增加收派标准");
	}

	function doView() {
		alert("查看...");
	}

	function doDelete() {
		var deleteItem = $("#grid").datagrid('getSelections');
		if(deleteItem.length == 0) {
			$.messager.alert("Error","You should select the item you want to delete","warning");
		}else {
			$("#tableForm").submit();
		}
	}
	//工具栏
	var toolbar = [ {
		id : 'button-view',
		text : '查询',
		iconCls : 'icon-search',
		handler : doView
	}, {
		id : 'button-add',
		text : '增加',
		iconCls : 'icon-add',
		handler : doAdd
	}, {
		id : 'button-delete',
		text : '删除',
		iconCls : 'icon-cancel',
		handler : doDelete
	} ];
	// 定义列
	var columns = [ [ {
		field : 'id',
		checkbox : true,
	}, {
		field : 'name',
		title : '标准名称',
		width : 120,
		align : 'center',

	}, {
		field : 'minweight',
		title : '最小重量',
		width : 120,
		align : 'center'
	}, {
		field : 'maxweight',
		title : '最大重量',
		width : 120,
		align : 'center'
	}, {
		field : 'operator.username',
		title : '操作人',
		width : 120,
		align : 'center',
		formatter : function(value, rowData, rowIndex) {
			if (rowData.user != null) {
				return rowData.user.username;
			}
		}

	}, {
		field : 'updatetime',
		title : '操作时间',
		width : 160,
		align : 'center',
		formatter : function(value, rowData, rowIndex) {
			return rowData.updatetime.replace("T", " ");
		}
	}, {
		field : 'operator.station',
		title : '操作单位',
		width : 200,
		align : 'center',
		formatter : function(value, rowData, rowIndex) {
			if (rowData.user != null) {
				return rowData.user.station;
			}
		}

	} ] ];

	$(function() {
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({
			visibility : "visible"
		});

		// 收派标准数据表格
		$('#grid').datagrid({
			iconCls : 'icon-forward',
			fit : true,
			border : false,
			rownumbers : true,
			striped : true,
			pageList : [ 3, 5, 7 ],
			pagination : true,
			toolbar : toolbar,
			url : "${pageContext.request.contextPath}/standard_pageQuery",
			//url : "json/standard.json",
			idField : 'id',
			columns : columns,
			onDblClickRow : doDblClickRow
		});

		// 添加收派标准窗口
		$('#addStandardWindow').window({
			title : '添加收派标准',
			width : 400,
			modal : true,
			shadow : true,
			closed : true,
			height : 400,
			resizable : false
		});

	});

	function doDblClickRow(rowIndex, rowData) {
		$('#addStandardWindow').window("open");
		$('#addStandardWindow').window("setTitle", "修改收派标准");
		$("#id").val(rowData.id);
		$("#name").val(rowData.name);
		$("#minweight").numberbox("setValue", rowData.minweight);
		$("#maxweight").numberbox("setValue", rowData.maxweight);
	}

	function saveStandardForm() {
		if ($("#standardForm").form("validate")) {
			$("#standardForm").submit();
		} else {
			$.messager.alert("Formate Error",
					"You should type in the correct format", "error");
		}
	}
</script>
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<form id="tableForm" action="${pageContext.request.contextPath}/standard_deleteBatch" method="post">
		<div region="center" border="false">
			<table id="grid"></table>
		</div>
	</form>
	<div class="easyui-window" title="添加/修改收派标准" id="addStandardWindow"
		collapsible="false" minimizable="false" maximizable="false"
		style="top:100px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false"
			border="false">
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="javascript:saveStandardForm()"
					class="easyui-linkbutton" plain="true">保存</a>
			</div>
		</div>
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="standardForm"
				action="${pageContext.request.contextPath}/standard_saveupdate"
				method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">收派标准信息</td>
						<input type="hidden" id="id" name="id" />
					</tr>
					<tr>
						<td>标准名称</td>
						<td><input type="text" id="name" name="name"
							class="easyui-validatebox" required="true" />
						</td>
					</tr>
					<tr>
						<td>最小重量</td>
						<td><input type="text" id="minweight" name="minweight"
							class="easyui-numberbox" />
						</td>
					</tr>
					<tr>
						<td>最大重量</td>
						<td><input type="text" id="maxweight" name="maxweight"
							class="easyui-numberbox" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>