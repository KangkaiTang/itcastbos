package org.apache.jsp.WEB_002dINF.pages.base;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class subarea_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>管理分区</title>\r\n");
      out.write("<!-- 导入jquery核心类库 -->\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.8.3.js\"></script>\r\n");
      out.write("<!-- 导入easyui类库 -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/ext/portal.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/default.css\">\t\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/ext/jquery.portal.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/ext/jquery.cookie.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/easyui/locale/easyui-lang-zh_CN.js\"\r\n");
      out.write("\ttype=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction doAdd(){\r\n");
      out.write("\t\t$('#addSubareaWindow').window(\"open\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction doEdit(){\r\n");
      out.write("\t\talert(\"修改...\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction doDelete(){\r\n");
      out.write("\t\talert(\"删除...\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction doSearch(){\r\n");
      out.write("\t\t$(\"#province\").val(\"\");\r\n");
      out.write("\t\t$(\"#city\").val(\"\");\r\n");
      out.write("\t\t$(\"#district\").val(\"\");\r\n");
      out.write("\t\t$(\"#decideZone\").val(\"\");\r\n");
      out.write("\t\t$(\"#addresskey\").val(\"\");\r\n");
      out.write("\t\t$('#searchWindow').window(\"open\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction doExport(){\r\n");
      out.write("\t\tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/subarea_exportXls\";\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction doImport(){\r\n");
      out.write("\t\talert(\"导入\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//提供提交参数转为json格式的方法\r\n");
      out.write("\t\r\n");
      out.write("\t$.fn.paramToJson=function() {\r\n");
      out.write("\t\tvar jsonObj={};\r\n");
      out.write("\t\tvar array = this.serializeArray();\r\n");
      out.write("\t\t$(array).each(function() {\r\n");
      out.write("\t\t\tif(jsonObj[this.name]) {\r\n");
      out.write("\t\t\t\tif($.isArray(jsonObj[this.name])) {//如果value的值是数组\r\n");
      out.write("\t\t\t\t\tjsonObj[this.name].push(this.value);\r\n");
      out.write("\t\t\t\t} else {//如果value的 不值是数组\r\n");
      out.write("\t\t\t\t\tjsonObj[this.name] = [jsonObj[this.name], this.value];\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tjsonObj[this.name] = this.value; //如果数组不存在\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\treturn jsonObj;\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\t//工具栏\r\n");
      out.write("\tvar toolbar = [ {\r\n");
      out.write("\t\tid : 'button-search',\t\r\n");
      out.write("\t\ttext : '查询',\r\n");
      out.write("\t\ticonCls : 'icon-search',\r\n");
      out.write("\t\thandler : doSearch\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tid : 'button-add',\r\n");
      out.write("\t\ttext : '增加',\r\n");
      out.write("\t\ticonCls : 'icon-add',\r\n");
      out.write("\t\thandler : doAdd\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tid : 'button-edit',\t\r\n");
      out.write("\t\ttext : '修改',\r\n");
      out.write("\t\ticonCls : 'icon-edit',\r\n");
      out.write("\t\thandler : doEdit\r\n");
      out.write("\t},{\r\n");
      out.write("\t\tid : 'button-delete',\r\n");
      out.write("\t\ttext : '删除',\r\n");
      out.write("\t\ticonCls : 'icon-cancel',\r\n");
      out.write("\t\thandler : doDelete\r\n");
      out.write("\t},{\r\n");
      out.write("\t\tid : 'button-import',\r\n");
      out.write("\t\ttext : '导入',\r\n");
      out.write("\t\ticonCls : 'icon-redo',\r\n");
      out.write("\t\thandler : doImport\r\n");
      out.write("\t},{\r\n");
      out.write("\t\tid : 'button-export',\r\n");
      out.write("\t\ttext : '导出',\r\n");
      out.write("\t\ticonCls : 'icon-undo',\r\n");
      out.write("\t\thandler : doExport\r\n");
      out.write("\t}];\r\n");
      out.write("\t// 定义列\r\n");
      out.write("\tvar columns = [ [ {\r\n");
      out.write("\t\tfield : 'id',\r\n");
      out.write("\t\tcheckbox : true,\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'showid',\r\n");
      out.write("\t\ttitle : '分拣编号',\r\n");
      out.write("\t\twidth : 120,\r\n");
      out.write("\t\talign : 'center',\r\n");
      out.write("\t\tformatter : function(data,row ,index){\r\n");
      out.write("\t\t\treturn row.id;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t},{\r\n");
      out.write("\t\tfield : 'province',\r\n");
      out.write("\t\ttitle : '省',\r\n");
      out.write("\t\twidth : 120,\r\n");
      out.write("\t\talign : 'center',\r\n");
      out.write("\t\tformatter : function(data,row ,index){\r\n");
      out.write("\t\t\treturn row.region.province;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'city',\r\n");
      out.write("\t\ttitle : '市',\r\n");
      out.write("\t\twidth : 120,\r\n");
      out.write("\t\talign : 'center',\r\n");
      out.write("\t\tformatter : function(data,row ,index){\r\n");
      out.write("\t\t\treturn row.region.city;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'district',\r\n");
      out.write("\t\ttitle : '区',\r\n");
      out.write("\t\twidth : 120,\r\n");
      out.write("\t\talign : 'center',\r\n");
      out.write("\t\tformatter : function(data,row ,index){\r\n");
      out.write("\t\t\treturn row.region.district;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'addresskey',\r\n");
      out.write("\t\ttitle : '关键字',\r\n");
      out.write("\t\twidth : 120,\r\n");
      out.write("\t\talign : 'center'\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'startnum',\r\n");
      out.write("\t\ttitle : '起始号',\r\n");
      out.write("\t\twidth : 100,\r\n");
      out.write("\t\talign : 'center'\r\n");
      out.write("\t}, {\r\n");
      out.write("\t\tfield : 'endnum',\r\n");
      out.write("\t\ttitle : '终止号',\r\n");
      out.write("\t\twidth : 100,\r\n");
      out.write("\t\talign : 'center'\r\n");
      out.write("\t} , {\r\n");
      out.write("\t\tfield : 'single',\r\n");
      out.write("\t\ttitle : '单双号',\r\n");
      out.write("\t\twidth : 100,\r\n");
      out.write("\t\talign : 'center'\r\n");
      out.write("\t} , {\r\n");
      out.write("\t\tfield : 'position',\r\n");
      out.write("\t\ttitle : '位置',\r\n");
      out.write("\t\twidth : 200,\r\n");
      out.write("\t\talign : 'center'\r\n");
      out.write("\t} ] ];\r\n");
      out.write("\t\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t// 先将body隐藏，再显示，不会出现页面刷新效果\r\n");
      out.write("\t\t$(\"body\").css({visibility:\"visible\"});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 收派标准数据表格\r\n");
      out.write("\t\t$('#grid').datagrid( {\r\n");
      out.write("\t\t\ticonCls : 'icon-forward',\r\n");
      out.write("\t\t\tfit : true,\r\n");
      out.write("\t\t\tborder : true,\r\n");
      out.write("\t\t\trownumbers : true,\r\n");
      out.write("\t\t\tstriped : true,\r\n");
      out.write("\t\t\tpageList: [1,3,5],\r\n");
      out.write("\t\t\tpagination : true,\r\n");
      out.write("\t\t\ttoolbar : toolbar,\r\n");
      out.write("\t\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/subarea_conditionQuery\",\r\n");
      out.write("\t\t\tidField : 'id',\r\n");
      out.write("\t\t\tcolumns : columns,\r\n");
      out.write("\t\t\tonDblClickRow : doDblClickRow\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 添加、修改分区\r\n");
      out.write("\t\t$('#addSubareaWindow').window({\r\n");
      out.write("\t        title: '添加修改分区',\r\n");
      out.write("\t        width: 600,\r\n");
      out.write("\t        modal: true,\r\n");
      out.write("\t        shadow: true,\r\n");
      out.write("\t        closed: true,\r\n");
      out.write("\t        height: 400,\r\n");
      out.write("\t        resizable:false\r\n");
      out.write("\t    });\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 查询分区\r\n");
      out.write("\t\t$('#searchWindow').window({\r\n");
      out.write("\t        title: '查询分区',\r\n");
      out.write("\t        width: 400,\r\n");
      out.write("\t        modal: true,\r\n");
      out.write("\t        shadow: true,\r\n");
      out.write("\t        closed: true,\r\n");
      out.write("\t        height: 400,\r\n");
      out.write("\t        resizable:false\r\n");
      out.write("\t    });\r\n");
      out.write("\t\t$(\"#btn\").click(function(){\r\n");
      out.write("\t\t\t//关闭窗口\r\n");
      out.write("\t\t\t$(\"#searchWindow\").window('close');\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar params = $(\"#subareaCQ\").paramToJson();\r\n");
      out.write("\t\t\t$(\"#grid\").datagrid('load', params);\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction doDblClickRow(){\r\n");
      out.write("\t\talert(\"双击表格数据...\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction subareaSaveOrUpload() {\r\n");
      out.write("\t\tif($(\"#subareaSU\").form('validate')) {\r\n");
      out.write("\t\t\t$(\"#subareaSU\").submit();\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$.messager.alert(\"Error\",\"请输入必填项\",'error');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\t\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\" style=\"visibility:hidden;\">\r\n");
      out.write("\t<div region=\"center\" border=\"false\">\r\n");
      out.write("    \t<table id=\"grid\"></table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 添加 修改分区 -->\r\n");
      out.write("\t<div class=\"easyui-window\" title=\"分区添加修改\" id=\"addSubareaWindow\" collapsible=\"false\" minimizable=\"false\" maximizable=\"false\" style=\"top:20px;left:200px\">\r\n");
      out.write("\t\t<div style=\"height:31px;overflow:hidden;\" split=\"false\" border=\"false\" >\r\n");
      out.write("\t\t\t<div class=\"datagrid-toolbar\">\r\n");
      out.write("\t\t\t\t<a id=\"save\" icon=\"icon-save\" href=\"javascript:subareaSaveOrUpload()\" class=\"easyui-linkbutton\" plain=\"true\" >保存</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div style=\"overflow:auto;padding:5px;\" border=\"false\">\r\n");
      out.write("\t\t\t<form id=\"subareaSU\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/subarea_saveOrUpdate\" method=\"post\">\r\n");
      out.write("\t\t\t\t<table class=\"table-edit\" width=\"80%\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<tr class=\"title\">\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">分区信息</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>分拣编码</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"id\" class=\"easyui-validatebox\" required=\"true\"/></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>选择区域</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input  class=\"easyui-combobox\" name=\"region.id\" \r\n");
      out.write("\t\t\t\t\t\t\tdata-options=\"valueField:'id',textField:'info',url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/region_ajaxlist'\" />\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>关键字</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"addresskey\" class=\"easyui-validatebox\" required=\"true\"/></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>起始号</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"startnum\" class=\"easyui-validatebox\" required=\"true\"/></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>终止号</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"endnum\" class=\"easyui-validatebox\" required=\"true\"/></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>单双号</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<select class=\"easyui-combobox\" name=\"single\" style=\"width:150px;\">  \r\n");
      out.write("\t\t\t\t\t\t\t    <option value=\"0\">单双号</option>  \r\n");
      out.write("\t\t\t\t\t\t\t    <option value=\"1\">单号</option>  \r\n");
      out.write("\t\t\t\t\t\t\t    <option value=\"2\">双号</option>  \r\n");
      out.write("\t\t\t\t\t\t\t</select> \r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>位置信息</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"position\" class=\"easyui-validatebox\" required=\"true\" style=\"width:250px;\"/></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 查询分区 -->\r\n");
      out.write("\t<div class=\"easyui-window\" title=\"查询分区窗口\" id=\"searchWindow\" collapsible=\"false\" minimizable=\"false\" maximizable=\"false\" style=\"top:20px;left:200px\">\r\n");
      out.write("\t\t<div style=\"overflow:auto;padding:5px;\" border=\"false\">\r\n");
      out.write("\t\t\t<form id=\"subareaCQ\">\r\n");
      out.write("\t\t\t\t<table class=\"table-edit\" width=\"80%\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<tr class=\"title\">\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">查询条件</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>省</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" id=\"province\" name=\"region.province\"/></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>市</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" id=\"city\" name=\"region.city\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>区（县）</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" id=\"district\" name=\"region.district\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>定区编码</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" id=\"decideZone\" name=\"decideZone.id\"/></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>关键字</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" id=\"addressKey\" name=\"addresskey\"/></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"><a id=\"btn\" href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search'\">查询</a> </td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
