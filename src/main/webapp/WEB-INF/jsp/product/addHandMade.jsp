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
	   �������ɿ���: <form:input path="title" value="${title}"/>
	   <form:errors path="title"/> <br>
	   
	   �ǸŰ�: <form:input path="listPrice" value="${listPrice}"/>
	   <form:errors path="listPrice"/> <br>
	   
	   <a href="<c:url value='step1/${item.productId}'/>">���� �ܰ��</a>
	   <input type="submit" value="���� �ܰ��" />
   </form:form>
</body>
</html>