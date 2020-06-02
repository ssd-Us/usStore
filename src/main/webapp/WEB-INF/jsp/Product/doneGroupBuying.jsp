<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<% Date nowTime = new Date(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 입력 최종 확인</title>
</head>
<body>
	${groupBuying.userId}님의 게시글 입력을 완료했습니다.<br><br>
입력 내용:<br>
<ul>
	<li>제목: ${groupBuying.title} </li>
	<li>내용: ${groupBuying.description}</li>
	<li>정가: ${groupBuying.unitCost} </li>
	<li>판매가: ${groupBuying.listPrice} </li>
	<li>할인율: ${groupBuying.discount} </li>
	<li>수량: ${groupBuying.qty} </li>
	<li>태그: ${groupBuying.tag} </li>
	<li>마감기한: ${groupBuying.deadLine} </li>
</ul>
<br>
접수 일시:&nbsp; <%= nowTime %>
<br><br>
<a href="<c:url value='/groupBuying' />">공동구매 페이지로</a>
</body>
</html>