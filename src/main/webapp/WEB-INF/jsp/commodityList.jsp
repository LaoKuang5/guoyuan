<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品列表展示</title>
</head>
<body>
	其他信息
	当前页：${commodtiypageInfo.pageNum }<br/>
	总页数${commodtiypageInfo.pages }<br/>
	总记录数：${commodtiypageInfo.total }<br/>
	<hr/>
	<c:forEach items="${commodtiypageInfo.list}" var="commodity">
		商品名称：${commodity.commodityName } <br/>
		商品价格：${commodity.commodityPrice } <br/>
		商品生成天数：${commodity.commodityTerm } <br/>
		果苗产量：${commodity.commodityProduct } <br/>
		商品状态 ：<c:if test="${commodity.commodityStatus ==1 }">在售</c:if>
				<c:if test="${commodity.commodityStatus ==2 }">售完</c:if>
				<c:if test="${commodity.commodityStatus ==3 }">下架</c:if><br/>
		商品主图：
		<img alt="商品主图"  src="/pic/${commodity.commodityMainPho }">
		<a href="#">查看商品</a>
		<hr/>
	</c:forEach>
    <c:if test="${commodtiypageInfo.hasPreviousPage }">
         <a href="${pageContext.request.contextPath }/commodity/list.action?pageNum=${commodtiypageInfo.prePage}">上一页</a>
    </c:if>
      
    <c:if test="${commodtiypageInfo.hasNextPage }">
         <a href="${pageContext.request.contextPath }/commodity/list.action?pageNum=${commodtiypageInfo.nextPage}">下一页</a>
    </c:if>
        
           
</body>
</html>