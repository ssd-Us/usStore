<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 상세페이지</title>
</head>
<style>
	.right-box {
	  float: right;
	  width:10%; 
	  height: 10px; 
	  border: 1px solid gray; 
	  border-radius: 2em;
	}
	
	span {
		width:10%; 
		height: 10px; 
		border: 1px solid red;
		border-radius: 2em;
	}

	table, th, td {
			    border: 1px solid black;
			    border-collapse: collapse;
			    text-align: center;
	}
</style>
<body>
	<div class="right-box">
		${gb.viewCount} <font color=gray>view</font>
	</div>
	
	<table style="width:70%;">
   		<tr><th>제목</th><th>${gb.title}</th></tr>
   		
   		<tr>
   			<th>판매자</th>
   			<th>${gb.suppId}&nbsp;&nbsp;
	   			<span>
		   			<a href="
							<c:url value='/addFollow'>	<!-- 로그인 여부 따지기 -->
					  		  <c:param name="suppId" value="${gb.suppId}"/>
					  		</c:url>
					">FOLLOW</a>&nbsp;
				</span>
				<span>
					<a href="
							<c:url value='/addAccuse'>	<!-- 로그인 여부 따지기 -->
					  		  <c:param name="suppId" value="${gb.suppId}"/>
					  		</c:url>
					">판매자 신고</a>
				</span>
   			</th>
   		</tr> <!-- userId = suppId -->
   		
   		<tr><td>${gb.description}</td></tr>
   		
   		<tr>
   			<td><font color=blue>#tag</font></td>
   			<td>
   			<c:forEach var="tag" items="${tag}">	<!-- tag 테이블 이용 -> 해당 itemId를 어떻게 연결하지? -->
   				<a href="
					<c:url value='/searchTag'>	<!-- tag검색 결과 페이지로 이동 -->
					  <c:param name="tagName" value="${tag.tagName}"/>
				  	</c:url>
				">#${tag.tagName}</a>&nbsp;
   			</c:forEach>
   			</td>
   		</tr>
   		
   		<tr>
   			<td><font color=red>마감 날짜</font></td>
   			<td>
   				${gb.deadLine.year}년 ${gb.deadLine.month}월 ${gb.deadLine.day}일
   				${gb.deadLine.hh}시 ${gb.deadLine.mm}분 ${gb.deadLine.ss}초
   			</td>
   		</tr>
   		
   		<tr>
   			<td>
   				<del>정가 : ${gb.unitCost} 원</del> <br>
   				공동구매가 : <ins>${gb.listPrice} 원</ins>&nbsp;<font color=red>${gb.discount}%</font> <br>
   				수량 : ${gb.qty}
   			</td>
   		</tr>
   		
   		<tr>
   			<td>
   				<a href="
							<c:url value='/addCart'>	<!-- 로그인 여부 인터셉터 -->
					  		  <c:param name="itemId" value="${gb.itemId}"/>
					  		</c:url>
				">장바구니 추가</a>
   			</td>
   			<td>
   				<a href="
							<c:url value='/order'>	<!-- orderController 이동 : 로그인 여부 인터셉터 -->
					  		  <c:param name="itemId" value="${gb.itemId}"/>
					  		</c:url>
				">공동구매 참여하기</a>
   			</td>
   			<%-- <td>
   				<a href="
							<c:url value='/addCart'>
					  		  <c:param name="itemId" value="${gb.itemId}"/>
					  		</c:url>
				">쪽지 보내기</a>
   			</td> --%>
   		</tr>
   	</table>
   	<br><br>

	<a href="<c:url value='/editItem'>	<!-- 로그인 여부  && 게시자 확인 인터셉터로 이동 -->
		<c:param name="itemId" value="${item.itemId}"/>
		<c:param name="suppId" value="${item.suppId}"/>
	</c:url>">[게시물 수정하기]</a> &nbsp;
	
	<a href="<c:url value='/deleteItem'> <!-- 로그인 여부  && 게시자 확인 인터셉터로 이동 -->
		<c:param name="itemId" value="${item.itemId}"/>
		<c:param name="suppId" value="${item.suppId}"/>
	</c:url>">[게시물 삭제하기]</a><p/>
</body>
</html>