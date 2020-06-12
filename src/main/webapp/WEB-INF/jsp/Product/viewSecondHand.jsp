<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 상세페이지</title>
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
<script type="text/javascript"> 
function accuse(){
	var reason = prompt('판매자 신고하기', '신고 사유를 작성하세요.');
	if(reason == null){alert("취소");} 
	else{alert("확인\n 사유 : " + reason); }
}
	
</script>
</head>
<body>
<!-- 여기서 secondHand는 컨트롤러에서 보내준 모델 객체(db에서 select 결과 ) -->
<!-- 아직 메세지 파일 작성안함 반드시 푸시전에 메세지 체크하기 !!!!!!!!!! -->
<table style="margin-left: auto; margin-right: auto;">
	<tr>
		<td style="text-align: left; padding: 0px; font-size: small; border-bottom: none;">
		${sh.viewCount}<font color=gray>view</font>
		</td>
		<td style="text-align: right; padding: 0px; font-size: small; border-bottom: none;">
		<a href="
							<c:url value='/addBookmark/${sh.userId}/${sh.itemId}'/>	<!-- 로그인 여부 따지기 -->
					">[북마크 추가]</a>
		</td>
	</tr>
   	<tr>
	   	<th style="border-right: 1px solid black; border-top: 1px solid black;">제목</th>
	   	<td style="border-top: 1px solid black;">${sh.title}</td>
   	</tr>	
   	<tr>
   		<th style="border-right: 1px solid black;">판매자</th>
   		<td>이채정&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   	<span>
		   	<a href="
					<c:url value='/addFollow/${sh.userId}'/>	<!-- 로그인 여부 따지기 -->
			">팔로잉</a>
		</span>
		&nbsp;
		<span>
		<a href="
			<c:url value='/addAccuse/${sh.userId}'/>	<!-- 로그인 여부 따지기  , 이  url누르면  인터셉터에서 로그인 여부 따져서 컨트롤러로 보내줄지말지 설정 -->
			" onclick = "accuse();">판매자 신고</a> <!-- 여기서 userId는  판매자를 의미하고, 세션의 로그인 아이디가 신고자 아이디이다.-->
		</span>
   		</td>
   	</tr> 
   	<tr>
   		<td colspan="2" style="padding: 15px;">${sh.description}<br></td>
   	</tr>
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
			<c:url value='/searchTag/${sh.itemId}'/>	<!-- tag검색 결과 페이지로 이동 -->
		">#한정판</a>&nbsp;	
		<a href="
			<c:url value='/searchTag/${sh.itemId}'/>	<!-- tag검색 결과 페이지로 이동 -->
			">#커스텀</a>&nbsp;
		<a href="
			<c:url value='/searchTag/${sh.itemId}'/>	<!-- tag검색 결과 페이지로 이동 -->
			">#경매</a>&nbsp;
   		</td>
   	</tr>
   	<tr>
   			<th style="border-right: 1px solid black;">가격</th>
   			<td>
   				인터넷 정가  : ${sh.unitCost}원<br>
   			</td>
   			<td>
   				<%-- 중고거래 판매가 : ${sh.listPrice}원 <br> --%>
   			</td>
   	</tr>
   	<tr>
   			<th style="border-right: 1px solid black;">에눌가능여부</th>
   			<td>
   			    판매자 설정: 
   				<c:if test="${sh.discount == 1}">
   					<c:out value="에눌 가능합니다" />
   				</c:if>
   				<c:if test="${sh.discount == 0}">
   					<c:out value="가격 흥정은 불가능합니다." />
   				</c:if>
   			</td>
   	</tr>
   	<tr>
   		<th style="border-right: 1px solid black;">수량 </th> 
   		<td>${sh.qty}</td>
   	</tr>	
   	<tr>
   			<td colspan="2" style="border-bottom: none;">
   				<span>
   				<a href="
							<c:url value='/note/${sh.userId}'/>	<!-- 로그인 여부 따지기 -->
				">쪽지 보내기</a>
				</span><br><br>
   			</td>
   	</tr>
   		
   	<c:if test="${sh.userId==session.userId}"> <!-- 로그인시 실행 -->
   		<tr>
   		<td colspan="2" style="text-align: right; padding: 0px; font-size: small; border-bottom: none; border-top: 1px solid black;">
		   <a href="<c:url value='/editItem/${auction.itemId}'/>">[게시물 수정하기]</a>
		   <a href="<c:url value='/deleteItem/${auction.itemId}'/>"> [게시물 삭제하기]</a>
		   </td>
		 </tr>
	</c:if>
</table>
        
       

<!--* 현재 로그인 user가 글 작성자 일때만 수정/삭제 버튼이 보임 
   * 작성자 정보는 controller에서 model(db에서 suppId찾아옴)로 넘겨줌
   * model로 넘어온 suppId와 세션의 로그인Id를 비교함 
   * 세션에 로그인 정보가 없으면, 즉 null이어도 수정/삭제 안보여줌-->

</body>   
</html>