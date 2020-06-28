<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<table>
  <tr style="vertical-align:top">
    <td style="text-align:left;width:20%;">
      <table id="main-menu">
        <tr>
          <td><a href='<c:url value="/shop/index.do"/>'>
            <b><font color="black" size="2">&lt;&lt; Main Menu</font></b></a></td>
        </tr>
      </table>
    </td>
   </tr>
</table>

<table align="center">
  <tr style="vertical-align:top">
    <td style="text-align:center">
      <h2>Shopping Cart</h2>
      <form action='<c:url value="/shop/updateCartQuantities.do"/>' method="post">
        <table id="cart" class="table table-hover">
          <thead>
          <tr bgcolor="#FFFFFF">
            <th scope="col"><b>Item ID</b></th>
            <th scope="col"><b>Product ID</b></th>
            <th scope="col"><b>Description</b></th>
            <th scope="col"><b>In Stock?</b></th>
            <th scope="col"><b>Quantity</b></th>
            <th scope="col"><b>List Price</b></th>
            <th scope="col"><b>Total Cost</b></th>
            <th scope="col">&nbsp;</th>
          </tr>
          </thead>
		  <tbody>
          <c:if test="${cart.numberOfItems == 0}">
            <tr bgcolor="#FFFFFF">
              <th colspan="8"><b>Your cart is empty.</b></th>
            </tr>
          </c:if>

          <c:forEach var="cartItem" items="${cart.cartItemList.pageList}">
            <tr bgcolor="#FFFFFF">
              <th scope="row">
                <a href='<c:url value="/shop/viewItem.do">
                  <c:param name="itemId" value="${cartItem.item.itemId}"/></c:url>'>
                  <c:out value="${cartItem.item.itemId}" />
                </a></th>
              <td><c:out value="${cartItem.item.productId}" /></td>
              <td><c:out value="${cartItem.item.description}" /></td>
              <td style="text-align:center"><c:out value="${cartItem.inStock}" /></td>
              <td style="text-align:center">
                <input type="text" size="3"
                  name='<c:out value="${cartItem.item.itemId}"/>'
                  value='<c:out value="${cartItem.quantity}"/>' /></td>
              <td style="text-align:right"><fmt:formatNumber
                  value="${cartItem.item.listPrice}" pattern="###,###,###원" /></td>
              <td style="text-align:right"><fmt:formatNumber
                  value="${cartItem.totalPrice}" pattern="###,###,###원" /></td>
              <td><a href='<c:url value="/shop/removeItemFromCart.do">
                    <c:param name="workingItemId" value="${cartItem.item.itemId}"/></c:url>'>
                    <img border="0" src="../images/button_remove.gif" alt="" /></a>
              </td>
            </tr>
          </c:forEach>
          <tr bgcolor="#FFFFFF">
            <td colspan="7" align="right">
              <b>Sub Total: <fmt:formatNumber value="${cart.subTotal}" pattern="$#,##0.00" /></b><br><br> 
              <input type="image" src="../images/button_update_cart.gif" name="update" />
            </td>
            <td>&nbsp;</td>
          </tr>
        </tbody>
        </table>
        <div style="text-align:center">
          <c:if test="${!cart.cartItemList.firstPage}">
            <a href='<c:url value="viewCart.do?page=previousCart"/>'>
              <font color="green"><B>&lt;&lt; Prev</B></font></a>
          </c:if>
          <c:if test="${!cart.cartItemList.lastPage}">
            <a href='<c:url value="viewCart.do?page=nextCart"/>'>
              <font color="green"><B>Next &gt;&gt;</B></font></a>
          </c:if>
        </div>
      </form> 
      <c:if test="${cart.numberOfItems > 0}">
        <br />
        <div style="text-align:center">
          <a href='<c:url value="/shop/checkout.do"/>'>
            <img border="0" src="../images/button_checkout.gif" alt=""/></a>
        </div>
      </c:if>
    </td>
    <td style="text-align:right;width:20%;">
      <c:if test="${!empty userSession.account.username}">
        <c:if test="${userSession.account.listOption}">
          <%@ include file="../IncludeMyList.jsp"%>
        </c:if>
      </c:if>
    </td>
  </tr>
</table>
<%@ include file="../IncludeBottom.jsp"%>