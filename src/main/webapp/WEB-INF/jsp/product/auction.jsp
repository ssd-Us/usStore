<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="itemTop.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ê²½ë§¤ ë¦¬ì¤í¸ íì´ì§</title>
</head>
<body> 
<table id="main-menu">
  <tr>
    <td><a href='<c:url value="/shop/index.do"/>'>
        <b><font color="black" size="2">
          &lt;&lt; Go to Index</font></b></a>
    </td>
  </tr>
</table>
   <form name = "pform" action="" style="position:absolute; left:50%; margin:0 0 0 -500px;">
      <div class="container" >
         <div class="row"  style="display:inline">
            <div style="display:inline;float:left;width:1000px">
               <div style="font-size:15px">
                  <h2>
                     Auction List
                  </h2>
                   <p style="text-align:right;">
		                <a href="<c:url value='/shop/item/addItem.do'>
                           <c:param name="productId" value="${productId}"/></c:url>
                  ">[ê²½ë§¤ ì¶ê°]
                  </a>
					</p>
                  <hr>
                  <table>
                     <tr>
                        <th>ì ëª©</th>
                        <th style="padding-left:150px">ê°ê²©</th>
                        <th><p style="padding-left:100px">íë§¤ì</p></th>
                        <th><p style="padding-left:80px">ëì°°ì</p></th>
                        <th><p style="padding-left:80px">ë§ê° ë ì§</p></th>
                        </tr>
                  <tbody>   
                  <c:forEach var="al" items="${auctionList.pageList}">               
                  <tr style="height:70px;">
                  <td style="padding-left:40px">
                                <a href="<c:url value='/shop/auction/viewItem.do'>
                                    <c:param name="itemId" value="${al.itemId}"/>
                                    <c:param name="productId" value="${productId}"/>
                                         </c:url>">
                                      <font><c:out value="${al.title}"/></font>
                                </a>
                
                   </td>
                   <td style="padding-left:140px">ìì:<c:out value="${al.startPrice}"/><br>ëì°°:<c:out value="${al.bidPrice}"/></td>
                       <td style="padding-left:120px"><c:out value="${al.userId}"/></td>   
                       <td style="padding-left:100px"><c:out value="b"/></td>
                       <td style="padding-left:80px"><c:out value="${al.deadLine}"/></td>
                  </tr>
                  </c:forEach>
                  </tbody>
                  <tr>
							<td>
								<c:if test="${!al.firstPage}">
									<a href='<c:url value="/shop/auction/listItem2.do">
	           								<c:param name="pageName" value="previous"/></c:url>'>
										<font color="black"><B>&lt;&lt; Prev</B></font>
									</a>
								</c:if>
								<c:if test="${!al.lastPage}">
									<a href='<c:url value="/shop/auction/listItem2.do">/>
	            							 <c:param name="pageName" value="next"/></c:url>'>
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
   </form>
</body>
</html>