<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
   Date nowTime = new Date();
   SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 입력 최종 확인 step3- view 이름을 check로 바꾸기</title>
</head>
<body>
   <h1><%-- <spring:message code="confirm" arguments="${memInfo.name}"/> --%>누구님이 입력을 확인</h1>
   <h2><%-- <spring:message code="detail"/> --%>세부 정보</h2>
   
   <ul>
      <li><label>정가</label>:
      ${secondHand.unitcost}</li>
      <li><label>제목</label>:
      ${secondHand.unitcost}</li>
      <li><label>내용</label>:
      ${secondHand.unitcost}</li>
      <li><label>수량</label>:
      ${secondHand.unitcost}</li>
      
    
      <li><label>discount</label>:
      ${secondHand.discount}</li>
      <li><label>listPrice</label>:
      ${secondHand.listPrice}</li>
   
   </ul>
   
   <h2><%-- <spring:message code="registDate"/> --%>접수 일시 : <%=sf.format(nowTime) %>   </h2>
   <p><a href="<c:url value='/index'/>">Go to home</a></p>
   <!-- 궁금한것: step3페이지인지 confirm 페이지인지...?아님 추가?? -->
   <!-- 확인 버튼 누르면 디테일 페이지로 연결 -->
</body>
</html>