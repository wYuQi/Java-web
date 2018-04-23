   <%@ page language="java" import="java.util.*"import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
			 <%
			   Map<String,String>  user =(Map<String,String>)session.getAttribute ("userlist" );
			 
 %>
			<table id="pagehead" cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr>
					<td width="130"><h1>查看用户</h1></td>
					<!-- 标题连接 -->
					<!-- 注！如果没有功能链接，此td内必须写入&nbsp; -->
					<td class="actions">&nbsp;</td>
				</tr>
			</table>
   			
   			<!-- 列表区 -->
   			<table class="listtable stripe">
   				<tr>
   					<th width="100">编号</th>
   					<th width="120">账号</th>
   					<th width="120">密码</th>
   					<th width="120">姓名</th>
   					<th width="120">年龄</th>
   					<th width="120">性别</th>
   					<th width="120">电话</th>
   					<th width="120">个人住址</th>
   					<th width="120">角色ID</th>
   					<th width="120">超市ID</th>
   					<th  >所属超市</th>
   					<th width="300">操作</th>
   					 
   					
   					
   				</tr>
   				
   				<tr>
   				 
   			
   					<td align="center"><%=user.get("id")%></td>
   					<td align="center"><%=user.get("account")%></td>
   					<td align="center"><%=user.get("password")%></td>
   					<td align="center"><%=user.get("Name")%></td>
   				    <td align="center"><%=user.get("age")%></td>
   				    <td align="center"><%=user.get("sex")%></td>
   				    <td align="center"><%=user.get("tel")%></td>
   				    <td align="center"><%=user.get("address")%></td>
   				    <td align="center"><%=user.get("roleid")%></td>
   				    <td align="center"><%=user.get("marketid")%></td>
   				   
   			        <td align="center">
						
	   					<a href="UpdateUserShow.do?id=<%=user.get("id")%>" class="edit">编辑</a>
	   					 
	   					
   					</td>
   					
   				</tr>
   				 
   				
   			</table>
	   			
		</div>
		<script type="text/javascript" src="<%=path%>plugins/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=path%>plugins/jQuery/jquery.js"></script>
		<script type="text/javascript" src="<%=path%>js/common.js"></script>
	</body>
</html>

  

}
