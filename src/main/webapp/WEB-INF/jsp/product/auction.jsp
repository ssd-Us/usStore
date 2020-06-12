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
						">공동구매 게시글 추가하기
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
                  <td style="padding-left:30px">
                                <a href="<c:url value='/shop/auction/viewItem.do'>
                                    <c:param name="itemId" value="${al.itemId}"/>
                                         </c:url>">
                                      <font><c:out value="${al.title}"/></font>
                                </a>
                
                   </td>
                   <td style="padding-left:50px"><c:out value="시작: ${al.startPrice}"/><br><c:out value="낙찰: ${al.bidPrice}"/></td>
                       <td style="padding-left:85px"><c:out value="${al.userId}"/></td>   
                       <td style="padding-left:70px"><c:out value="b"/></td>
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

<!-- 
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
                  <hr>
                  <table>
                     <tr>
                        <th>상품</th>
                        	<th style="padding-left:50px">가격</th>
                            <th><p style="padding-left:75px">판매자</p></th>
                            <th><p style="padding-left:60px">낙찰자</p></th>
                            <th><p style="padding-left:80px">남은시간</p></th>
                        </tr>
                  <tbody>                   
                  <tr style="height:70px;">
                  <td style="padding-left:30px">
                                <a href="<c:url value='/shop/productDetail'>
                                	<c:param name="productId" value="3"/>
                                    <c:param name="itemId" value="${al.itemId}"/>
                                         </c:url>">
                                      <font><c:out value="${al.title}"/></font>
                                </a>
                
                   </td>
                   <td style="padding-left:50px"><c:out value="시작: 10,0000"/><br><c:out value="낙찰: 70,0000"/></td>
                       <td style="padding-left:85px"><c:out value="${al.suppId}"/></td>   
                       <td style="padding-left:70px"><c:out value="이지은"/></td>
                       <td style="padding-left:90px"><c:out value="경매 마감"/><br><c:out value="(00:00)"/></td>
                  </tr>
                  </tbody>
                  </table>
               </div>
            </div>
         </div>
      </div>
   </form>
</body>
</html>
 -->