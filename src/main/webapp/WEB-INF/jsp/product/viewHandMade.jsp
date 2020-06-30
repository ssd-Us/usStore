<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
	    <a href='<c:url value="/shop/index.do"/>'>
	        <b><font color="black" size="2">&lt;&lt; Go to Index</font></b>
	    </a><br><br>
	    <a href='<c:url value="/shop/handMade/listItem.do">
    				<c:param name="productId" value="${handMade.productId}" />
    			</c:url>'>
	        <b><font color="black" size="2">&lt;&lt; Go to List</font></b>
	    </a><br>
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
   			<td>
   				<c:out value="${handMade.userId}" />
   				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<!-- 판매자 신고하기 -->
				<c:choose>
	   				<c:when test="${! empty userSession.account.userId}">
						<%@ include file="/WEB-INF/jsp/account/accuseFunction.jsp" %>
					</c:when>
					<c:otherwise>
						<span>
							<a href="<c:url value='/addAccuseNoLogin.do'>
				                 <c:param name="itemId" value="${handMade.itemId}"/>
				                 <c:param name="productId" value="${handMade.productId}"/></c:url>">
				                         판매자 신고하기</a>
			            </span>
					</c:otherwise>
				</c:choose>
				
			</td>
   		</tr> <!-- userId = suppId -->
   		
   		<tr>
   			<!-- Description -->
   			<td colspan="2" style="padding: 15px;"><c:out value="${handMade.description}" escapeXml="false" /><br></td>
   		</tr>
   		
   		<tr>
   			<th style="border-right: 1px solid black;"><font color=blue>#</font>관련태그</th>
   			<td>
   			<c:forEach var="tag" items="${tags}">        
	   			<a href='<c:url value="/shop/search/viewItem.do">
	   			<c:param name="tagName" value="${tag.tagName}"/></c:url>'>
	   			#${tag.tagName}
				</a>&nbsp;
			</c:forEach>
   			</td>
   		</tr>
   		<tr>
   		<th style="border-right: 1px solid black;">판매가</th>
   			<td>
   				<c:out value="${handMade.unitCost}" /> 원
   			</td>
   		</tr>
   		
   		<tr>
   			<!-- Quantity -->
   			<th style="border-right: 1px solid black;">수량 </th> 
	   		<td>
	   			<c:if test="${handMade.qty <= 0}">
			        <button type="button" class="btn btn-outline-danger">품절</button>	
			    </c:if> 
			    <c:if test="${handMade.qty > 0}">
			        <font size="2"><fmt:formatNumber value="${handMade.qty}" /> 개 남았습니다.</font>
			    </c:if>
	   		</td>
   		</tr>
   		
   		<tr>
   			<td colspan="2" style="border-bottom: none;">
   			<span>
   				<c:if test="${handMade.qty ne 0}">
	   				<a href="<c:url value="/shop/addItemToCart.do">
						     <c:param name="workingItemId" value="${handMade.itemId}"/>
						     <c:param name="productId" value="${handMade.productId}"/></c:url>">
						 장바구니 추가</a>
				</c:if>
			</span>
   			</td>
   		</tr>
   		
   		<c:if test="${userSession.account.userId eq handMade.userId}">
	   		<tr>
		   		<td colspan="2" style="text-align: right; padding: 0px; font-size: small; border-bottom: none; border-top: 1px solid black;">
				   <a href="<c:url value='/shop/handMade/edit.do'>
				   				<c:param name="itemId" value="${handMade.itemId}" />
				   			</c:url>
				   			">[게시물 수정하기]</a>
				   <a href="<c:url value='/shop/handMade/deleteItem.do'>
				   				<c:param name="productId" value="${handMade.productId}" />
				   				<c:param name="itemId" value="${handMade.itemId}" />
				   			</c:url>
				   			"> [게시물 삭제하기]</a>
				</td>
			 </tr>
		</c:if>
   	</table>
</body>
