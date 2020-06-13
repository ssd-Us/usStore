<%@ include file="itemTop.jsp" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<% Date nowTime = new Date(); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Step3</title>
</head>
<body>
<h1>공동구매 입력 최종 확인</h1>
다음 정보로 신청하시겠습니까?<br><br>

<h1>공연 참가 신청 - Step3</h1>
다음 정보로 신청하시겠습니까?<br><br>
<form:form modelAttribute="gbform" action="/shop/groupbuying/detailItem/${groupbuying.itemId}">
<label>제목</label>: ${gbform.title} <br> 
<label>내용</label>: ${gbform.description} <br> 
<label>정가</label>: ${gbform.unitCost} <br> 
<label>판매가</label>: ${gbform.listPrice} <br> 
<label>할인율</label>: ${gbform.discount} <br> 
<label>수량</label>: ${gbform.qty} <br> 
<label>태그</label>: ${gbform.tag} <br> 
<label>마감기한</label>: ${gbform.deadLine} <br><br>

<a href="step2">[이전 단계로]</a> <input type="submit" value="확인" />
</form:form>
</body>
</html>