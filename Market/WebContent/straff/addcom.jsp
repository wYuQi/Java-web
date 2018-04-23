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
		<form action="AddcomGet.do" method="post">			
			<table class="maintable">
				<tr>
					<th>
						超市
					</th>
					<td>
						<%Map<String,String> man = (Map<String,String>)session.getAttribute("man"); %>
						<select name="market">
							<option value="<%=man.get("marketID")%>"><%=man.get("marketname") %></option>
						</select>
					</td>
					</tr>
				<tr>
					<th>
						商品名
					</th>
					<td>
						<input type="text" class="text" name="goodsName"/>
						<p style= "color:red"><%=request.getAttribute("goodsname")==null? "": request.getAttribute("goodsname")%></p>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						品类
					</th>
					<td>
						<%List<Map<String,String>> type = (List<Map<String,String>>) session.getAttribute("type"); %>
						<select name="typeID">
						<%for(Map<String,String> typeList : type){ %>
							<option value="<%=typeList.get("id")%>"><%=typeList.get("type") %></option>
						<%} %>
						</select>
					</td>
					</tr>
				<tr>
					<th>
						销量
					</th>
					<td>
						<input class="text" name="priceNum"/>
						<p style= "color:red"><%=request.getAttribute("priceNum")==null? "": request.getAttribute("priceNum")%></p>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						厂家
					</th>
					<td>
						<%List<Map<String,String>> list = (List<Map<String,String>>) session.getAttribute("supplerlist"); %>
						<select name="select">
						<%for(Map<String,String> marketList : list){ %>
							<option value="<%=marketList.get("id")%>"><%=marketList.get("name") %></option>
						<%} %>
						</select>
					</td>
					</tr>
				<tr>
					<th>
						进价
					</th>
					<td>
						<input class="text" name="inPrice"/>
						<p style= "color:red"><%=request.getAttribute("inPrice")==null? "": request.getAttribute("inPrice")%></p>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						售价
					</th>
					<td>
						<input class="text" name="outPrice"/>
						<p style= "color:red"><%=request.getAttribute("outPrice")==null? "": request.getAttribute("outPrice")%></p>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						库存
					</th>
					<td>
						<input class="text" name="count"/>
						<p style= "color:red"><%=request.getAttribute("count")==null? "": request.getAttribute("count")%></p>
						<span style="color: red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						容量
					</th>
					<td>
						<input class="text" name="maxcount"/>
						<p style= "color:red"><%=request.getAttribute("maxcount")==null? "": request.getAttribute("maxcount")%></p>
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