<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
	div#addItemForm {
		position: absolute;
		left: 18%;
		border: none;
		padding: 20px;
	}
</style>

<body>
<table id="main-menu">
  <tr>
    <td><a href='<c:url value="/shop/index.do"/>'>
        <b><font color="black" size="2">
          &lt;&lt; Go to Index</font></b></a>
    </td>
  </tr>
</table>
<div id = "addItemForm">
<h2>ADD ITEM</h2><hr><br><br>
	<spring:hasBindErrors name="item" />
	<form:form modelAttribute="item" method="post" action="addItem2.do?productId=${productId}">
	
	제목 <form:input type="text" path="title" style="width:380px; height:35px;" value="${title}"/>
	<form:errors path="title"/> <br><br>
	
	내용 <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<form:textarea path="description" cols="50" rows="10" value="${discription}"/>
	<form:errors path="description"/> <br><br>
	
	<c:set var="pId" value="${productId}"/>
	<c:if test="${pId != 1}">
	정가 <form:input type="text" path="unitCost" value="${unitCost}"/>
	<form:errors path="unitCost"/> <br><br>
	</c:if>
	
	수량 <form:input type="text" path="qty" value="${qty}"/>
	<form:errors path="qty"/> <br><br>
	
	태그
	<form:input path="tag1" placeholder="#tag" value="${tag1}"/>
	<form:errors path="tag1"/>&nbsp;
	<form:input path="tag2" placeholder="#tag" value="${tag2}"/>
	<form:errors path="tag2"/>&nbsp;
	<form:input path="tag3" placeholder="#tag" value="${tag3}"/>
	<form:errors path="tag3"/>&nbsp;
	<form:input path="tag4" placeholder="#tag" value="${tag4}"/>
	<form:errors path="tag4"/>&nbsp;
	<form:input path="tag5" placeholder="#tag" value="${tag5}"/>
	<form:errors path="tag5"/> <br><br><br>
	
	<input type="submit" value="다음 페이지" />
	
	</form:form>
</div>
</body>
</html>