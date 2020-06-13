<%@ include file="itemTop.jsp"%>
<style>
	th, td {
		text-align: center;
		height: 70px;
		padding-left: 50px;
		padding-right: 50px;
	}
</style>
<table id="main-menu">
  <tr>
    <td><a href='<c:url value="/shop/index.do"/>'>
        <b><font color="black" size="2">
          &lt;&lt; Go to Index</font></b></a>
    </td>
  </tr>
</table>

<form name="pform" action="" style="position: absolute; left: 45%; margin: 0 0 0 -420px;">
	<div class="container">
		<div class="row" style="display: inline">
			<div style="display: inline; float: left;">
				<div style="font-size: 15px">
					<h2>HandMade List</h2>
					<p style="text-align: right;">
						<a href="<c:url value='/shop/handMade/addItem.do'>
		               		<c:param name="productId" value="${productId}"/></c:url>">
		               		수공예  판매하기 </a>
					</p>
					<!-- 로그인 여부 인터셉터로 이동 -->
					<hr>
					<table>
						<tr>
							<th>제품명</th>
							<th>제목</th>
							<th>가격</th>
							<th>판매자</th>
							<th>&nbsp;</th>
						</tr>
						<tbody>
							<c:forEach var="item" items="${itemList.pageList}">
								<tr style="height: 70px;">
									<td>${item.itemId}</td>
									<td>
										<a href="<c:url value='/shop/handMade/viewItem.do'>
			                               			<c:param name="productId" value="${item.productId}"/>
				                                	<c:param name="itemId" value="${item.itemId}"/>
	                                			</c:url>"> <font>${item.title}</font>
										</a>
									</td>
									<td>${item.listPrice}원</td>
									<td>${item.userId}</td>
									<td><a href='<c:url value="/shop/addItemToCart.do">
					            				<c:param name="workingItemId" value="${item.itemId}"/></c:url>'>
					              		<img border="0" src="../../images/button_add_to_cart.gif" alt="" /></a></td>
								</tr>
							</c:forEach>
						</tbody>
						<tr>
							<td>
								<c:if test="${!itemList.firstPage}">
									<a href='<c:url value="/shop/handMade/listItem2.do">
	           								 <c:param name="page" value="previous"/></c:url>'>
										<font color="black"><B>&lt;&lt; Prev</B></font>
									</a>
								</c:if>
								<c:if test="${!itemList.lastPage}">
									<a href='<c:url value="/shop/handMade/listItem2.do">
	            							 <c:param name="page" value="next"/></c:url>'>
										<font color="black"><B>Next &gt;&gt;</B></font>
									</a>
								</c:if>
							</td>
						</tr>

					</table>
				</div>
			</div>
		</div>
	</div>
<br>
<br>
</form>

<%@ include file="itemBottom.jsp"%>