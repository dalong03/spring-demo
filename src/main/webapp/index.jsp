<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="ctxPath"
	scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${ctxPath }/static/css/admin.css" rel="stylesheet"></link>
<title>首页</title>
<style type="text/css">
</style>
<script src="${ctxPath}/static/js/jquery-1.10.2/jquery.js"></script>
<script type="text/javascript">
	//location.href = "${path }/t1";
</script>
</head>
<body>
<div class="admin">
	<jsp:include page="./common/side.jsp"></jsp:include>
	<jsp:include page="./common/body.jsp"></jsp:include>
</div>
</body>
<script type="text/javascript">
	$(function(){
		$(".side").find("a").each(function(i, e){
			$(e).click(function(){
				var me = $(this);
				var src = "${ctxPath }" + me.attr("data-href");
				var body = $(".body");
				body.empty();
				body.append('<iframe src="' + src + '"></iframe>');
			});
		});
	});
</script>
</html>

