<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%-- <%
	Calendar c = Calendar.getInstance(); 
	int year = c.get(Calendar.YEAR);
	int month = c.get(Calendar.MONTH) + 1;
	int day = c.get(Calendar.DATE);
%> --%>

<title>공동구매 추가 입력 폼</title>
</head>
<body>
	<spring:hasBindErrors name="item" />

	<form:form modelAttribute="item" method="post" action="step3">
	
	할인율: <form:input type="text" path="discount" value="${discount}"/>
	<form:errors path="discount"/> <br>
	
	판매가: <form:input type="text" path="listPrice" value="${listPrice}" />
	<form:errors path="listPrice"/> <br>
	
	<%-- 마감기한: <form:input type="date" path="deadLine.date"/>
	<input type="time" path="deadLine.time" value="23:59:59" min="00:00:01" max="23:59:59">
	<form:errors path="deadLine"/> <br> --%>
	
	<a href="step1">[이전 단계로]</a> <input type="submit" value="다음 단계로" />
	</form:form>
</body>
</html>