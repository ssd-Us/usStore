<%@ include file="itemTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<spring:hasBindErrors name="GroupBuying" />

	<form:form modelAttribute="GroupBuying" method="post" action="step3?productId=${productId}">
	
	<%-- 할인율: <form:input type="text" path="discount" value="${discount}"/>
	<form:errors path="discount"/> <br> 
	컨트롤러에서 할인율 계산하여 자동으로 세션에 추가하도록!--%>
	
	판매가: <form:input type="text" path="listPrice" value="${listPrice}" />
	<form:errors path="listPrice"/> <br>
	
	마감기한: <form:input type="date" path="deadLine.date"/>
	<input type="time" path="deadLine.time" value="23:59:59" min="00:00:01" max="23:59:59">
	<form:errors path="deadLine"/> <br>
	
	<a href="<c:url value='/shop/groupBuying/gobackItem.do'>
		         <c:param name="productId" value="${productId}"/>
		     </c:url>
		">[이전 단계로]</a> <input type="submit" value="다음 단계로" />
	</form:form>
</body>
</html>