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
<script>
	if(${error} == 1){
	    alert("文件上传失败，请重试");
	}
</script>

<div class="am-g tpl-g">
	<!-- 内容区域 -->
	<div class="row-content">


		<div class="row-content am-cf">
			<div class="row">
				<div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
					<div class="widget am-cf">
						<div class="widget-head am-cf">
							<div class="widget-title am-fl">上传作业</div>
							<div class="widget-function am-fr">
								<a href="javascript:;" class="am-icon-cog"></a>
							</div>
						</div>
						<div class="widget-body am-fr">

							<form class="am-form tpl-form-border-form tpl-form-border-br"
								  method="post" action="/springmvc/file/upFile" enctype="multipart/form-data">

								<input type="file" name="file" />

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