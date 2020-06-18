<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="itemTop.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<style>
	div#addItemForm {
		position: absolute;
		left: 18%;
		border: none;
		padding: 20px;
	}
</style>
<title>ê²½ë§¤ ì¶ê° íì´ì§</title>
</head>
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
<h2>ADD ITEM</h2>
<hr width = "927px" align="left"><br><br>
	<spring:hasBindErrors name="Auction" />

	<form:form modelAttribute="Auction" method="post" action="step3.do">
		
	ìì ê°ê²©: <form:input type="int" path="startPrice" value="${startPrice}"/>
	<form:errors path="startPrice"/> <br>	
	
	ë§ê° ê¸°í: 
	<form:input type="date" path="date"/>
	<form:input type="time" path="time"/> 
	<form:errors path="deadLine"/> 
	<br>
	
	<a href="<c:url value='/shop/auction/gobackItem.do'>
		         <c:param name="productId" value="${productId}"/>
		     </c:url>
		">[ì´ì  ë¨ê³ë¡]</a> <input type="submit" value="ë¤ì ë¨ê³ë¡" />
	</form:form>
</div>	
</body>
</html>