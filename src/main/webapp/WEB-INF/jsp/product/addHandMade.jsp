<%@ include file="itemTop.jsp"%>
<body>
   <form:form modelAttribute="HandMade" method="post" action="/shop/handMade/step3">
	   판매가: <form:input type="text" path="listPrice" value="${listPrice}"/>
	   <form:errors path="listPrice"/> <br>
	   
	   <a href="<c:url value='step1/${productId}'/>">이전 단계로</a>
	   <input type="submit" value="다음 단계로" />
   </form:form>
</body>
</html>