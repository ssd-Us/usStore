<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="itemTop.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<title>경매 리스트 페이지</title>
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
                  ">[경매 참여]
                        </a>
					</p>
                  <hr>
                  <table>
                     <tr>
                        <th>제목</th>
                        <th style="padding-left:120px">가격</th>
                        <th><p style="padding-left:80px">마감 날짜</p></th>
                        <th><p style="padding-left:80px">판매자</p></th>
                        <th><p style="padding-left:80px">낙찰자</p></th>
                        
                        </tr>
                  <tbody>   
                  <c:forEach var="al" items="${auctionList.pageList}" varStatus="status">         
                  <tr style="height:70px;">
                  <td style="padding-left:20px">
                                <a href="<c:url value='/shop/auction/viewItem.do'>
                                    <c:param name="itemId" value="${al.itemId}"/>
                                    <c:param name="productId" value="${productId}"/>
                                         </c:url>">
                                      <font><c:out value="${al.title}"/></font>
                                </a>
                
                   </td>
                   <td style="padding-left:120px">
                   		시작가 : <c:out value="${al.startPrice}"/><br>
                   		<!-- 경매 종료시 낙찰가 보여주기, 경매 진행중일땐 현재 최고 가격 보여주기 -->
                   		<c:set var="state" value="${al.auctionState}"/>
                       	<c:if test="${state eq 0}">
                       		현재 최고가 : <c:out value="${al.unitCost}"/>
                       	</c:if>	
                   		<c:if test="${state eq 1}">
                       		낙찰가 : <c:out value="${al.bidPrice}"/>
                       	</c:if>	
                       	</td>
                  
                   <td style="padding-left:80px">
                   		<c:out value="${al.deadLine}"/>
                   		<c:if test="${state eq 0}">
   					<font color=blue>(경매 진행중)</font><br><br>
   				</c:if>
   				<c:if test="${state eq 1}">
   					<font color=red>(경매 종료)</font><br><br>
   				</c:if>
                   </td>
                       <td style="padding-left:100px"><c:out value="${al.userId}"/></td>   
                       <!-- 경매 종료시 낙찰자 출력, 경매 진행중일땐 None 출력 --> 
                       <c:set var="state" value="${al.auctionState}"/>
                       <c:if test="${state eq 0}">
					   <td style="padding-left:90px"><c:out value="--none--"/></td>
					   </c:if>
   					   <c:if test="${state eq 1}">
					   <td style="padding-left:90px"><c:out value="${(resultBidder.pageList)[status.index].bidder}"/></td>
					   </c:if>
                  </tr>
                  </c:forEach>
                  </tbody>
                  </table>
                  <c:if test="${!auctionList.firstPage}">
									<a href='<c:url value="/shop/auction/listItem2.do">
	           								<c:param name="pageName" value="previous"/></c:url>'>
										<font color="black"><B>&lt;&lt; Prev</B></font>
									</a>
								</c:if>
								<c:if test="${!auctionList.lastPage}">
									<a href='<c:url value="/shop/auction/listItem2.do">/>
	            							 <c:param name="pageName" value="next"/></c:url>'>
										<font color="black"><B>Next &gt;&gt;</B></font>
									</a>
								</c:if>
               </div>
            </div>
         </div>
      </div>
   </form>
</body>
</html>