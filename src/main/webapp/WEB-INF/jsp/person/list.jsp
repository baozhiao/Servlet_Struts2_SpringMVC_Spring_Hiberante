<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>学生信息管理</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<script
	src="${pageContext.request.contextPath}/assets/js/echarts.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/amazeui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/amazeui.datatables.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/app.css">
<script
	src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>

</head>

<body data-type="widgets">
	<script
		src="${pageContext.request.contextPath}/assets/js/theme.js"></script>
	<div class="am-g tpl-g">
		<!-- 内容区域 -->
		<div class="row-content">
			<div class="row-content am-cf">
				<div class="row">
					<div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
						<div class="widget am-cf">
							<div class="widget-head am-cf">
								<div class="widget-title  am-cf">学生管理</div>
							</div>
							<div class="widget-body  am-fr">

								<div class="am-u-sm-12">
									<table width="100%"
										class="am-table am-table-compact am-table-striped tpl-table-black "
										id="example-r">
										<thead>
											<tr>
												<th>学号</th>
												<th>姓名</th>
												<th>密码</th>
												<th>手机</th>
												<th>地址</th>
												<th>宿舍</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="person" items="${pager.lists}">
												<tr class="gradeX">
													<td>${person.pid}</td>
													<td>${person.name}</td>
													<td>${person.password}</td>
													<td>${person.cellphone}</td>
													<td>${person.address}</td>
													<td>${person.dorm}</td>
													<td>
														<div class="tpl-table-black-operation">
															<a href="update?pid=${person.pid}"> <i class="am-icon-pencil"></i>
																编辑
															</a> <a href="delete?pid=${person.pid}"
																class="tpl-table-black-operation-del"> <i
																class="am-icon-trash"></i> 删除
															</a>
														</div>
													</td>
												</tr>
											</c:forEach>
											<!-- more data -->
										</tbody>
									</table>
								</div>
								<div class="am-u-lg-12 am-cf">

									<div class="am-fr">
										<ul class="am-pagination tpl-pagination">
											<li class="am-active"><a href="list?curPage=${pager.curPage-1}&pageCount=${pager.pageCount}">«</a></li>
											<c:forEach var="i" begin='1' end="5">
												<li class="am-active">
												<a href="list?curPage=${i}&pageCount=${pager.pageCount}">${i}</a></li>
											</c:forEach>
											<li><a href="list?curPage=${pager.curPage+1}&pageCount=${pager.pageCount}">»</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/amazeui.datatables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/dataTables.responsive.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>

</body>

</html>