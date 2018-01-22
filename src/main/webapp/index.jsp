<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
<style type="text/css">
li {
	list-style: none;
}

lu {
	margin: 0 auto;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<h2>三种方式实现增删改查功能，登录，退出，拦截器等功能</h2>
	<h3>使用AOP技术实现对Service层的方法调用，进行日志记录</h3>
	<ul>
		<li><a href="struts2/login">strut2_登录</a></li>
		<li>这链接使用的Struts2+Spring+Hiberante实现</li>
		<li>登录页面：/struts2/login</li>
		<li>退出页面：/struts2/logout</li>
		<li>主页页面：/struts2/index</li>
		<li>增加页面：/struts2/std/add</li>
		<li>增加功能：/struts2/std/add 提交方法：post</li>
		<li>修改页面：/struts2/std/update?pid=xxxx</li>
		<li>修改功能：/struts2/std/update 提交方法：post</li>
		<li>删除功能：/struts2/std/delete?pid=xxx</li>
		<li>查询页面：/struts2/std/list?curPage=1&pageCount=5 curPage当前页
			pageCount行数</li>
		<li><a href="servlet/login">Servlet_登录</a></li>
		<li>这链接使用的Servlet+Spring+Hiberante实现</li>
		<li>登录页面：/servlet/login</li>
		<li>退出页面：/servlet/logout</li>
		<li>主页页面：/servlet/index</li>
		<li>增加页面：/servlet/std/add</li>
		<li>增加功能：/servlet/std/add 提交方法：post</li>
		<li>修改页面：/servlet/std/update?pid=xxxx</li>
		<li>修改功能：/servlet/std/update 提交方法：post</li>
		<li>删除功能：/servlet/std/delete?pid=xxx</li>
		<li>查询页面：/servlet/std/list?curPage=1&pageCount=5 curPage当前页
			pageCount行数</li>
		<li><a href="springmvc/login">SpringMvc_登录</a></li>
		<li>这链接使用的SpringMVC+Spring+Hiberante实现</li>
		<li>登录页面：/springmvc/login</li>
		<li>退出页面：/springmvc/logout</li>
		<li>主页页面：/springmvc/index</li>
		<li>增加页面：/springmvc/std/add</li>
		<li>增加功能：/springmvc/std/add 提交方法：post</li>
		<li>修改页面：/springmvc/std/update?pid=xxxx</li>
		<li>修改功能：/springmvc/std/update 提交方法：post</li>
		<li>删除功能：/springmvc/std/delete?pid=xxx</li>
		<li>查询页面：/springmvc/std/list?curPage=1&pageCount=5 curPage当前页
			pageCount行数</li>
	</ul>


</body>
</html>
