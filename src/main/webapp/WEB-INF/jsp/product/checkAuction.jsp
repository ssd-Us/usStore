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
<meta charset="UTF-8">
<title>ê²½ë§¤ ì¶ê° íì¸ íì´ì§</title>
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
<form:form modelAttribute="Auction" action="detailItem.do">
<h2>ê²½ë§¤ ì¶ê° íì¸</h2>
<hr width = "927px" align="left"><br><br>
<label>ì ëª©</label> : ${itemForm.title} <br> 
<label>ë´ì©</label> : ${itemForm.description} <br> 
<label>ìë</label> : ${itemForm.qty} <br> 

<label>íê·¸</label> : 

<c:if test="${itemForm.tag1 != '' && itemForm.tag1 ne null}">
	<font color="blue">#</font>${itemForm.tag1} 
</c:if>
<c:if test="${itemForm.tag2 != '' && itemForm.tag2 ne null}">
	<font color="blue">#</font>${itemForm.tag2} 
</c:if>
<c:if test="${itemForm.tag3 != '' && itemForm.tag3 ne null}">
	<font color="blue">#</font>${itemForm.tag3} 
</c:if>
<c:if test="${itemForm.tag4 != '' && itemForm.tag4 ne null}">
	<font color="blue">#</font>${itemForm.tag4} 
</c:if>
<c:if test="${itemForm.tag5 != '' && itemForm.tag5 ne null}">
	<font color="blue">#</font>${itemForm.tag5} 
</c:if>

<br><br>
<label>ìì ê°ê²©</label> : ${Auction.startPrice}ì<br> 
<label>ë§ê° ë ì§</label> : ${Auction.deadLine} <br><br>
<br><br>
<label>ì ì ì¼ì</label> : ${date} <br><br>

<p><a href="/addItemStep2">[이전 단계로]</a> <input type="submit" value="경매 추가" /></p>
</form:form>
</div>
</body>
</html>