<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
		<link rel="stylesheet" type="text/css" href="<%=path%>css/base/base.css" />
	</head>
	<body>
		<table id="pagehead" cellpadding="0" cellspacing="0" border="0" width="100%">
			<tr>
				<td width="130">
					<h1>
						管理员维护
					</h1>
				</td>
				<td class="actions">&nbsp;</td>
			</tr>
		</table>
		<form action="Add.do" method="post">			
			<table class="maintable">
				<tr>
					<th>
						账号
					</th>
					<td>
						<input class="text" name="account"/><p style= "color:red"><%=request.getAttribute("acc")==null? "": request.getAttribute("acc")%></p>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						密码
					</th>
					<td>
						<input type="password" class="text" name="password"/><p style= "color:red"><%=request.getAttribute("password")==null? "": request.getAttribute("password")%></p>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						姓名
					</th>
					<td>
						<input class="text" name="name"/><p style= "color:red"><%=request.getAttribute("name")==null? "": request.getAttribute("name")%></p>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						权限
					</th>
					<td>
						<input type="radio" name="role" value="1"/>管理员
						<input type="radio" name="role" value="2"checked="checked"/>经理
						<input type="radio" name="role" value="3"/>员工
					</td>
					</tr>
					<th>
						所属超市
					</th>
					<td>
						<%List<Map<String,String>> list = (List<Map<String,String>>) session.getAttribute("List"); %>
						<select name="select">
						<%for(Map<String,String> marketList : list){ %>
							<option value="<%=marketList.get("id")%>"><%=marketList.get("marketname") %></option>
						<%} %>
						</select>
					</td>
					</tr>
				<tr>
					<td colspan="4" class="buttons">
						<input type="submit" class="submit" value=" 添  加 " id="put" />
					</td>
				</tr>
			</table>
		</form>
		
		<script type="text/javascript" src="<%=path%>plugins/My97DatePicker/WdatePicker.js"></script>
	</body>
</html>