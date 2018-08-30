<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户注册</title>
<link rel="stylesheet" href="<%=path%>/static/layui/css/layui.css">
<script src="<%=path%>/static/layui/layui.js"></script>
<script src="<%=path%>/static/js/jquery-1.8.0.min.js"></script>
<script src="<%=path%>/static/js/register.js"></script>

</head>
<body>
	<div style="width: 500px; margin: 200px auto;">
		<h1 style="margin-left: 130px; font-weight: bolder;">用户注册</h1>
		<br />
		<form class="layui-form" action="<%=path%>/user/goRegister"
			method="post" onsubmit="return register()">
			<div class="layui-form-item">
				<label class="layui-form-label">账号</label>
				<div class="layui-input-inline">
					<input type="text" id="userid" name="userid"
						placeholder="请输入账号" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-inline">
					<input type="password" id="password" name="password"
						placeholder="请输入密码" autocomplete="off" class="layui-input"
						style="display: inline-block;">


				</div>



			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">确认密码</label>
				<div class="layui-input-inline">
					<input type="text" id="checkPassword" name="checkPassword"
						placeholder="请确认密码" autocomplete="off" class="layui-input"
						style="display: inline-block;">


				</div>



			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">昵称</label>
				<div class="layui-input-inline">
					<input type="text" id="nickname" name="nickname"
						placeholder="请确认游戏昵称" autocomplete="off" class="layui-input"
						style="display: inline-block;">


				</div>



			</div>
			<div class="layui-form-item">
				<div class="layui-input-block" style="margin-left: 120px;">

					<button id="register_btn" class="layui-btn" onclick="register()"
						style="font-size: 20px; padding: 0 30px;">注册</button>
				</div>
			</div>
		</form>

	</div>
	<script>
	layui.use('form', function() {
		var form = layui.form;
		var layer = layui.layer;
		
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
	
	
		

		if (top.location != location) {
			top.location.href = location.href;
		}
	</script>
</body>
</html>