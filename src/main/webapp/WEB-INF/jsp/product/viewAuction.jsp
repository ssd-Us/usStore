<%@ include file="itemTop.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경매 상세 페이지</title>
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
<script>
function participation(price, unitCost) {
	var p = parseInt(price);
	var u = parseInt(unitCost);
	
	alert("입력 가격 : " + p + "\n최댓값 : " + u);

	if (p > u) {
		var c = confirm("경매에 참여하시겠습니까?");

		if (c) {
			form.submit();
		}
		else {
			alert("참여 취소");
		}
	}
}
</script>
<body>
	
	<table style="margin-left: auto; margin-right: auto;">
	<tr>
		<td style="text-align: left; padding: 0px; font-size: small; border-bottom: none;">
		${auction.viewCount}<font color=gray>view</font>
		</td>
		<td style="text-align: right; padding: 0px; font-size: small; border-bottom: none;">
		<a href="
							<c:url value='/addBookmark/${auction.userId}/${auction.itemId}'/>	<!-- 로그인 여부 따지기 -->
					">[북마크 추가]</a>
		</td>
	
	</tr>
   		<tr>
	   		<th style="border-right: 1px solid black; border-top: 1px solid black;">제목</th>
	   		<td style="border-top: 1px solid black;">${auction.title}</td>
   		</tr>
   		
   		<tr>
   			<th style="border-right: 1px solid black;">판매자</th>
   			<td>김문정&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   			<span>
		   			<a href="
							<c:url value='/addFollow/${auction.userId}'/>	<!-- 로그인 여부 따지기 -->
					">팔로잉</a>
				</span>
				&nbsp;
				<span>
					<a href="
							<c:url value='/addAccuse/${auction.userId}'/>	<!-- 로그인 여부 따지기 -->
					">판매자 신고</a>
				</span>
   			</td>
   		</tr> <!-- userId = suppId -->
   		
   		<tr><td colspan="2" style="padding: 15px;">${auction.description}<br></td></tr>
   		
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
					<c:url value='/searchTag/${auction.itemId}'/>	<!-- tag검색 결과 페이지로 이동 -->
				">#한정판</a>&nbsp;
				
			<a href="
					<c:url value='/searchTag/${auction.itemId}'/>	<!-- tag검색 결과 페이지로 이동 -->
				">#커스텀</a>&nbsp;
			<a href="
					<c:url value='/searchTag/${auction.itemId}'/>	<!-- tag검색 결과 페이지로 이동 -->
				">#경매</a>&nbsp;
   			</td>
   		</tr>
   		
   		<tr>
   			<th style="border-right: 1px solid black;"><font color=red>마감 날짜</font></th>
   			<td><font color=red>
   				${auction.deadLine}
   			</font></td>
   		</tr>
   		
   		<tr>
   		<th style="border-right: 1px solid black;">가격</th>
   			<td>
   				시작 가격 : ${auction.startPrice} 원<br>
   				낙찰 가격 : <ins></ins> ${auction.bidPrice}원&nbsp;
   				<c:set var="state" value="${auction.auctionState}"/>
   				<c:if test="${state eq -1}">
   					<font color=red>(경매 대기)</font> <br><br>
   				</c:if>
   				<c:if test="${state eq 0}">
   					<font color=red>(경매 진행중)</font> <br><br>
   				</c:if>
   				<c:if test="${state eq 1}">
   					<font color=red>(경매 종료)</font> <br><br>
   				</c:if>
   				현재 최대 금액 : ${auction.unitCost}원<br>
   			</td>
   		</tr>
   		
   		<tr>
   		<th style="border-right: 1px solid black;">수량 </th> 
   		<td>${auction.qty}</td>
   		</tr>
   		
   		<tr>
   			<td colspan="2" style="border-bottom: none;">
   				<span>
   				<a href="
							<c:url value='/note/${auction.userId}'/>	<!-- 로그인 여부 따지기 -->
				">쪽지 보내기</a>
				</span><br><br>
				
				<c:if test="${state eq 0}">
   				<form name="form" action="<c:url value='/shop/auction/participateItem.do'/>">
   					<input type="text" id="price" name="price" placeholder="참여 가격을 입력하세요."/>
				&nbsp;
				<span onclick="participation(price.value, ${auction.unitCost})">
					<!-- 로그인 여부 따지기 -->
					<a href="#">경매 참여</a>
				</span>
				</form>
				</c:if>
   			</td>
   		</tr>
   		
   		<c:if test="${sh.suppId==session.userId}"> <!-- 로그인시 실행 -->
   		<tr>
   		<td colspan="2" style="text-align: right; padding: 0px; font-size: small; border-bottom: none; border-top: 1px solid black;">
		   <a href="<c:url value='/shop/auction/updateItem.do'/>">[게시물 수정하기]</a>
		   <a href="<c:url value='/shop/auction/deleteItem.do'/>"> [게시물 삭제하기]</a>
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