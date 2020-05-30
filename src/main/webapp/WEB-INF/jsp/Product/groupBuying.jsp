<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 게시물 목록</title>
<style>
			table, th, td {
			    border: 1px solid black;
			    border-collapse: collapse;
			    text-align: center;
			}
</style>
</head>
<body>
	공동구매 게시글 목록: <br/><br/>
<table style="width:70%;">
   		<tr><th>&nbsp;</th><th>게시물 제목</th><th>정가</th><th>공동구매가</th><th>할인율</th><th>수량</th></tr>
   		<%
			int index = 0;
		%>
   		<c:forEach var="gb" items="${groupBuyingList}">
   			<%index++; %>
   			<tr>
			
			<td><%=index %></td>
			<td>
				<a href="
					<c:url value='/detail'>
			  		  <c:param name="itemId" value="${gb.itemId}"/>
			  		</c:url>
				">${gb.title}</a>
			</td>
			<td>${gb.unitCost}</td>
			<td>${gb.listPrice}</td>
			<td>${gb.discount}</td>
			<td>${gb.qty}</td>
   		</c:forEach>
</table>
<br/>
<a href="<c:url value='product/register/step1'>	<!-- 로그인 여부 인터셉터로 이동 -->
	<c:param name="productId" value="${item.productId}"/>	<!-- 판매 카테고리 param 전달, 해당 판매 입력폼으로 이동  -->
</c:url>">공동구매 게시글 추가하기</a><p/>
</body>
</html>