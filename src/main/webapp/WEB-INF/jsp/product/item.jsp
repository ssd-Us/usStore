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
	<form:form modelAttribute="item" method="post" action="/shop/item/addItem2/${productId}">
	
	제목: <form:input type="text" path="title" value="${title}"/>
	<form:errors path="title"/> <br><br>
	
	내용: <form:textarea path="description" value="${description}" />
	<form:errors path="description"/> <br><br>
	
	정가: <form:input type="text" path="unitCost"  value="${unitCost}"/>
	<form:errors path="unitCost"/> <br><br>
	
	수량: <form:input type="text" path="qty" value="${qty}"/>
	<form:errors path="qty"/> <br><br>
	
	태그: 
	<form:input path="tag1" value="${tag1}"/>
	<form:errors path="tag1"/>&nbsp;
	<form:input path="tag2" value="${tag2}"/>
	<form:errors path="tag2"/>&nbsp;
	<form:input path="tag3" value="${tag3}"/>
	<form:errors path="tag3"/>&nbsp;
	<form:input path="tag4" value="${tag4}"/>
	<form:errors path="tag4"/>&nbsp;
	<form:input path="tag5" value="${tag5}"/>
	<form:errors path="tag5"/> <br>
	
	<input type="submit" value="다음 단계로" />
	
	</form:form>
</body>
</html>