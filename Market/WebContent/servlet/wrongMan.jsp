<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" name="_self"/>
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
			<form action="/Market" method="post">
			<div class="login_con">
				<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td >
							
						</td>
						<td colspan="2">
							<p style= "color:red">您未登陆或账号掉线</p>
						</td>
					</tr>
					<tr>
						<td >
							
						</td>
						<td colspan="2">
							<p style= "color:red">请重新登陆</p>
						</td>
					</tr>
					
				</table>
				<!-- <input type="submit" class="login_an" value="重新登录"/> -->
				<a href="/Market" target="_parent"><input type="submit" class="login_an" value="重新登录"/></a>
			</div>
		</form>
		
	</body>
</html>