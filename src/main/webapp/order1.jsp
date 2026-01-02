<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@page import="com.hkd.pojo.Category"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<!--BootStrap设计的页面支持响应式的 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<!--引入BootStrap的CSS-->
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<!--引入JQuery的JS文件：JQuery的JS文件要在BootStrap的js的文件的前面引入-->
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<!--引入BootStrap的JS的文件-->
<script type="text/javascript" src="js/bootstrap.js"></script>
<style>
#logo ul li {
	list-style: none;
	float: left;
	padding: 5px 10px;
	/*margin-top: 15px;*/
	line-height: 60px;
}
</style>


</head>
<body>
	<div class="container">
		<!--logo-->
		<div id="logo" class="row">
			<div class="col-md-4">
				<h3>外卖订单管理系统</h3>
			</div>
			<div class="col-md-4">
				<!-- <img src="img/header.png" /> -->
			</div>
			<div class="col-md-4">
				<ul>
				
				
				<c:if test="${sessionScope.person.uname!=null }">
				
				<li>欢迎${sessionScope.person.uname}&nbsp;&nbsp;&nbsp; </li>
				
				
				</c:if>
				
				
				<c:if test="${sessionScope.person.uname==null }">
				
				<li><a href="login.jsp">登陆</a></li>
				
				</c:if>	
				</ul>
			</div>
		</div>
		<!--导航-->
		<div>
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					<a class="navbar-brand" href="towelcome2">首页</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav">
					
				
				<c:forEach items="${sessionScope.clist }" var="Category" varStatus="s">
				
				<c:if test="${s.count<=5 }">
				
				<li><a href="dodishes?Category=${Category.cid }&sign=${1}">${Category.name }</a></li>
				</c:if>
				
				</c:forEach>
					
	
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">功能 <b class="caret"></b></a>
							<ul class="dropdown-menu">
<!-- 商家功能 -->
				
								<li><a href="adddish.jsp">添加菜品</a></li>
								<li><a href="domember?member=''">查看会员</a></li>
								<li><a href="addmember.jsp">添加会员</a></li>		

							
							</ul></li>
							
							</ul></li>
					</ul>
<form class="navbar-form navbar-right" action="doorder" method="post">
							<div class="form-group">
							<select name="type" class="form-control">
							<option value="1">所有订单统计</option>
							<option value="2">未完成订单</option>
							<option value="3">按照日期统计</option>
							<option value="4">按照菜品统计</option>							
							</select> 
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>
		<!--body-->
		<div class="row" style="height: 300px; text-align: center;">
			<div class="col-md-10 col-md-push-1">
				<table class="table table-striped">
					<tr>
						<td>用户账号</td>
						<td>用户姓名</td>
						<td>订单号</td>
						<td>地址</td>
						<td>菜名</td>
						<td>单价</td>
						<td>数量</td>
						<td>金额</td>
						<td>下单日期</td>
						<td>状态</td>
					</tr>
					
				<c:forEach items="${sessionScope.ovlist }" var="o">
				    <tr>
						<td>${o.uid}</td>
						<td>${o.uname}</td>
						<td>${o.order_id}</td>
						<td>${o.address }</td>
						<td>${o.dish_name }</td>
						<td>${o.price }</td>
						<td>${o.num}</td>
						<td>${o.sum }</td>
						<td>${o.time }</td>
						<td>${o.status == '00' ? '未处理' : (o.status == '01' ? '已完成' : (o.status == '10' ? '拒收' : '未知状态'))}</td>
						
					</tr>
					
					
				</c:forEach>
				</table>
				<ul class="pagination">
				
				<c:if test="${sessionScope.pageno!=null }">
				
					<li><a href="doorder?flag=up">上一页</a></li>
					
					<li><a href="doorder?flag=down">下一页</a></li>
				</c:if>
					
				</ul>
			</div>
		</div>
		<!--版权部分--><br><br><br><br>
		<div>

			<div align="center">
				<a href="">关于我们</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="">联系我们</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="">招贤纳士</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="">法律声明</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#">友情链接</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="">支付方式</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="">配送方式</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="">服务声明</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="">广告声明</a>&nbsp;&nbsp;&nbsp;&nbsp; <br /> @ 2021 版权所有
				Copyright
			</div>
		</div>
	</div>
</body>
</html>