<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="ctxPath" scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>测试</title>
<link href="${ctxPath}/static/js/plugins/layer/theme/default/layer.css"
	rel="stylesheet">
<style type="text/css">
.d1 {
	border: 1px solid #dedede;
	height: 100px;
	background: #dedede;
}

.d2 {
	height: 100px;
	border: 1px solid #715f5f;
	background: #715f5f
}
</style>
<script src="${ctxPath}/static/js/jquery-1.10.2/jquery.js"></script>
<script src="${ctxPath}/static/js/common/Fb.js"></script>
<script src="${ctxPath}/static/js/plugins/layer/layer.js"></script>
<script type="text/javascript">

	function f1() {
	}

	function f2() {
		location.href = "t2";
	}

	function f3() {
		location.href = "t3";
	}

	function f4() {
		$.ajax({
			url : "t4",
			type : "post",
			data : {
				//a : i1
			},
			beforeSend: function(request) {                
               request.setRequestHeader("Authorization", localStorage.token);
   			},
			dataType : "json",
			//contentType : "application/json;charset=utf-8",
			success : function(msg) {
				if (msg.success == false) {
					Fb.error(msg.errorMsg);
					return;
				}
				Fb.success("提交成功");
			//console.info(msg.b);
			}
		});
	}
</script>
</head>
<body>
	<div>t1.jsp</div>
	<div>
		<input value="f4()" type="button" onclick="f4()">
	</div>

</body>
<script type="text/javascript">
	$(function() {
	});
</script>
</html>
