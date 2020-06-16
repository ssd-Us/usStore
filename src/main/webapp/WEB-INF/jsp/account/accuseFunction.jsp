<%-- <%@ page contentType="text/html; charset=UTF-8" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<script type="text/javascript"> 
function accuse(href){  //a랑 href 
	var reason = prompt('판매자 신고하기', '신고 사유를 작성하세요.');
	if(reason){
		a.href += "&reason=" + reason;
		alert("신고되었습니다.");}
	else{alert("취소되었습니다.?? 정말 취소되도록 (디비문 안들어가도록)수정"); }
}
</script>
<% System.out.println("accuseFunction.jsp come in"); %>
<span>
		<c:choose>
	   				<c:when test="${isAccuse}">
						신고 완료 
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${productId==0}">
								<a href="<c:url value='/addAccuse.do'>
								<c:param name="userId" value="${gb.userId}"/>
		 						<c:param name="itemId" value="${gb.itemId}"/>
		 						<c:param name="productId" value="${productId}"/></c:url>"
								onClick = "accuse(); return;">판매자 신고하기</a>
							</c:when>
							<c:when test="${productId==1}">
								<a href="<c:url value='/addAccuse.do'>
								<c:param name="userId" value="${auction.userId}"/>
		 						<c:param name="itemId" value="${auction.itemId}"/>
		 						<c:param name="productId" value="${productId}"/></c:url>"
								onClick = "accuse(); return;">판매자 신고하기</a>
							</c:when>
							<c:when test="${productId==2}">
								<a href="<c:url value='/addAccuse.do'>
								<c:param name="userId" value="${sh.userId}"/>
		 						<c:param name="itemId" value="${sh.itemId}"/>
		 						<c:param name="productId" value="${productId}"/></c:url>"
								onClick = "accuse(this.href); return;">판매자 신고하기</a>
							</c:when>
							<c:when test="${productId==3}">
								<a href="<c:url value='/addAccuse.do'>
								<c:param name="userId" value="${handMade.userId}"/>
		 						<c:param name="itemId" value="${handMade.itemId}"/>
		 						<c:param name="productId" value="${productId}"/></c:url>"
								onClick = "accuse(); return;">판매자 신고하기</a>
							</c:when>
						</c:choose>
					</c:otherwise>
		</c:choose>
		<!-- 로그인 여부 따지기  , 이  url누르면  인터셉터에서 로그인 여부 따져서 컨트롤러로 보내줄지말지 설정 -->
		 <!-- 여기서 userId는  판매자를 의미하고, 세션의 로그인 아이디가 신고자 아이디이다.-->
		<!-- 파라미터로 신고사유 넘겨주기 -->
</span>
