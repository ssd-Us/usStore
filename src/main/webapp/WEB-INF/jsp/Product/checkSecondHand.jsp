<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
   Date nowTime = new Date();
   SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 입력 최종 확인 step3- view 이름을 check로 바꾸기</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    text-align: center;
}
</style>
</head>
<body>
	<h2>다음 정보로 게시글을 등록하시겠습니까?</h2>
	
  <form:form >
		<!--  action="<c:url value='/shop/secondHand/detailItem/'/>${secondHand.itemId}"
		modelAttribute="secondHand"  -->
	<%-- 	<form:label path="unitcost">정가 : </form:label> --%>
	<%-- 	${secondHand.unitcost} --%>
		110,000
		<br/>
		
<%-- 		<form:label path="title">제목 : </form:label> --%>
<%-- 		${secondHand.title} --%>
		미개봉 게이밍용 마우스 팔아요
		<br/>

<%-- 		<form:label path="description">내용 : </form:label> --%>
		<%-- ${secondHand.description} --%>
		미개봉 새상품입니다. 매너거래 시 만원 할인해드려요.
		<br/>
		
	<%-- 	<form:label path="qty">수량 : </form:label> --%>
		<%-- ${secondHand.qty} --%>
		2
		<br/>

		<%-- <form:label path="discount">discount : </form:label> --%>
		<%-- ${secondHand.discount} --%>
		에누리 해요 
		<br/>	

	<%-- 	<form:label path="listPrice">listPrice : </form:label> --%>
		<%-- ${secondHand.listPrice} --%>
		30000
		<br/>
		
		<p><a href="<c:url value='/shop/secondHand/addItem/'/>${secondHand.itemId}">이전으로</a></p>
		<input type="submit" value="[게시글 등록]">
	</form:form> --%>

</body>
</html>