<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경매 추가 완료 페이지</title>
</head>
<body>
${auction.suppId} 님의 경매 정보 확인
<br><br>
접수 내용:<br/>
<ul>
	<li>제목: ${auction.title}</li>
	<li>내용: ${auction.description}</li>
	<li>마감일: ${auction.deadLine.year}-${auction.deadLine.month}-${auction.deadLine.day}, ${auction.deadLine.hour}:${auction.deadLine.minute}:${auction.deadLine.second}</li>
	<li>시작 가격: ${auction.startPrice}</li>
	<li>낙찰 가격: ${auction.bidPrice}</li>
</ul>
<br/>
접수 일시: ${date}
<p><a href="<c:url value='/Product/viewAuction' />">경매 추가 완료</a></p>
</body>
</html>