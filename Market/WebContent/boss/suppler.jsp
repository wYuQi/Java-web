<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,java.util.Map"%>
    <%	System.out.println("页面加载");
    	Object list = session.getAttribute("suppler"); 
    	if(list == null)System.out.print("kong");
 	 	List<Map<String,String>> marketList = (List<Map<String,String>>)  list;
    %>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link rel="stylesheet" type="text/css" href="<%=path %>css/base/base.css"/>
	</head>
	<body>
		<!-- 如果页面有滚动条，或将来有可能出现滚动条，需要加上此div。*如果没有滚动条加上也无妨 -->
		<div class="div_bk">
			<!-- 标题、功能区域 -->
			<table id="pagehead" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td width="130"><h1>标题名称</h1></td>
					<!-- 标题连接 -->
					<!-- 注！如果没有功能链接，此td内必须写入&nbsp; -->
					<td class="actions">&nbsp;</td>
				</tr>
			</table>
   			
   			<!-- 列表区 -->
   			<table class="listtable stripe">
   				<tr>
   					<th width="100">编号</th>
   					<th width="120">商品</th>
   					<th width="120">厂家名</th>
   					<th width="120">电话</th>
   					<th>权限</th>
   				</tr>
   				<tbody>
   				<% for(Map<String,String> map: marketList){%>
   				<tr>
   					<td align="center"><%=map.get("id")%></td>
		             <td align="center"><%=map.get("goods")%></td>
		             <td align="center"><%=map.get("name")%></td>
		             <td align="center"><%=map.get("tell")%></td>
   					<td align="center">
	   					<a href="javascript:void(0)" class="edit">编辑</a>
	   					<a href="Suppler.do?id=<%=map.get("id") %>" class="delete">删除</a>
	   					<a href="servlet/Add.jsp" class="add">添加</a>
   					</td>
   				</tr>
   				<% }%>
   				</tbody>
   			</table>
	   			
		</div>
		<script type="text/javascript" src="<%=path%>plugins/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=path%>plugins/jQuery/jquery.js"></script>
		<script type="text/javascript" src="<%=path%>js/common.js"></script>
	</body>
</html>