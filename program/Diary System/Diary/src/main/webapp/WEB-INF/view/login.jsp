<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=path%>/static/js/login.js"></script>
<link rel="stylesheet" href="<%=path%>/static/layui/css/layui.css">
<script src="<%=path%>/static/layui/layui.js"></script>
<script src="<%=path%>/static/js/jquery-1.8.0.min.js"></script>
<script src="<%=path%>/static/js/login.js"></script>
<title>Diary|日志</title>
</head>
<body>
	<div style="width: 500px; margin: 200px auto;">
	<h1 style="margin-left:130px;font-weight: bolder;">用户登录</h1><br />
		<form class="layui-form" action="<%=path%>/user/goIndex" method="post" onsubmit="return LogIn()">
			<div class="layui-form-item">
				<label class="layui-form-label">账&nbsp;&nbsp;号</label>
				<div class="layui-input-inline">
					<input type="text" id="userid" name="userid"
						placeholder="请输入账号" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密码框</label>
				<div class="layui-input-inline">
					<input type="password" id="password" name="password"
						placeholder="请输入密码" autocomplete="off" class="layui-input"
						style="display: inline-block;">


				</div>

				

			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">验证码</label>
				<div class="layui-input-inline">
					<input type="text" id="code" name="code"
						placeholder="请输入验证码" autocomplete="off" class="layui-input"
						style="display: inline-block;">


				</div>

				<div class="layui-input-inline" style="width: 100px;">
					<img id="vertifycode" name="vertifycode" onClick="myReload()" alt="验证码,看不清楚?请点击刷新验证码"
						src="/Diary/authImage" width="80%" height="36spx" />


				</div>

			</div>
<div class="layui-form-item">
			<div class="layui-input-block" style="margin-left: 120px;">
				<button class="layui-btn" id="login_btn" lay-filter="formDemo"
					onclick="LogIn()">登录</button>

				
				<a href="<%=path%>/user/register" id="submit" ><div id="register" class="layui-btn" >注册</div></a>
			</div>
		</div>
		</form>
		
	</div>
	<script>
		layui.use('form', function() {
			var form = layui.form;
			var layer = layui.layer;
			/* //监听提交
			form.on('submit(formDemo)', function(data){
			  layer.msg(JSON.stringify(data.field));
			  return false;
			}); */
			form.render();
		});

		if (top.location != location) {
			top.location.href = location.href;
		}
		
		 $(function(){
			 layui.use('form', function() {
					var form = layui.form;
					var layer = layui.layer;
					 <c:if test="${not empty param.timeout}">
				      layer.msg('连接超时,请重新登陆!', {
				        offset: 0,
				        shift: 6
				      });
				    </c:if>
					if ("${message}") {
						layer.alert('${message}', {
							offset : 'auto'
						});
					}
					if ("${error}") {
						layer.alert('${error}', {
							offset : 'auto'
							
						});
					}
					/* //监听提交
					form.on('submit(formDemo)', function(data){
					  layer.msg(JSON.stringify(data.field));
					  return false;
					}); */
					form.render();
				});
			 
			 
			 
			   

			   
			    $('.close').on('click', function(c){
			      $('.login-form').fadeOut('slow', function(c){
			        $('.login-form').remove();
			      });
			    });

			    $('#username,#password').change(function(){
			      $('#submit').attr('value','登陆');
			    });
			  });

		 
		 
		
	</script>
</body>
</html>