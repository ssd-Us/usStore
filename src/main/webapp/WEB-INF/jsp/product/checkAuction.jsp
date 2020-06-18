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
<title>경매 추가 확인 페이지</title>
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
<h2>경매 추가 확인</h2>
<hr width = "927px" align="left"><br><br>
<label>제목</label> : ${itemForm.title} <br> 
<label>내용</label> : ${itemForm.description} <br> 
<label>수량</label> : ${itemForm.qty} <br> 

<label>태그</label> : 

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
<label>시작 가격</label> : ${Auction.startPrice}원<br> 
<label>마감 날짜</label> : ${Auction.deadLine} <br><br>
<br><br>
<label>접수 일시</label> : ${date} <br><br>

<p><a href="/addItemStep2">[이전 단계로]</a> <input type="submit" value="경매 추가" /></p>
</form:form>
</div>
</body>
</html>