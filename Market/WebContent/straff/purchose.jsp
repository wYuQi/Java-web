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
		<form action="PurchoseGet.do" method="post">			
			<table class="maintable">
					<tr>
					<th>
						商品名
					</th>
					<td>
						<%List<Map<String,String>> list = (List<Map<String,String>>) session.getAttribute("purchose"); %>
						<select name="select">
						<%for(Map<String,String> marketList : list){ %>
							<option value="<%=marketList.get("id")%>"><%=marketList.get("goodsName") %>(<%=marketList.get("count")%>/<%=marketList.get("maxcount")%>)</option>
						<%} %>
						</select>
					</td>
					</tr>
				<tr>
					<th>
						数量
					</th>
					<td>
						<input class="text" name="account"/><p style= "color:red"><%=session.getAttribute("enough")==null? "": session.getAttribute("enough")%></p>
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