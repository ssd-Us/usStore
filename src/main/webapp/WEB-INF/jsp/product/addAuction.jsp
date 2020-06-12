<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경매 입력 폼</title>
</head>
<body>
	<spring:hasBindErrors name="item" />
	<form:form modelAttribute="auction" method="post" action="step3/${item.productId}">
	
	시작 가격: <form:input type="text" path="startPrice" value="${startPrice}"/>
	<form:errors path="startPrice"/> <br>
	
<%-- 	마감일: <form:input type="text" path="unitCost"  value="${unitCost}"/>
	<form:errors path="unitCost"/> <br> --%>
	
	<a href="step1">[이전 단계로]</a> <input type="submit" value="다음 단계로" />
	</form:form>
</body>
</html>