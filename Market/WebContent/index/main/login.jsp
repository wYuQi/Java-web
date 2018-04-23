<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<title>四海兴唐学员练习平台</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link href="<%=path %>index/css/login.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<div class="top">
			<img src="<%=path%>index/css/img/login/title.png" />
		</div>
			<form action="which.do" method="post">
			<div class="login_con">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="25%" align="right">
							用户名
						</td>
						<td colspan="2">
							<input type="text" name="ID" id="" style="width: 190px;"/>
						</td>
					</tr>
					<tr>
						<td align="right">
							密码
						</td>
						<td colspan="2">
							<input type="password" name="password" id="" style="width: 190px;"/>
						</td>
					</tr>
					
					<tr>
						<td></td>
						<td><img src="L" alt="" /></td>
					</tr>
					<tr>
						<td align="right">
							验证码
						</td>
						<td colspan="2">
							<input type="text" name="jpg" id="" style="width: 90px;"/>
						</td>
					</tr>	
					<tr>
						<td >
							
						</td>
						<td colspan="2">
							<p style= "color:red"><%=session.getAttribute("wrong")==null? "": session.getAttribute("wrong")%></p>
						</td>
					</tr>
					
				</table>
				<input type="submit" class="login_an" value="登录"/>
			</div>
		</form>
	</body>
</html>