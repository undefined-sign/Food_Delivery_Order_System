<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext" %>
<%@page import="com.hkd.service.DishServiceImp"%>
<%@page import="com.hkd.service.CategoryServiceImp"%>
<%@page import="com.hkd.pojo.Category" %>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--BootStrap设计的页面支持响应式的 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<!--引入BootStrap的CSS-->
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<!--引入JQuery的JS文件：JQuery的JS文件要在BootStrap的js的文件的前面引入-->
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<!--引入BootStrap的JS的文件-->
<script type="text/javascript" src="js/bootstrap.js"></script>
<style type="text/css">
#logo ul li {
	list-style: none;
	float: left;
	padding: 5px 10px;
	line-height: 60px;
}
</style>
</head>
<body>

<%--提供菜品类别信息，并存储在session中 --%>

<%
    // 只初始化一次
    ApplicationContext context =
        new org.springframework.context.support.ClassPathXmlApplicationContext("application_context.xml");
    CategoryServiceImp categoryService =(CategoryServiceImp) context.getBean(CategoryServiceImp.class);
    ArrayList<Category> clist = categoryService.getAllCategories();
    session.setAttribute("clist", clist);
%>

	<div class="container">
		<!--logo-->
		<div class="row">
			<div class="col-md-4">
				<h3>外卖订单管理系统</h3>
			</div>
			<div class="col-md-4">
				<!-- <img src="img/header.png" /> -->
			</div>
			<div class="col-md-4" id="logo">
				<ul>
				
				
				<c:if test="${sessionScope.person.uname!=null }">
				
				<li>欢迎${sessionScope.person.uname}&nbsp;&nbsp;&nbsp;<a href="doinvalidate">注销</a> </li>
				
				
				</c:if>
				
				
				<c:if test="${sessionScope.person.uname==null }">
				
				<li><a href="login.jsp">登陆</a></li>
				
				</c:if>				

					<li><a href="car.jsp">购物车</a></li>
					<li><a href="orderheader?order_header=${'11'}">订单</a></li>
				</ul>
			</div>
		</div>

		<div id="">
			<nav class="navbar navbar-inverse" role="navigation">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">首页</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav">
					
<%--导航栏 --%>				
				<c:forEach items="${sessionScope.clist }" var="Category" varStatus="s">
				
				<c:if test="${s.count<=5 }">
				
				<li><a href="dodishes?Category=${Category.cid }&sign=${0 }">${Category.name }</a></li>
				</c:if>
				
				</c:forEach>
					
	
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">其他 <b class="caret"></b></a>
							<ul class="dropdown-menu">
							
							
							
					<c:forEach items="${sessionScope.clist }" var="Category" varStatus="s">
				
				<c:if test="${s.count>5 }">
				
				<li><a href="dodishes?Category=${Category.cid }">${Category.name }</a></li>
				</c:if>
				
				</c:forEach>
				
				
							
							</ul></li>
					</ul>
					
<%--搜索框 --%>
						<form class="navbar-form navbar-right" action="dosearch" method="post">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search" name="search">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>
				</div>
				<!-- /.navbar-collapse -->
			</nav>
		</div>
<!--页面主体-->
		<div class="row">
<!--类别列表-->
			<div class="col-md-4">
				<ul class="nav nav-pills nav-stacked">
				<c:forEach items="${sessionScope.clist }" var="Category" varStatus="s">
				
				<c:if test="${s.count<=5 }">
				
				<li><a href="dodishes?Category=${Category.cid }&sign=${0}">${Category.name }</a></li>
				</c:if>
				
				</c:forEach>
				
				
				</ul> 
			</div>
<!--轮播图-->
			<div class="col-md-8">
				<div id="">
					<div id="carousel-example-generic" class="carousel slide">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>
						<!-- Wrapper for slides -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="img/food1.jpg" alt="...">
								<div class="carousel-caption">第一张图片</div>
							</div>
							<div class="item ">
								<img src="img/food2.jpg" alt="...">
								<div class="carousel-caption">第二张图片</div>
							</div>
							<div class="item">
								<img src="img/food3.jpg" alt="...">
								<div class="carousel-caption">第三张图片</div>
							</div>
						</div>
						<!-- Controls -->
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>
			</div>
		</div>
<!--版权部分-->
<br><br>
		<div >
		
	
			<div>
				<!--友情链接-->
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
	</div>
</body>
</html>