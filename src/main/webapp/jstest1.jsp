<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 先引入 jquery的 js -->
<script type="text/javascript" 
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js">
</script>
<!-- 引入 easyui的js -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<!-- 引入国际化 js -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<!-- 引入 默认样式 css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css"/>
<!-- 引入 icon图标 css  -->
<link rel="stylesheet" 
type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css"/>


<!-- 引入ztree  -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css"/>

<head>
</head>


<body class="easyui-layout">
	<div data-options="region:'north',title:'North'" style="height:100px;">北部</div>
	<div data-options="region:'south',title:'South'" style="height:100px;">南部</div>
	<div data-options="region:'west',title:'West'" style="width:300px;">
		<!-- 折叠面板  -->
		<!-- fit属性，使当前div大小占满父容器  -->
		<div class="easyui-accordion" data-options="fit:true">
			<!-- 通过iconCls 设置图标，找 icon.css中 类定义 -->
			<div data-options="title:'基本功能',iconCls:'icon-mini-add'">面板一</div> <!-- 这里每个div就是一个面板 -->
			<div data-options="title:'高级功能',iconCls:'icon-add'">面板二</div>
			<div data-options="title:'管理员功能', iconCls:'icon-edit'">面板三</div>
		</div>
	</div>
	<div data-options="region:'center',title:'Center'" >
		<!-- 选项卡面板 -->
		<div class="easyui-tabs" data-options="fit:true">
			<div data-options="title:'选项卡一'">内容一</div> <!-- 这里每个div 就是一个选项卡 -->
			<!-- closeable 可关闭 -->
			<div data-options="title:'选项卡二',closable:true">内容二</div>
			<div data-options="title:'选项卡三'">内容三</div>
	</div>
		
	</div>
</body>
</html>