<%@ include file="itemTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공동구매 리스트 페이지</title>
<style>
			th, td {
			    text-align: center;
			    height:70px;
			    padding-left:50px;
			    padding-right:50px;
			}
</style>
</head>
<body>	  
   <form name = "pform" action="" style="position:absolute; left:45%; margin:0 0 0 -420px;">
      <div class="container" >
         <div class="row"  style="display:inline">
            <div style="display:inline;float:left;">
               <div style="font-size:15px">
                  <h2>
                     	GroupBuying List
                  </h2>
                  <p style="text-align:right;">
		                <a href="<c:url value='/shop/groupBuying/addItem.do'>
		               		<c:param name="productId" value="${productId}"/></c:url>
						">공동구매 물품 판매하기
						</a>
					</p>	<!-- 로그인 여부 인터셉터로 이동 -->
                  <hr>
                  <table>
                     <tr>
                        <th>글 제목</th>
                        <th>가격</th>
                        <th>할인율</th>
                        <th>수량</th>
                        <th>마감 날짜</th>
                     </tr>
                     
                  <tbody>    
                  
		
   				<c:forEach var="gb" items="${groupBuyingList}">         
                  <tr style="height:70px;">
                  
                  <td>
                                <a href="<c:url value='/shop/productDetail'>
                                	<c:param name="productId" value="${gb.productId}"/>
                                    <c:param name="itemId" value="${gb.itemId}"/>
                                         </c:url>">
                                      <font>${gb.title}</font>
                                </a>
                
                   </td>
                   <td><del>정가 &nbsp;&nbsp;${gb.unitCost}원</del><br>할인가 &nbsp;${gb.listPrice}원</td>
                   <td>${gb.discount}%</td>
                   <td>${gb.qty}</td>
                   <td>${gb.deadLine}<br></td>
                       
                  </tr>
                  </c:forEach>
                  </tbody>
                  </table>
               </div>
            </div>
         </div>
      </div>
      <br><br>
      
      
   </form>
  
</body>
</html>