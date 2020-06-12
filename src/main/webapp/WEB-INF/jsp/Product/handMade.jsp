<%@ include file="ItemTop.jsp"%>

<table id="main-menu">
  <tr>
    <td><a href='<c:url value="/shop/index.do"/>'>
        <b><font color="black" size="2">
          &lt;&lt; Go to Index</font></b></a>
    </td>
  </tr>
</table>

<div align="center">
  <b><font size="4">HandMade</font></b>
  <table class="n23">
    <tr bgcolor="#CCCCCC">
      <td><b>Item ID</b></td>
      <td><b>Product ID</b></td>
      <td><b>Title</b></td>
      <td><b>Description</b></td>
      <td><b>List Price</b></td>
      <td><b>UnitCost</b></td>
      <td><b>Quantity</b></td>
      <td><b>ViewCount</b></td>
      <td>&nbsp;</td>
    </tr>
    <c:forEach var="item" items="${itemList.pageList}">
      <tr bgcolor="#FFFF88">
        <td><b> 
          <a href='<c:url value="/shop/handMade/viewItem.do">
            <c:param name="itemId" value="${item.itemId}"/></c:url>'>
              <c:out value="${item.itemId}" />
          </a></b></td>
        <td><c:out value="${item.productId}" /></td>
        <td><c:out value="${item.title}" /></td>
        <td><c:out value="${item.description}" /> </td>
        <td><fmt:formatNumber value="${item.listPrice}" pattern="$#,##0.00" /></td>
        <td><fmt:formatNumber value="${item.unitCost}" pattern="$#,##0.00" /></td>
        <td><c:out value="${item.qty}" /> </td>
        <td><c:out value="${item.viewCount}" /> </td>      
        <td>
          <a href='<c:url value="/shop/addItemToCart.do">
            <c:param name="workingItemId" value="${item.itemId}"/></c:url>'>
              <img border="0" src="../../images/button_add_to_cart.gif" alt="" />
          </a></td>
      </tr>
    </c:forEach>
    <tr>
      <td>
        <c:if test="${!itemList.firstPage}">
          <a href="?page=previous"><font color="white"><B>&lt;&lt; Prev</B></font></a>
        </c:if> 
        <c:if test="${!itemList.lastPage}">
          <a href="?page=next"><font color="white"><B>Next &gt;&gt;</B></font></a>
        </c:if>
      </td>
    </tr>
  </table>
</div>

<%@ include file="ItemBottom.jsp"%>