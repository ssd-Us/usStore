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
<title>상품 입력 폼</title>
</head>
<body>
	<spring:hasBindErrors name="item" />
	<form:form modelAttribute="item" method="post" action="step2/${item.productId}">
	
	제목: <form:input type="text" path="title" value="${title}"/>
	<form:errors path="title"/> <br>
	
	내용: <form:textarea path="description" value="${description}" />
	<form:errors path="description"/> <br>
	
	정가: <form:input type="text" path="unitCost"  value="${unitCost}"/>
	<form:errors path="unitCost"/> <br>
	
	수량: <form:input type="text" path="qty" value="${qty}"/>
	<form:errors path="qty"/> <br>
	
	태그: <form:textarea path="tag" value="${tag}"/>
	<form:errors path="tag"/> <br>
	
	<input type="submit" value="다음 단계로" />
	
	</form:form>
</body>
</html>