<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<c:set value="${pageContext.request.contextPath}" var="ctxPath"
	scope="page" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no" />
<meta name="MobileOptimized" content="320" />
<script src="${ctxPath }/js/jquery-1.8.3.min.js"></script>
<title>错误页面</title>
<style type="text/css">
	body {
		text-align: center;
	}
</style>
</head>

<body>
	<div>
		<h3>错误信息</h3>
	</div>
	<div>
		<h4>${errorMsg }</h4>
	</div>
</body>
</html>
