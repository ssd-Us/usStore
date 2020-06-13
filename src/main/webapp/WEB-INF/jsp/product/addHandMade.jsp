<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
   <form:form modelAttribute="handMade" method="post" action="/shop/handMade/step3"">
	   에눌가능여부: <form:input path="title" value="${title}"/>
	   <form:errors path="title"/> <br>
	   
	   판매가: <form:input path="listPrice" value="${listPrice}"/>
	   <form:errors path="listPrice"/> <br>
	   
	   <a href="<c:url value='step1/${item.productId}'/>">이전 단계로</a>
	   <input type="submit" value="다음 단계로" />
   </form:form>
</body>
</html>