<%@ include file="itemTop.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경매 리스트 페이지</title>
</head>
<body> 
   <form name = "pform" action="" style="position:absolute; left:50%; margin:0 0 0 -420px;">
      <div class="container" >
         <div class="row"  style="display:inline">
            <div style="display:inline;float:left;width:800px">
               <div style="font-size:15px">
                  <h2>
                     Auction List
                  </h2>
                   <p style="text-align:right;">
		                <a href="<c:url value='/shop/auction/addItem.do'>
		               		<c:param name="productId" value="${productId}"/></c:url>
						">[경매 추가]
						</a>
					</p>
                  <hr>
                  <table>
                     <tr>
                        <th>제목</th>
                        <th style="padding-left:50px">가격</th>
                        <th><p style="padding-left:75px">판매자</p></th>
                        <th><p style="padding-left:60px">낙찰자</p></th>
                        <th><p style="padding-left:80px">마감일</p></th>
                        </tr>
                  <tbody>   
                  <c:forEach var="al" items="${auctionList}">                
                  <tr style="height:70px;">
                  <td style="padding-left:15px">
                                <a href="<c:url value='/shop/auction/viewItem.do'>
                                    <c:param name="itemId" value="${al.itemId}"/>
                                    <c:param name="productId" value="${productId}"/>
                                         </c:url>">
                                      <font><c:out value="${al.title}"/></font>
                                </a>
                
                   </td>
                   <td style="padding-left:30px">시작:<c:out value="${al.startPrice}"/><br>낙찰:<c:out value="${al.bidPrice}"/></td>
                       <td style="padding-left:95px"><c:out value="${al.userId}"/></td>   
                       <td style="padding-left:82px"><c:out value="b"/></td>
                       <td style="padding-left:90px"><fmt:formatDate value="${al.deadLine}" pattern="yyyy년 MM월 dd일  hh시 mm분 ss초" /></td>
                  </tr>
                  </c:forEach>
                  </tbody>
                  </table>
               </div>
            </div>
         </div>
      </div>
   </form>
</body>
</html>