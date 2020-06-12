<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 상세페이지</title>


</head>
<body>
   <!-- 여기서 secondHand는 컨트롤러에서 보내준 모델 객체(db에서 select 결과 ) -->
   <ul>      <!-- 아직 메세지 파일 작성안함 반드시 푸시전에 메세지 체크하기 !!!!!!!!!! -->
      <li><label><spring:message code="title"/></label>:
         ${sh.title}</li>
   
      <li><label><spring:message code="description"/>:</label>
         ${sh.description} </li>

      <li><label><spring:message code="viewcount"/>:</label>
         ${sh.viewcount} </li>
      
      <li><label><spring:message code="discount"/>:</label>
         ${sh.discount} </li>
         
      <li><label><spring:message code="unitcost"/>:</label>
         ${sh.unitcost} </li>
         
      <li><label><spring:message code="listprice"/>:</label>
         ${sh.listprice} </li>   
   </ul>

<!--* 현재 로그인 user가 글 작성자 일때만 수정/삭제 버튼이 보임 
   * 작성자 정보는 controller에서 model(db에서 suppId찾아옴)로 넘겨줌
   * model로 넘어온 suppId와 세션의 로그인Id를 비교함 
   * 세션에 로그인 정보가 없으면, 즉 null이어도 수정/삭제 안보여줌-->
<c:if test="${sh.suppId==session.userId}"> <!-- if문 수정 의미만 맞게 작성한거임 -->
   <a href="<c:url value='/editItem/${item.productId}'/>">[게시물 수정하기]</a>
   <a href="<c:url value='/deleteItem/${item.productId}'/>"> [게시물 삭제하기]</a><p/> 
<!-- 하나의 url을 공유하며 파라미터로 아이디 값을 넘겨줄지
   네개의 컨트롤러를 각자 구현할지 정해야함
   deleteItem 아이디만 받아와서 한번만 삭제할수 있는게 아니고
    어차피 db테이블이 다르니까 delete문은 4번 써줘야함  -->
</c:if>
</body>   
</html>