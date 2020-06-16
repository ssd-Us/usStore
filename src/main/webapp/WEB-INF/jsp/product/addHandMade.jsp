<%@ include file="itemTop.jsp" %>
<style>
	div #addHandMadeForm {
		position: absolute;
		left: 18%;
		border: none;
		padding: 20px;
	}
</style>
<div id="addHandMadeForm">
	<h2>Add HandMade</h2><hr><br><br>
	<spring:hasBindErrors name="HandMade" />
    <form:form modelAttribute="HandMade" method="post" action="step3.do">
	   판매가: <form:input type="text" path="listPrice" value="${listPrice}"/>
	   <form:errors path="listPrice"/> <br>
	   
	   	<a href="<c:url value='/shop/handMade/gobackItem.do'>
		         <c:param name="productId" value="${productId}"/></c:url>">
		         이전 단계로</a>
	   <input type="submit" value="다음 단계로" />
   </form:form>
 </div>
</body>
</html>