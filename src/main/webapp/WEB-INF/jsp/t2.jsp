<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="ctx" scope="page" />
<c:set value="${pageContext.request.contextPath}/static" var="ctxStatic"
	scope="page" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
<title>测试</title>
<link href="${ctxStatic}/js/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${ctxStatic}/js/plugins/layer/theme/default/layer.css" rel="stylesheet">
<style type="text/css">
.item1 {
	font-size: 18px;
	text-indent: 2em;
}

.item2 {
	font-size: 16px;
	text-indent: 4em;
}

.item3 {
	font-size: 14px;
	text-indent: 6em;
}
</style>
<script src="${ctxStatic}/js/jquery-1.10.2/jquery.js"></script>
<script src="${ctxStatic}/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${ctxStatic}/js/common/Fb.js"></script>
<script src="${ctxStatic}/js/plugins/layer/layer.js"></script>
<script type="text/javascript">
	function submit() {
		var items1,
			items2,
			items3;
		var items1Array = [],
			items2Array = [],
			items3Array = [];
		$(".item1").each(function(i, e) {
			var item = {
				itemId : $(e).attr("data-id")
			};
			items1Array.push(item);
		});
		$(".item2").each(function(i, e) {
			var item = {
				itemId : $(e).attr("data-id")
			};
			items2Array.push(item);
		});
		$(".item3").each(function(i, e) {
			var item = {
				itemId : $(e).attr("data-id")
			};
			items3Array.push(item);
		});
		items1 = JSON.stringify(items1Array);
		items2 = JSON.stringify(items2Array);
		items3 = JSON.stringify(items3Array);
		$.ajax({
			url : "${ctx}/result/save",
			data : {items1: items1, items2: items2, items3: items3},
			type : "post",
			dataType : "json",
			success : function(data) {
				if (data.success == false) {
					Fb.error(data.errorMsg);
					return;
				}
				Fb.success("提交成功");
			}
		});
	}
</script>
</head>
<body>
	<div>t2.jsp</div>
	<div>
		<c:forEach items="${list }" var="item1">
			<div class="item1" data-id="${item1.id}">
				${item1.name }
				<c:forEach items="${item1.items }" var="item2">
					<div class="item2" data-id="${item2.id}">${item2.name }
						<c:forEach items="${item2.items }" var="item3">
							<div class="item3" data-id="${item3.id}">${item3.name }</div>
						</c:forEach>
					</div>
				</c:forEach>
			</div>
		</c:forEach>
	</div>
	<div>
		<input type="button" value="提&nbsp;交" onclick="submit()">
	</div>
</body>
<script type="text/javascript">
</script>
</html>
