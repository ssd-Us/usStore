<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 게시물 목록</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    text-align: center;
}

</style>
</head>
<body>
   <!-- db에서 select 결과 보여주는 페이지 -->
                   
<table style="width:70%">
   <tr><th>순번</th><th>제목</th><th>조회수</th></tr>
   
    <c:forEach var="item" items="${itemList.pageList}" varStatus="status">
      <tr>
         <td>${item.itemId}</td>
         <td><a href="<c:url value='/productDetail'>
                             <c:param name="product" value="2"/>
                           <c:param name="itemId" value="${item.itemId}"/></c:url>">
                        <c:out value="${item.title}"/></a>
            </td>
             <td><c:out value="${item.viewcount}"/></td>                     
      </tr>
   </c:forEach>   
</table>
      <br>
      <a href="<c:url value='secondHand/step1'/>">중고거래 게시글 추가하기</a><p/>
</body>   
</html>