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
		<form action="">			
			<table class="maintable">
				<tr>
					<th>
						用户名
					</th>
					<td>
						<input class="text"/>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						密码
					</th>
					<td>
						<input type="password" class="text"/>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						确认密码
					</th>
					<td>
						<input type="password" class="text"/>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						真实姓名
					</th>
					<td>
						<input class="text"/>
					</td>
				</tr>
				<tr>
					<th>
						手机
					</th>
					<td>
						<input class="text"/>
					</td>
				</tr>
				<tr>
					<th>
						邮箱
					</th>
					<td>
						<input class="text"/>
					</td>
				</tr>
				<tr>
					<th>
						职位
					</th>
					<td>
						<input class="text"/>
					</td>
				</tr>
				<tr>
					<th>
						部门
					</th>
					<td>
						<input class="text"/>
					</td>
				</tr>
				<tr>
					<th>
						时间
					</th>
					<td>
						<input readonly="readonly" type="text" class="text" style="width:100px;" onfocus="WdatePicker();"/> 
					</td>
				</tr>
				<tr>
					<th>
						备注
					</th>
					<td>
						<textarea rows="6" cols="85" class="text"></textarea>
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