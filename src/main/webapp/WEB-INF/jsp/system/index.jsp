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
		<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/i/favicon.png">
		<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
		<meta name="apple-mobile-web-app-title" content="Amaze UI" />
		<script src="${pageContext.request.contextPath}/assets/js/echarts.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.datatables.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/app.css">
		<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>

	</head>

	<body data-type="index">
		<script src="${pageContext.request.contextPath}/assets/js/theme.js"></script>
		<div class="am-g tpl-g">
			<!-- 头部 -->
			<header>
				<!-- logo -->
				<div class="am-fl tpl-header-logo">
					<a href="javascript:;"><img src="${pageContext.request.contextPath}/assets/img/logo.png" alt=""></a>
				</div>
				<!-- 右侧内容 -->
				<div class="tpl-header-fluid">
					<div class="am-fr tpl-header-navbar">
						<ul>
							<!-- 欢迎语 -->
							<li class="am-text-sm tpl-header-navbar-welcome">
								<a href="javascript:;">后台模版，由AmazeUI修改而成。欢迎你, <span>Amaze UI</span> </a>
							</li>
							<!-- 退出 -->
							<li class="am-text-sm">
								<a href="logout">
									<span class="am-icon-sign-out"></span> 退出
								</a>
							</li>
						</ul>
					</div>
				</div>

			</header>
			<!-- 侧边导航栏 -->
			<div class="left-sidebar">
				<!-- 用户信息 -->
				<div class="tpl-sidebar-user-panel">
					<div class="tpl-user-panel-slide-toggleable">
						<div class="tpl-user-panel-profile-picture">
							<img src="${pageContext.request.contextPath}/assets/img/user04.png" alt="">
						</div>
						<span class="user-panel-logged-in-text">
				              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
				            ${loginUser.name}
				         </span>
					</div>
				</div>

				<!-- 菜单 -->
				<ul class="sidebar-nav">
					<li class="sidebar-nav-link">
						<a href="index" class="active">
							<i class="am-icon-home sidebar-nav-link-logo"></i> 首页
						</a>
					</li>
					
					<li class="sidebar-nav-link">
						<a href="javascript:;" class="sidebar-nav-sub-title">
							<i class="am-icon-table sidebar-nav-link-logo"></i> 学生管理
							<span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
						</a>
						<ul class="sidebar-nav sidebar-nav-sub">
							<li class="sidebar-nav-link">
								<a href="std/list" target="myiframe">
									<i class="am-icon-table sidebar-nav-link-logo"></i> 学生列表
								</a>
							</li>
							<li class="sidebar-nav-link">
								<a href="std/add" target="myiframe">
									<i class="am-icon-wpforms sidebar-nav-link-logo"></i> 增加学生
								</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>

			<!-- 内容区域 -->
			<div class="row-content" style="margin-left: 240px;">
				<iframe id="myiframe" name="myiframe" src="${pageContext.request.contextPath}/HelloWorld.jsp" onload="iFrameHeight()" marginheight="0" marginwidth="0" frameborder="0" scrolling="no" width="100%" height=100%></iframe>
			</div>
			<script type="text/javascript">
				function iFrameHeight() {
					var ifm = document.getElementById("myiframe");
					var subWeb = document.frames ? document.frames["myiframe"].document : ifm.contentDocument;
					if(ifm != null && subWeb != null) {
						ifm.height = subWeb.body.scrollHeight;
					}
				}
			</script>
		</div>

		<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/amazeui.datatables.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/dataTables.responsive.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>

	</body>

</html>