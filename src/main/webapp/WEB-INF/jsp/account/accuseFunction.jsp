<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<script type="text/javascript">
/* 아 여기서 신고버튼 누르면 무조건 자바스크립트 실행되는게 아니라 먼저 에드 어큐즈
   컨트롤러로 가서 로그인 여부 체크 한다음에 다시 보내줘야함 */
function accuse(a){  //a랑 href   //여기는 로그인이 되었을 때 보내주는 페이지 
       var reason = prompt('판매자 신고하기\n신고사유를 작성하세요.', '');
     
     if(reason){
           a.href += "&reason=" + reason;
            alert("신고되었습니다.")}
     else if(reason == ''){ alert("이유를 작성하지 않아 취소됩니다."); }
     else{ alert("취소되었습니다");}
}
</script>
<% System.out.println("accuseFunction.jsp come in"); %>
<span>

      <c:choose>
               <c:when test="${isAccuse}">
                        신고한 판매자입니다
               </c:when>
               <c:otherwise>
                  <c:choose> 
                     <c:when test="${productId==0}">
                        <a href="<c:url value='/addAccuse.do'>
                        <c:param name="userId" value="${gb.userId}"/>
                         <c:param name="itemId" value="${gb.itemId}"/>
                         <c:param name="productId" value="${gb.productId}"/></c:url>"
                        onClick = "accuse(this);">판매자 신고하기</a>
                     </c:when>
                     <c:when test="${productId==1}">
                        <a href="<c:url value='/addAccuse.do'>
                        <c:param name="userId" value="${auction.userId}"/>
                         <c:param name="itemId" value="${auction.itemId}"/>
                         <c:param name="productId" value="${auction.productId}"/></c:url>"
                        onClick = "accuse(this);">판매자 신고하기</a>
                     </c:when>
                     <c:when test="${sh.productId==2}">
                        <a href="<c:url value='/addAccuse.do'>
                        <c:param name="userId" value="${sh.userId}"/>
                         <c:param name="itemId" value="${sh.itemId}"/>
                         <c:param name="productId" value="${sh.productId}"/></c:url>"
                        onClick = "accuse(this);">판매자 신고하기</a>
                     </c:when>
                     <c:when test="${productId==3}">
                        <a href="<c:url value='/addAccuse.do'>
                        <c:param name="userId" value="${handMade.userId}"/>
                         <c:param name="itemId" value="${handMade.itemId}"/>
                         <c:param name="productId" value="${handMade.productId}"/></c:url>"
                        onClick = "accuse(this);">판매자 신고하기</a>
                     </c:when>
                  </c:choose>
               </c:otherwise>
      </c:choose>
      <!-- 로그인 여부 따지기  , 이  url누르면  인터셉터에서 로그인 여부 따져서 컨트롤러로 보내줄지말지 설정 -->
       <!-- 여기서 userId는  판매자를 의미하고, 세션의 로그인 아이디가 신고자 아이디이다.-->
      <!-- 파라미터로 신고사유 넘겨주기 -->
</span>