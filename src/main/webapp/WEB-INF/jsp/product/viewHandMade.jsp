<%@ include file="itemTop.jsp" %>
<style type="text/css"> 
	a { text-decoration:none } 
</style> 
<style>
	.right-box {
		float: right;
		border-radius: 2em;
		text-align: center;
	}
	
	span {
		width: 10%;
		height: 10px;
		border: 1px solid blue;
		border-radius: 2em;
		font-size: small;
		text-align: center;
		padding: 5px;
	}
	
	table #item-detail {
		border: none;
		text-align: center;
		font-size: medium;
		padding: 15px;
	}
	
	th, td {
		border-bottom: 1px solid black;
		border-collapse: collapse;
		text-align: center;
		font-size: medium;
		padding: 15px;
	}
</style>

<table id="main-menu">
  <tr>
    <td>
      <a href='<c:url value="/shop/handMade/viewItem.do">
        <c:param name="productId" value="${handMade.productId}"/></c:url>'>
        <b><font color="black" size="2">
          &lt;&lt; Go to List</font></b></a>
    </td>
  </tr>
</table>

<body>
	<table id="item-detail" style="margin-left: auto; margin-right: auto;">
	<tr>
		<!-- ViewCount -->
		<td style="text-align: left; padding: 0px; font-size: small; border-bottom: none;">
		 <c:out value="${handMade.viewCount}" /><font color=gray>view</font>
		</td>
		<td style="text-align: right; padding: 0px; font-size: small; border-bottom: none;">
		<a href="
							<c:url value='/addBookmark/${gb.suppId}/${gb.itemId}'/>	<!-- 로그인 여부 따지기 -->
					">[북마크 추가]</a>
		</td>
	
	</tr>
		<!-- ItemId -->
	   	<tr>
   			<th style="border-right: 1px solid black; border-top: 1px solid black;">제품 번호</th>
   			<td style="border-top: 1px solid black;"><c:out value="${handMade.itemId}" /></td>
   		</tr>
   		<tr>
   			<!-- Title -->
	   		<th style="border-right: 1px solid black;">제목</th>
	   		<td><c:out value="${handMade.title}" /></td>
   		</tr>
   		
   		<tr>
   			<!-- UserId -->
   			<th style="border-right: 1px solid black;">판매자</th>
   			<td><c:out value="${handMade.userId}" />
   				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   			<span>
		   			<a href="
							<c:url value='/addFollow/${gb.suppId}'/>	<!-- 로그인 여부 따지기 -->
					">팔로잉</a>
				</span>
				<!-- 판매자 신고하기 -->
				&nbsp; <%@ include file="/WEB-INF/jsp/account/accuseFunction.jsp" %>
   			</td>
   		</tr> <!-- userId = suppId -->
   		
   		<tr>
   			<!-- Description -->
   			<td colspan="2" style="padding: 15px;"><c:out value="${handMade.description}" escapeXml="false" /><br></td>
   		</tr>
   		
   		<tr>
   			<th style="border-right: 1px solid black;"><font color=blue>#</font>관련태그</th>
   			<td>
   			<%-- <c:forEach var="tag" items="${tag}">	<!-- tag 테이블 이용 -> 해당 itemId를 어떻게 연결하지? -->
   				<a href="
					<c:url value='/searchTag'>	<!-- tag검색 결과 페이지로 이동 -->
					  <c:param name="tagName" value="${tag.tagName}"/>
				  	</c:url>
				">#${tag.tagName}</a>&nbsp;
   			</c:forEach> --%>
   			<a href="
					<c:url value='/searchTag/${gb.tagName}'/>	<!-- tag검색 결과 페이지로 이동 -->
				">#과잠</a>&nbsp;
				
			<a href="
					<c:url value='/searchTag/${gb.tagName}'/>	<!-- tag검색 결과 페이지로 이동 -->
				">#단체복</a>&nbsp;
   			</td>
   		</tr>
   		<tr>
   		<th style="border-right: 1px solid black;">판매가</th>
   			<td>
   				<del>정가 :  <c:out value="${handMade.listPrice}" /> 원</del> <br>
   				단가 : <ins> <c:out value="${handMade.unitCost}" /></ins> 원&nbsp;<font color=red>-50%</font> <br>
   			</td>
   		</tr>
   		
   		<tr>
   			<!-- Quantity -->
   			<th style="border-right: 1px solid black;">수량 </th> 
	   		<td>
	   		<c:if test="${handMade.qty <= 0}">
			        <font color="red" size="2"><i>Back ordered.</i></font>
			      </c:if> 
			      <c:if test="${handMade.qty > 0}">
			        <font size="2"><fmt:formatNumber value="${handMade.qty}" /> in stock.</font>
			      </c:if>
	   		</td>
   		</tr>
   		
   		<tr>
   			<td colspan="2" style="border-bottom: none;">
   			<span>
		   			<a href="
							<c:url value='/shop/addItemToCart.do/${gb.itemId}'/>	<!-- 로그인 여부 따지기 -->
					">장바구니 추가</a>
				</span>
				&nbsp;&nbsp;&nbsp;
				<span>
					<a href="
							<c:url value='/order/${gb.itemId}'/>	<!-- 로그인 여부 따지기 -->
					">공동구매 참여</a>
				</span>
				&nbsp;&nbsp;&nbsp;
				<span>
   				<a href="
							<c:url value='/note/${gb.itemId}'/>	<!-- 로그인 여부 따지기 -->
				">쪽지 보내기</a>
				</span>
   			
   			</td>
   		</tr>
<%--    		<c:if test="${sh.suppId==session.userId}"> <!-- 로그인시 실행 --> --%>
	   		<tr>
		   		<td colspan="2" style="text-align: right; padding: 0px; font-size: small; border-bottom: none; border-top: 1px solid black;">
				   <a href="<c:url value='/shop/handMade/editItem.do?itemId=${handMade.itemId}'/>">[게시물 수정하기]</a>
				   <a href="<c:url value='/shop/handMade/deleteItem.do?productId=${handMade.productId}&itemId=${handMade.itemId}'/>"> [게시물 삭제하기]</a>
				</td>
			</tr>
<%-- 		</c:if> --%>
   	</table>
   	<br><br>
</body>
<%@ include file="itemBottom.jsp" %>