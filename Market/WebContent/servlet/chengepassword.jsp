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
						修改密码
					</h1>
				</td>
				<td class="actions">&nbsp;</td>
			</tr>
		</table>
	<%Map<String,String> mapMan = (Map<String,String>) session.getAttribute("man"); %>
		<form action="Chengepassword.do" method="post">			
			<table class="maintable">
				<tr>
					<th>
						账号
					</th>
					<td>
						<input read="readonly" class="text" name="account" value="<%=mapMan.get("account")==null ? "" : mapMan.get("account")%>" readonly="readonly"/>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						密码
					</th>
					<td>
						<input type="password" class="text" name="password" value="<%=mapMan.get("password")==null ? "" : mapMan.get("password")%>"/>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						确认密码
					</th>
					<td>
						<input type="password" class="text" name="repassword" value=""/>
						<span style="color: red;">*</span>
					
					
							<p style= "color:red"><%=request.getAttribute("sure")==null? "": request.getAttribute("sure")%></p>
						</td>
				</tr>
				
					
				
		
				<tr>
					<td colspan="4" class="buttons">
						<input type="submit" class="submit" value=" 修  改  " id="put" />
					</td>
				</tr>
			</table>
		</form>
		
		<script type="text/javascript" src="<%=path%>plugins/My97DatePicker/WdatePicker.js"></script>
	</body>
</html>