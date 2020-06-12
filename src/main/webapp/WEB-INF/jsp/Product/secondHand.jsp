<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		                  <a href="<c:url value='/shop/groupBuying/addItem.do'>
     	 					<c:param name="productId" value="${productId}"/></c:url>">중고거래 게시글 추가하기
      						</a>
					</p>
                  <hr>                                
				<table style="width:70%">
   				<tr><th>itemId</th><th><p style="padding-left:80px">할인</th><th><p style="padding-left:80px">판매가</th></tr>
  				<tbody> 
	    			<c:forEach var="item" items="${itemList.pageList}">
		      			<tr style="height:70px;">
		         		<td style="padding-left:30px">
                                <a href="<c:url value='/shop/secondHand/viewItem.do'>
                                    <c:param name="itemId" value="${item.itemId}"/>
                                         </c:url>">
                                      <font><c:out value="${item.title}"/></font>
                                </a>
                   		</td>
		         		<td style="padding-left:50px"><c:out value="${item.discount}"/></td>       
				 		<td style="padding-left:85px"><c:out value="${item.listPrice}"/></td>              
		
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