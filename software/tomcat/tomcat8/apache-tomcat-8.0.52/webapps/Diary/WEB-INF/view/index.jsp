<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Diary | 日志</title>
<meta http-equiv="Expires" content="0">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-control" content="no-cache">
<meta http-equiv="Cache" content="no-cache">
<jsp:include page="include/commonfile.jsp" />
<script src="${ctx}/static/js/util.js"></script>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	<div class="am-cf admin-main">
		<jsp:include page="include/sidebar.jsp" />

		<!-- content start -->
		<div class="admin-content">
			<div class="" style="width: 80%; float: left;">
				<!-- 日志区 -->
				<div id="hidden_field_id" style="display:none;" hidden="hidden"></div>
				<div class="am-scrollable-vertical" id="diary-view"
					style="height: 510px;">

					<textarea class="" id="message" name="message"
						style="width: 100%; height: 100%" placeholder="这里输入你的进度,一天只能生成一条日志，会自动覆盖..."></textarea>

				</div>
				<!-- 问题区 -->
				<div class="am-form-group am-form">
					<textarea class="" id="problem" name="message" rows="5"
						placeholder="这里输入存在的问题..."></textarea>
				</div>

				<!-- 按钮区 -->
				<div class="am-btn-group am-btn-group-xs" style="float: right;">
					<button class="am-btn am-btn-primary am-radius" type="button"
						onclick="clearConsole()" style="margin-right: 10px;">
						<span class="am-icon-trash-o"></span> 清空
					</button>
					<button class="am-btn am-btn-primary am-radius" type="button"
						onclick="sendMessage()">
						<span class="am-icon-commenting"></span> 提交
					</button>
				</div>
			</div>
			<!-- 列表区 -->
			<div class="am-panel am-panel-default"
				style="float: right; width: 20%;">
				<div class="am-panel-hd">
					<h3 class="am-panel-title">
						提交列表 [<span id="listnum">${count }</span>]
					</h3>
				</div>

				<div class="am-tabs am-margin">
					<table class="am-table am-table-striped"
						style="table-layout: fixed;">
						<thead>
							<tr>
								<th width="20">#</th>
								<th width="100">时间</th>
								<th width="100">内容</th>
								<th width="100" hidden>问题</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="records" varStatus="status">
								<tr class="table_tr" id="hello">
									<td  class="text_id" abbr="${records.id}">${status.index + 1}</td>
									<td
										style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap">${records.writetime}</td>
									<td class="message"
										style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap">${records.remark}</td>
									<td class="problem" hidden
										style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap">${records.troublemeet}</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- content end -->
		</div>
		<a href="#" class="am-show-sm-only admin-menu"
			data-am-offcanvas="{target: '#admin-offcanvas'}"> <span
			class="am-icon-btn am-icon-th-list"></span>
		</a>
		<jsp:include page="include/footer.jsp" />
		<script src="${ctx}/static/js/util.js"></script>
		<script>
			$(function() {
				$(".table_tr").click(function(e) {
					var message = $(this).children(".message").text();
					var problem = $(this).children(".problem").text();
					var text_id = $(this).children(".text_id").attr("abbr");
					
					$("#message").val(message);
					$("#problem").val(problem);
					$("#hidden_field_id").html(text_id);
				});
			});

			function getEventTrigger(event) {
				x = event.target;
				alert("The id of the triggered element: " + x.id);
			}

			/* 自定义右键菜单 */
			$(function() {
				context.init({
					preventDoubleContext : false
				});
				context.settings({
					compress : true
				});
				context.attach('#diary-view', [ {
					header : '操作菜单',
				}, {
					text : '清空',
					action : clearConsole
				},
				/* {text: '提交', action: clearConsole}, */
				{
					divider : true
				},
				/*  {
				     text: '选项', subMenu: [
				     {header: '连接选项'},
				     {text: '检查', action: checkConnection},
				     {text: '连接', action: getConnection},
				     {text: '断开', action: closeConnection}
				 ]
				 }, */
				
				]);
			});
			if ("${message}") {
				layer.msg('${message}', {
					offset : 0
				});
			}
			if ("${error}") {
				layer.msg('${error}', {
					offset : 0,
					shift : 6
				});
			}

			

			/**
			 * 提交给后台
			 */
			function sendMessage() {
				var id = $("#hidden_field_id").text();
				var message = $("#message").val();
				var problem = $("#problem").val();

				/* if (message == null || message == "") {
					layer.msg("请输入进度，如果没有请填写理由!", {
						offset : 0,
						shift : 6
					});
					return;
				} */
				_ajax("/Diary/records/saveDiary", {
					message : message,
					problem : problem,
					id:id
				}, function() {
					layer.open({
						content : '保存成功',
						btn : [ '确定' ],
						yes : function(index, layero) {
							//按钮【按钮一】的回调
							document.location.reload();
						},
						cancel : function() {
							//右上角关闭回调
							document.location.reload();
							//return false 开启该代码可禁止点击该按钮关闭
						}
					});
					/* layer.alert("保存成功!", { offset: 'auto'}); */

				})

			}

			/**
			 * 清空
			 */
			function clearConsole() {
				$("#message").val("");
				$("#problem").val("");
			}

			function appendZero(s) {
				return ("00" + s).substr((s + "").length);
			} //补0函数

			function getDateFull() {
				var date = new Date();
				var currentdate = date.getFullYear() + "-"
						+ appendZero(date.getMonth() + 1) + "-"
						+ appendZero(date.getDate()) + " "
						+ appendZero(date.getHours()) + ":"
						+ appendZero(date.getMinutes()) + ":"
						+ appendZero(date.getSeconds());
				return currentdate;
			}
		</script>
</body>
</html>