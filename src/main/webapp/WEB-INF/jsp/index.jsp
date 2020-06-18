<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="IncludeTop.jsp" %>

<table style="border:none;border-collapse:collapse;width:100%">
  <tr>
    <td style="text-align:left;vertical-align:top;width:100%">
      <table style="border:none;border-collapse:collapse;width:80%">
        <tr>
          <td valign="top">                    
            <!-- SIDEBAR -->
            <table id="index">
              <tr>
                <td>
                <c:if test="${!empty userSession.account}">
			       <b><i><font size="4" color="RED">Welcome ${userSession.account.userId}!</font></i></b>
                </c:if>&nbsp; 
                </td>
              </tr>
              <tr>
                <td>
                	<hr>
	                <a href="<c:url value="/shop/viewCategory.do?catId=0"/>"> <!-- Product -->
	                <p>Product</p>
	                <hr>
	                <ul>
		               	<li><a href="<c:url value="/shop/groupBuying/listItem.do?productId=0"/>"><p>GroupBuying</p></li>
		                <li><a href="<c:url value="/shop/auction/listItem.do?productId=1"/>"><p>Auction</p></li>
		                <li><a href="<c:url value="/shop/secondHand/listItem.do?productId=2"/>"><p>SecondHand</p></li>
		                <li><a href="<c:url value="/shop/handMade/listItem.do?productId=3"/>"><p>HandMade</p></li>
	                </ul>
                </td>
              </tr>
              <tr>
                <td>
                	<hr>
                    <a href="<c:url value="/shop/viewCategory.do?catId=1"/>"> <!-- Event -->
                    <p>Event</p>
                    <hr>
                    <ul>
                    	<li><a href="<c:url value="/shop/viewEvent.do?catId=2"/>"><p>Quiz</p></li>
                    	<li><a href="<c:url value="/shop/viewEvent.do?catId=3"/>"><p>AttendanceCheck</p></li>
                    </ul>
                </td>
              </tr>
            </table>
          </td>
          <td style="text-align:center;background-color:white;height:300;width:100%">
            <!-- MAIN IMAGE -->
            <img src="../images/open1.jpg" style="float:center;width:600;height:355;border:0;" />
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>

<%@ include file="IncludeBanner.jsp" %>

<%@ include file="IncludeBottom.jsp" %>