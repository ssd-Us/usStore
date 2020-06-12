<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 상세페이지</title>
</head>
<style type="text/css"> 
	a { text-decoration:none } 
</style> 
<style>
	.right-box {
	  float: right;
	  border-radius: 2em;
	  text-align: center;
	}
	
	span {
		width:10%; 
		height: 10px; 
		border: 1px solid blue;
		border-radius: 2em;
		font-size: small;
		text-align: center;
		padding: 5px;
	}
	
	table {
			border: none;
		 	text-align: center;
			font-size: medium;
			padding: 15px;
	}
	
	 th, td {
				border-bottom: 1px solid black;
			    border-collapse: collapse;
			    text-align: center;
			    font-size: medium;
			    padding: 15px;
	}
	
</style>
<body>
	
	<table style="margin-left: auto; margin-right: auto;">
	<tr>
		<td style="text-align: left; padding: 0px; font-size: small; border-bottom: none;">
		2,000<font color=gray>view</font>
		</td>
		<td style="text-align: right; padding: 0px; font-size: small; border-bottom: none;">
		<a href="
							<c:url value='/addBookmark/${gb.suppId}/${gb.itemId}'/>	<!-- 로그인 여부 따지기 -->
					">[북마크 추가]</a>
		</td>
	
	</tr>
   		<tr>
	   		<th style="border-right: 1px solid black; border-top: 1px solid black;">제목</th>
	   		<td style="border-top: 1px solid black;">대학교 과잠 공동구매</td>
   		</tr>
   		
   		<tr>
   			<th style="border-right: 1px solid black;">판매자</th>
   			<td>푸드리&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   			<span>
		   			<a href="
							<c:url value='/addFollow/${gb.suppId}'/>	<!-- 로그인 여부 따지기 -->
					">팔로잉</a>
				</span>
				&nbsp;
				<span>
					<a href="
							<c:url value='/addAccuse/${gb.suppId}'/>	<!-- 로그인 여부 따지기 -->
					">판매자 신고</a>
				</span>
   			</td>
   		</tr> <!-- userId = suppId -->
   		
   		<tr><td colspan="2" style="padding: 15px;">이 상품은 대학교에서 가장 잘 팔리는 디자인, 색상입니다!!!<br></td></tr>
   		
   		<tr>
   			<th style="border-right: 1px solid black;"><font color=blue>#</font>관련태그</th>
   			<td>
   			<%-- <c:forEach var="tag" items="${tag}">	<!-- tag 테이블 이용 -> 해당 itemId를 어떻게 연결하지? -->
   				<a href="
					<c:url value='/searchTag'>	<!-- tag검색 결과 페이지로 이동 -->
					  <c:param name="tagName" value="${tag.tagName}"/>
				  	</c:url>
				">#${tag.tagName}</a>&nbsp;
   			</c:forEach> --%>
   			<a href="
					<c:url value='/searchTag/${gb.tagName}'/>	<!-- tag검색 결과 페이지로 이동 -->
				">#과잠</a>&nbsp;
				
			<a href="
					<c:url value='/searchTag/${gb.tagName}'/>	<!-- tag검색 결과 페이지로 이동 -->
				">#단체복</a>&nbsp;
   			</td>
   		</tr>
   		
   		<tr>
   			<th style="border-right: 1px solid black;"><font color=red>마감 날짜</font></th>
   			<td><font color=red>
   				10일 남음
   			</font></td>
   		</tr>
   		
   		<tr>
   		<th style="border-right: 1px solid black;">판매가</th>
   			<td>
   				<del>정가 : 70000 원</del> <br>
   				공동구매가 : <ins>35000</ins> 원&nbsp;<font color=red>-50%</font> <br>
   			</td>
   		</tr>
   		
   		<tr>
   		<th style="border-right: 1px solid black;">수량 </th> 
   		<td> 20</td>
   		</tr>
   		
   		<tr>
   			<td colspan="2" style="border-bottom: none;">
   			<span>
		   			<a href="
							<c:url value='/addCart/${gb.itemId}'/>	<!-- 로그인 여부 따지기 -->
					">장바구니 추가</a>
				</span>
				&nbsp;&nbsp;&nbsp;
				<span>
					<a href="
							<c:url value='/order/${gb.itemId}'/>	<!-- 로그인 여부 따지기 -->
					">공동구매 참여</a>
				</span>
				&nbsp;&nbsp;&nbsp;
				<span>
   				<a href="
							<c:url value='/note/${gb.itemId}'/>	<!-- 로그인 여부 따지기 -->
				">쪽지 보내기</a>
				</span>
   			
   			</td>
   		</tr>
   		
   		<c:if test="${sh.suppId==session.userId}"> <!-- 로그인시 실행 -->
   		<tr>
   		<td colspan="2" style="text-align: right; padding: 0px; font-size: small; border-bottom: none; border-top: 1px solid black;">
		   <a href="<c:url value='/editItem/${item.productId}'/>">[게시물 수정하기]</a>
		   <a href="<c:url value='/deleteItem/${item.productId}'/>"> [게시물 삭제하기]</a>
		   </td>
		 </tr>
		</c:if>
   <!-- 하나의 url을 공유하며 파라미터로 아이디 값을 넘겨줄지
   네개의 컨트롤러를 각자 구현할지 정해야함
   deleteItem 아이디만 받아와서 한번만 삭제할수 있는게 아니고
    어차피 db테이블이 다르니까 delete문은 4번 써줘야함  -->
   	</table>
   	<br><br>
	
</body>
</html>