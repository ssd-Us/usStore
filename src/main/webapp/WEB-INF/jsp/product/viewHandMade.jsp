<%@ include file="itemTop.jsp"%>

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
<p>
<div align="center">
  <table id="item">
    <tr>
      <td bgcolor="#FFFFFF">
        <c:out value="${handMade.description}" escapeXml="false" /></td>
    </tr>
    <tr>
      <td width="100%" bgcolor="#CCCCCC"><b><c:out value="${handMade.itemId}" /></b></td>
    </tr>
    <tr>
      <td><b><font size="4"> 
        <c:out value="${handMade.title}" />
        </font></b></td>
    </tr>
    <tr>
      <td><font size="3"><i><c:out value="${handMade.title}" /></i></font></td>
    </tr>
    <tr>
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
      <td><fmt:formatNumber value="${handMade.listPrice}" pattern="$#,##0.00" /></td>
    </tr>
    <tr>
      <td>
        <a href='<c:url value="/shop/addItemToCart.do">
          <c:param name="workingItemId" value="${handMade.itemId}"/></c:url>'>
          <img border="0" src="../images/button_add_to_cart.gif" alt="" /></a>
      </td>
    </tr>
  </table>
</div>

<%@ include file="itemBottom.jsp"%>