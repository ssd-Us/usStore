<%@ include file="itemTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<title>상품 입력 폼</title>
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
	
	제목 <form:input type="text" path="title" style="width:380px; height:35px;"/>
	<form:errors path="title"/> <br><br>
	
	내용 <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:textarea path="description" cols="50" rows="10"/>
	<form:errors path="description"/> <br><br>
	
	정가 <form:input type="text" path="unitCost" value="${unitCost}"/>원
	<form:errors path="unitCost"/> <br><br>
	
	수량 <form:input type="text" path="qty" value="${qty}"/>
	<form:errors path="qty"/> <br><br>
	
	태그 
	<form:input path="tag1" placeholder="#tag"/>
	<form:errors path="tag1"/>&nbsp;
	<form:input path="tag2" placeholder="#tag"/>
	<form:errors path="tag2"/>&nbsp;
	<form:input path="tag3" placeholder="#tag"/>
	<form:errors path="tag3"/>&nbsp;
	<form:input path="tag4" placeholder="#tag"/>
	<form:errors path="tag4"/>&nbsp;
	<form:input path="tag5" placeholder="#tag"/>
	<form:errors path="tag5"/> <br><br><br>
	
	<input type="submit" value="다음 단계로" />
	
	</form:form>
</div>
</body>
</html>