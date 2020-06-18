<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="itemTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<title>ê³µëêµ¬ë§¤ ì¶ê° ìë ¥ í¼</title>
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
    <td><a href='<c:url value="/shop/GroupBuying/index.do"/>'>
        <b><font color="black" size="2">
          &lt;&lt; Go to Index</font></b></a>
    </td>
  </tr>
</table>
<div id = "addItemForm">
<h2>ADD ITEM</h2>
<hr width = "927px" align="left"><br><br>
	<spring:hasBindErrors name="GroupBuying" />

	<form:form modelAttribute="GroupBuying" method="post" action="step3.do">
		
	íë§¤ê°: <form:input type="text" path="listPrice" value="${listPrice}" />
	<form:errors path="listPrice"/> <br><br>
	
	ë§ê°ê¸°í: 
	<form:input type="date" path="date"/>
	<form:input type="time" path="time"/> 
	<form:errors path="deadLine"/> 
	<br><br>
	
	<a href="<c:url value='/shop/groupBuying/gobackItem.do'>
		         <c:param name="productId" value="${productId}"/>
		     </c:url>
		">[ì´ì  ë¨ê³ë¡]</a> <input type="submit" value="ë¤ì ë¨ê³ë¡" />
	</form:form>
</div>
</body>
</html>