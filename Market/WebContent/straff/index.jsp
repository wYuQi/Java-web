<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<%Map<String,String> list = (Map<String,String>) session.getAttribute("man"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>员工操作</title>
		<base href="<%=basePath%>" target="main_ifrm"/>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link rel="stylesheet" type="text/css" href="<%=path%>index/css/index.css" />
	</head>
	<body scroll="no">
		<div class="head_bj">
			<div class="head_1">
				<div class="head_info">
					<div style="float: left;">
						欢迎您&nbsp;&nbsp;
						<%=list.get("name") %>&nbsp;&nbsp;&nbsp;&nbsp;
						<%=list.get("rolename") %>
							&nbsp;&nbsp;&nbsp;&nbsp;<%=list.get("marketname") %>
								
					</div>
					<a href="Close.do" class="aqtc" style="margin-right: 25px;" target="_top">安全退出</a>
				</div>
			</div>
			<ul class="nav">
				<!-- 一个模块开始 -->
				<li>
					<a href="javascript:void(0)" class="nav_1 nav_sh" name="first">商品管理</a>
					<div class="nav_layer" style="width: 150px;">
						<a href="Addcom.do" >添加商品</a>
						<a href="<%=path %>/straff/sum.jsp" >查看商品</a>
					</div>
				</li>
				<!-- 一个模块结束 -->
				
				<!-- 一个模块开始 -->
				<li>
					<a href="javascript:void(0)" class="nav_1 nav_sh" name="first">货物管理</a>
					<div class="nav_layer" style="width: 150px;">
						<a href="Purchose.do" >进货</a>
						<a href="Shipment.do" >出货</a>
					</div>
				</li>
				<li>
					<a href="javascript:void(0)" class="nav_1 nav_sh" name="first">个人中心</a>
					<div class="nav_layer" style="width: 150px;">
						<a href="servlet/chengeuser.jsp" >修改信息</a>
						<a href="servlet/chengepassword.jsp" >修改密码</a>
					</div>
				</li>
				<!-- 一个模块结束 -->
			</ul>
		</div>
		<iframe src="<%=path %>/straff/sum.jsp" frameborder="0" scrolling="yes" style="overflow:visible;width:100%;" name="main_ifrm" id="main_ifrm"></iframe>
		<script type="text/javascript" src="<%=path%>plugins/jQuery/jquery.js"></script>
		<script type="text/javascript" src="<%=path%>index/js/index.js"></script>
	</body>
</html>