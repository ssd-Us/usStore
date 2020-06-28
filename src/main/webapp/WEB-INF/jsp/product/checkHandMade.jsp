<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="itemTop.jsp" %>
<%@ page import="com.example.usStore.controller.item.ItemForm" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Step3</title>
</head>
<style>
	div#addItemForm {
		position: absolute;
		left: 18%;
		border: none;
		padding: 20px;
	}
</style>
<table id="main-menu">
  <tr>
    <td><a href='<c:url value="/shop/handMade/index.do"/>'>
        <b><font color="black" size="2">
          &lt;&lt; Go to Index</font></b></a>
    </td>
  </tr>
</table>
<body>
<h1>공동구매 최종 확인</h1>
다음 정보로 판매하시겠습니까?<br><br>

<form:form modelAttribute="HandMade" action="detailItem.do"> 
<label>제목</label>: ${itemForm.title} <br> 
<label>내용</label>: ${itemForm.description} <br> 
<label>정가</label>: ${itemForm.unitCost}원 <br> 
<label>판매가</label>: ${handMade.listPrice}원 <br> 
<label>수량</label>: ${itemForm.qty} <br> 
<label>태그</label>: 
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
	<br> 

<a href="<c:url value='/shop/handMade/gobackAddHandMade.do'>
			<c:param name="productId" value="${itemForm.productId}"/>
		 </c:url>
		">[이전 단계로]</a> <input type="submit" value="확인" />
</form:form>
</body>
</html>