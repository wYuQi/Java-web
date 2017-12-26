<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,java.util.Map"%>
    <%	
    	Object list = request.getAttribute("List"); 
 	 	List<Map<String,String>> goodlist = (List<Map<String,String>>)  list;
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>种类</td>
			<td>编号</td>
			<td>价格</td>
			<td>库存</td>
			<td>操作</td>
		</tr>
		<%
			for(Map<String,String> map : goodlist){%>
				
			
		
		<tr>
			<td><%=map.get("name")%></td>
			<td><%=map.get("number")%></td>
			<td><%=map.get("jia")%></td>
			<td><%=map.get("have")%></td>
			<td>
				<a>编辑</a>
				<a href="dele.uhtml?number=<%=map.get("number")%>">删除</a>
				<a>购买</a>
			</td>
		</tr>
		<% }%>
	</table>
	
</body>
</html>