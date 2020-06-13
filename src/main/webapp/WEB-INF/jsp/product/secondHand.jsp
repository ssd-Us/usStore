<%-- <%@ page contentType="text/html; charset=UTF-8" %> --%>
<%@ include file="itemTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 게시물 목록</title>
</head>
<body>
   <!-- db에서 select 결과 보여주는 페이지 -->
   <form name = "pform" action="" style="position:absolute; left:50%; margin:0 0 0 -420px;">
      <div class="container" >
         <div class="row"  style="display:inline">
            <div style="display:inline;float:left;width:800px">
               <div style="font-size:15px">
                  <h2>
                     SecondHand List
                  </h2>
                   <p style="text-align:right;">
		                  <a href="<c:url value='/shop/groupBuying/addItem.do'> <!-- 이거 경로 바꿔달라고 하기  -->
     	 					<c:param name="productId" value="${productId}"/></c:url>">중고거래 게시글 추가하기
      						</a>
					</p>
                  <hr>                                
				<table style="width:70%">
   				<tr><th><p style="padding-left:30px">TITLE</th><th><p style="padding-left:120px">DISCOUNT</th>
   				<th><p style="padding-left:77px">&nbsp;&nbsp;&nbsp;&nbsp;정가</th>
   				<th><p style="padding-left:125px">판매가</th></tr>
  				<tbody> 
	    			<c:forEach var="item" items="${itemList.pageList}">
		      			<tr style="height:70px;">
		         		<td>
                                <a href="<c:url value='/shop/secondHand/viewItem.do'>
                                    <c:param name="itemId" value="${item.itemId}"/>
                                         </c:url>">
                                      <font style="padding-left:30px"><c:out value="${item.title}"/></font>
                                </a>
                   		</td>
		         		<c:choose>
	   					 	<c:when test="${item.discount eq 1}">
							        <td style="padding-left:120px"><c:out value="에눌 가능" /></td> 
							</c:when>
							<c:otherwise>
							 		<td style="padding-left:120px"> <c:out value="에눌 불가능" /></td> 
						    </c:otherwise>
						</c:choose>
				 		<td style="padding-left:100px"><c:out value="${item.unitCost}"/>원</td>              
						<td style="padding-left:130px"><c:out value="${item.listPrice}"/>원</td>
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