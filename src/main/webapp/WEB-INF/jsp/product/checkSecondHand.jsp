<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="itemTop.jsp"%>

<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
   Date nowTime = new Date();
   SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
%>

<title>중고거래 입력 최종 확인 step3</title>
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
    <td><a href='<c:url value="/shop/secondHand/index.do"/>'>
        <b><font color="black" size="2">
          &lt;&lt; Go to Index</font></b></a>
    </td>
  </tr>
</table>

<h1>중고거래 최종 확인</h1>
<h2>다음 정보로 판매하시겠습니까?</h2><br><br>

<form:form action="done.do">
      <hr width="927px" align="left">
      <br><br>
      <label>제목</label> : ${itemForm.title} <br>
      <label>내용</label> : ${itemForm.description} <br>
      <label>수량</label> : ${itemForm.qty} <br>
      <label>정가</label> : ${itemForm.unitCost}원 <br> 
      <label>판매가</label> : ${secondHandForm.listPrice}원 <br> 
      <label>에누리가능여부</label> :
      		<c:choose>
	   				<c:when test="${secondHandForm.discount eq 1}">
						<td><c:out value="에눌 가능" /></td> 
					</c:when>
					<c:otherwise>
						<td> <c:out value="에눌 불가능" /></td> 
					</c:otherwise>
			</c:choose><br>
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
<br>
<label>접수 일시</label> : ${sf} <br><br>

      <a href="<c:url value='/shop/secondHand/addItem2.do'>
         <c:param name="productId" value="${itemForm.productId}"/></c:url>">[이전 단계로]&nbsp;&nbsp;</a> 
      <input type="submit" value="[확인]" /> 
</form:form>

</body>
</html>