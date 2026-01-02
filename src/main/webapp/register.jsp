<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<!--BootStrap设计的页面支持响应式的 -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<!--引入BootStrap的CSS-->
		<link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
		<!--引入JQuery的JS文件：JQuery的JS文件要在BootStrap的js的文件的前面引入-->
		<script type="text/javascript" src="js/jquery-1.11.3.min.js" ></script>
		<!--引入BootStrap的JS的文件-->
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<link rel="stylesheet" type="text/css" href=""/>
		<style type="text/css">
			#logo ul li{
				list-style:none ;
				float: left;
				padding: 5px 10px;
				line-height: 60px;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<!--logo-->
			<div class="row">
				<div class="col-md-4">
					<h3>外卖订单管理系统</h3>
				</div>
				<div class="col-md-4">
					<!--<img src="img/header.jpg"/>-->
				</div>
				<div class="col-md-4" id="logo">
					<ul>

					</ul>
				</div>
			</div>
<!--导航-->
			<div id="">
				<nav class="navbar navbar-inverse" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">首页</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav">
         
          </ul>
      </li>
    </ul>
	<form class="navbar-form navbar-right" role="search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
  </div><!-- /.navbar-collapse -->
</nav>


<!--页面主体-->
<div style="margin-top: 90px;" >
		<form class="form-horizontal" role="form" action="doregister" method="post">
<!-- 用户名 -->		
  <div class="form-group" style="margin-left: 200px;">
  
    <label for="inputEmail3" class="col-sm-2  control-label">用户名</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="inputEmail3"  name="uname" >
    </div>
    <label for="inputEmail3" class="col-sm-2 control-label">${sessionScope.register_info1}</label><br>
  </div>
  
<!-- 密码 -->
  <div class="form-group" style="margin-left: 200px">
   
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-5" >
      <input type="password" class="form-control" id="inputPassword3"   name="password" >
     
    </div>
     <label for="inputEmail3" class="col-sm-2 control-label">${sessionScope.register_info2}</label><br>
   
  </div>
  
  
<!-- 电话 --> 
  
    <div class="form-group" style="margin-left: 200px">
   
    <label for="inputPassword3" class="col-sm-2 control-label" >电话</label>
    <div class="col-sm-5" >
      <input type="text" class="form-control" id="inputPassword3"  name="tel" >
    </div>
    <label for="inputEmail3" class="col-sm-2 control-label">${sessionScope.register_info3}</label><br>
  </div>
  
  
<!-- 性别选择 -->   
  <div class="form-group" style="margin-left: 200px;">
    
    
  
    <label for="inputEmail3" class="col-sm-2 control-label">性别</label>
    <div class="col-sm-5">
        <select name="sex" class="form-control">
            <option value="男">男</option>
            <option value="女">女</option>
        </select>
    </div>
      </div>
      
      
<!--身份选择 -->            
  <div class="form-group" style="margin-left: 200px;">
   
    
  
    <label for="inputEmail3" class="col-sm-2 control-label">身份</label>
    <div class="col-sm-5">
        <select name="status" class="form-control">
            <option value="0">用户</option>
            <option value="1">商家</option>
        </select>
    </div>
      </div>
    

  <div class="form-group" style="margin-left: 200px;">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Register</button>
      <button type="reset" class="btn btn-default">Reset</button>
    </div>
  </div>
</form>
	</div>
<!--欢迎-->
	<div class="row" align="bottom" style="margin-top:200px ;">
		<div class="col-md-4">
		<h2>Welcome</h2>
		Welcom to itcast.Welcom to itcast.Welcom to itcast.Welcom to itcast.Welcom to itcast.
		<button type="button" class="btn btn-primary pull-right" >see more</button>
		</div>
		
		<div class="col-md-4">
		<h2>Welcome</h2>
		Welcom to itcast.Welcom to itcast.Welcom to itcast.Welcom to itcast.Welcom to itcast.
		<button type="button" class="btn btn-primary pull-right" >see more</button>
		</div>
		
		<div class="col-md-4">
		<h2>Welcome</h2>
		Welcom to itcast.Welcom to itcast.Welcom to itcast.Welcom to itcast.Welcom to itcast.
		<button type="button" class="btn btn-primary pull-right" >see more</button>
		</div>
	</div>

	
	</body>
</html>