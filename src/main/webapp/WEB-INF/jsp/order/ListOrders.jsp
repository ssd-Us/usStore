<%@ include file="../IncludeTop.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script>
	function getOrder(orderId) {
	   var reqUrl = "../rest/order/" + orderId;
	
	   $.ajax({
	       ...
	
	       // RestServiceExample 프로젝트의 js/example.js의 예제와 유사하게 작성
	
	       ...
	
	   });
	
	};

	function(responseJson){ // object parsed from JSON text 
	   $("#detail").html("<ul></ul>");
	   $("#detail > ul").append("<li>Order ID: " + responseJson.orderId + "</li>");
	   ...  

	   var content = "";
	   $(responseJson.lineItems).each(function(i, lineItem){          
	          content += "LineItem " + lineItem.lineNumber + ": " + ...
	   });
	   $("#detail > ul").append ("<li>" + content + "</li>");
	   ...
	}
</script>
<div align="center">
  <p>
    <font size="4"><b>My Orders</b></font>
  </p>
 
  <!-- REST API 내용 부분 -->
  <table>
	<tr>
		<td>
			<div id="detail"></div>
		</td>
	</tr>
  </table>
	
  <table class="n23">
    <tr bgcolor="#CCCCCC">
      <td><b>Order ID</b></td> <td><b>Date</b></td> <td><b>Total Price</b></td>
    </tr>
    <c:forEach var="order" items="${orderList}">
      <tr bgcolor="#FFFF88">
        <td>
          <b><a href='<c:url value="/shop/viewOrder.do">
              <c:param name="orderId" value="${order.orderId}"/></c:url>'>
              <font color="black"><c:out value="${order.orderId}" /></font>
            </a></b></td>
        <td><fmt:formatDate value="${order.orderDate}"
            pattern="yyyy/MM/dd hh:mm:ss" /></td>
        <td onClick="getOrder(${order.orderId});"><fmt:formatNumber value="${order.totalPrice}"
            pattern="###,###,###원" /></td>
      </tr>
    </c:forEach>
  </table>
</div>

<%@ include file="../IncludeBottom.jsp"%>