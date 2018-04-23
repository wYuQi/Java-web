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
						修改账户
					</h1>
				</td>
				<td class="actions">&nbsp;</td>
			</tr>
		</table>
	<%Map<String,String> mapMan = (Map<String,String>) session.getAttribute("man"); %>
		<form action="Chengeuser.do" method="post">			
			<table class="maintable">
				<tr>
					<th>
						账号
					</th>
					<td>
						<input read="readonly" class="text" name="account" value="<%=mapMan.get("account")==null ? "" : mapMan.get("account")%>"readonly="readonly"/>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						密码
					</th>
					<td>
						<input type="password" class="text" name="password" value="<%=mapMan.get("password")==null ? "" : mapMan.get("password")%>"readonly="readonly"/>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					
				<tr>
					<th>
						用户名
					</th>
					<td>
						<input class="text" name="name"value="<%=mapMan.get("name")==null ? "" : mapMan.get("name")%>"/>
						<span style="color: red;">*</span>
					</td>
				</tr>
					<th>
						所属超市
					</th>
					<td>
						
						<select name="select">
						
							<option value="<%=mapMan.get("id")%>"><%=mapMan.get("marketname")==null? "" : mapMan.get("marketname")%></option>
						
						</select>
					</td>
					</tr>
					<tr>
					<th>
						年龄
					</th>
					<td>
						<input class="text" name="age"value="<%=mapMan.get("age")==null? "" : mapMan.get("age")%>"/>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						电话
					</th>
					<td>
						<input class="text" name="tell"value="<%=mapMan.get("tel")==null? "" : mapMan.get("tel")%>"/>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						地址
					</th>
					<td>
						<input class="text" name="address"value="<%=mapMan.get("addess")==null? "" :mapMan.get("addess")%>"/>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="buttons">
						<input type="submit" class="submit" value=" 修  改  " id="put"  onclick="update()"/>
					</td>
				</tr>
			</table>
			<input type="hidden" value="<% %>>" id="hd"/>
		</form>
		
		<script type="text/javascript" src="<%=path%>plugins/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
			function update(){
				
				alert("修改成功");
				
			}
			
				function up(){
				var a = document.getElementById("hd");
				alert(a + "gdsg");
				
			}
			
		
		
		
		</script>
	</body>
</html>