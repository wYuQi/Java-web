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
		<form action="AddMarket.do" method="post">			
			<table class="maintable">
				<tr>
					<th>
						名称
					</th>
					<td>
						<input type="text" class="text" name="name"/>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						电话
					</th>
					<td>
						<input class="text" name="tell"/>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						地址
					</th>
					<td>
						<input class="text" name="time"/>
						<span style="color: red;">*</span>
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