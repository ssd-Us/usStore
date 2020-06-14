<%@ include file="itemTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<title>ìí ìë ¥ í¼</title>
</head>
<style>
	div #addHandMadeForm {
		position: absolute;
		left: 18%;
		border: none;
		padding: 20px;
	}
</style>
<body>
<div id="addHandMadeForm">
<h2>ADD HandMade</h2><hr><br><br>
	<spring:hasBindErrors name="HandMade" />
    <form:form modelAttribute="HandMade" method="post" action="step3">
	   판매가: <form:input type="text" path="listPrice" value="${listPrice}"/>
	   <form:errors path="listPrice"/> <br>
	   
	   	<a href="<c:url value='/shop/handMade/gobackItem.do'>
		         <c:param name="productId" value="${productId}"/></c:url>">
		         이전 단계로</a>
	   <input type="submit" value="다음 단계로" />
   </form:form>
</body>
</html>