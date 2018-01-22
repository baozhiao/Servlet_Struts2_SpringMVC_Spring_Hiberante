<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
								<div class="widget-title am-fl">学生信息</div>
								<div class="widget-function am-fr">
									<a href="javascript:;" class="am-icon-cog"></a>
								</div>
							</div>
							<div class="widget-body am-fr">

								<form class="am-form tpl-form-border-form tpl-form-border-br"
									method="post" action="update">
									<div class="am-form-group">
										<label for="pid" class="am-u-sm-3 am-form-label">学号 <span
											class="tpl-form-line-small-title">pid</span>
										</label>
										<div class="am-u-sm-9">
											<input type="text"  readonly="readonly" class="tpl-form-input" id="pid" name="person.pid"
												placeholder="请输入学号" value="${person.pid}">
										</div>
									</div>

									<div class="am-form-group">
										<label for="name" class="am-u-sm-3 am-form-label">姓名 <span
											class="tpl-form-line-small-title">name</span>
										</label>
										<div class="am-u-sm-9">
											<input type="text" class="tpl-form-input" id="name"
												name="person.name" placeholder="请输入姓名" value="${person.name}">
										</div>
									</div>
									<div class="am-form-group">
										<label for="password" class="am-u-sm-3 am-form-label">密码
											<span class="tpl-form-line-small-title">password</span>
										</label>
										<div class="am-u-sm-9">
											<input type="text" class="tpl-form-input" id="password"
												name="person.password" placeholder="请输入密码" value="${person.password}">
										</div>
									</div>
									<div class="am-form-group">
										<label for="cellphone" class="am-u-sm-3 am-form-label">手机
											<span class="tpl-form-line-small-title">cellphone</span>
										</label>
										<div class="am-u-sm-9">
											<input type="text" class="tpl-form-input" id="cellphone"
												name="person.cellphone" placeholder="请输入手机" value="${person.cellphone}">
										</div>
									</div>

									<div class="am-form-group">
										<label for="address" class="am-u-sm-3 am-form-label">地址
											<span class="tpl-form-line-small-title">address</span>
										</label>
										<div class="am-u-sm-9">
											<input type="text" class="tpl-form-input" id="address"
												name="person.address" placeholder="请输入地址" value="${person.address}">
										</div>
									</div>

									<div class="am-form-group">
										<label for="dorm" class="am-u-sm-3 am-form-label">宿舍 <span
											class="tpl-form-line-small-title">dorm</span>
										</label>
										<div class="am-u-sm-9">
											<input type="text" class="tpl-form-input" id="dorm"
												name="person.dorm" placeholder="请输入宿舍" value="${person.dorm}">
										</div>
									</div>
									<div class="am-form-group">
										<label for="job" class="am-u-sm-3 am-form-label">职位 <span
											class="tpl-form-line-small-title">job</span>
										</label>
										<div class="am-u-sm-9">
											<input type="text" class="tpl-form-input" id="job" name="person.job"
												placeholder="请输入职位" value="${person.job}">
										</div>
									</div>
									<div class="am-form-group">
										<label for="remarks" class="am-u-sm-3 am-form-label">备注
											<span class="tpl-form-line-small-title">remarks</span>
										</label>
										<div class="am-u-sm-9">
											<input type="text" class="tpl-form-input" id="remarks"
												name="person.remarks" placeholder="请输入备注" value="${person.remarks}">
										</div>
									</div>
									<div class="am-form-group">
										<label for="relationship" class="am-u-sm-3 am-form-label">联系人
											<span class="tpl-form-line-small-title">relationship</span>
										</label>
										<div class="am-u-sm-9">
											<input type="text" class="tpl-form-input" id="relationship"
												name="person.relationship" placeholder="请输入联系人" value="${person.relationship}">
										</div>
									</div>
									<div class="am-form-group">
										<label for="relationshipPhone" class="am-u-sm-3 am-form-label">联系人电话
											<span class="tpl-form-line-small-title">relationshipPhone</span>
										</label>
										<div class="am-u-sm-9">
											<input type="text" class="tpl-form-input"
												id="relationshipPhone" name="person.relationshipPhone"
												placeholder="请输入联系人电话" value="${person.relationshipPhone}">
										</div>
									</div>
									<div class="am-form-group">
										<div class="am-u-sm-9 am-u-sm-push-3">
											<button type="submit"
												class="am-btn am-btn-primary tpl-btn-bg-color-success ">提交</button>
										</div>
									</div>
								</form>
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