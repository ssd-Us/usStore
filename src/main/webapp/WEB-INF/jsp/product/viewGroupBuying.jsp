<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="itemTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>공동구매 상세페이지</title>
</head>
<style type="text/css"> 
   a { text-decoration:none } 
</style> 
<style>

   table#detail {
      border: none;
      text-align: center;
      font-size: medium;
      padding: 15px;
   }
   
   span#blue {
      width:10%; 
      height: 10px; 
      border: 1px solid blue;
      border-radius: 2em;
      font-size: small;
      text-align: center;
      padding: 5px;
   }
   
   span#red {
      width:10%; 
      height: 10px; 
      border: 1px solid red;
      border-radius: 2em;
      font-size: small;
      text-align: center;
      padding: 5px;
   }
   
   span#black {
      width:10%; 
      height: 10px; 
      border: 1px solid black;
      border-radius: 2em;
      font-size: small;
      text-align: center;
      padding: 5px;
   }
   
    th, td {
            border-bottom: 1px solid black;
             border-collapse: collapse;
             text-align: center;
             font-size: medium;
             padding: 15px;
   }
   
</style>
<body>
<table id="main-menu">
  <tr>
    <td>
       <a href='<c:url value="/shop/index.do"/>'>
           <b><font color="black" size="2">&lt;&lt; Go to Index</font></b>
       </a><br><br>
       <a href='<c:url value="/shop/groupBuying/listItem.do">
                <c:param name="productId" value="${gb.productId}" />
             </c:url>'>
           <b><font color="black" size="2">&lt;&lt; Go to List</font></b>
       </a><br>
    </td>
  </tr>
</table> 
   <table id="detail" style="margin-left: auto; margin-right: auto;">
   <tr>
      <td style="text-align: left; padding: 0px; font-size: small; border-bottom: none;">
      ${gb.viewCount}<font color=gray>view</font>
      </td>
      <td style="text-align: right; padding: 0px; font-size: small; border-bottom: none;">
      <a href="
                     <c:url value='/shop/groupBuying/addBookmark'>   <!-- 로그인 여부 따지기 -->
                        <c:param name="userId" value="${gb.userId}" />
                        <c:param name="itemId" value="${gb.itemId}" />
                     </c:url>
               ">[북마크 추가]</a>
      </td>
   
   </tr>
         <tr>
            <th style="border-right: 1px solid black; border-top: 1px solid black;">제목</th>
            <td style="border-top: 1px solid black;">${gb.title}
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <c:choose>
            <c:when test="${gb.state == 1}"><span id="black">공동구매 마감</span></c:when>
            <c:otherwise><span id="red"><font color="red">공동구매 진행중</font></span></c:otherwise>
         </c:choose>
            
            </td>
         </tr>
         
         <tr>
            <th style="border-right: 1px solid black;">판매자</th>
            <td>${gb.userId}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <span id="blue">
                  <a href="
                     <c:url value='/addFollow/${gb.userId}'/>   <!-- 로그인 여부 따지기 -->
               ">팔로잉</a>
            </span>
            &nbsp;
            <span id="blue">
               <c:choose>
                     <c:when test="${! empty userSession.account.userId}">
                     <%@ include file="/WEB-INF/jsp/account/accuseFunction.jsp" %>
                  </c:when>
                  <c:otherwise>
                  
                     <a href="<c:url value='/addAccuseNoLogin.do'>
                             <c:param name="itemId" value="${gb.itemId}"/>
                               <c:param name="productId" value="${gb.productId}"/></c:url>">
                               판매자 신고하기
                            </a>
                  
                  </c:otherwise>
               </c:choose>
            </span>
            </td>
         </tr>
         
         <tr><td colspan="2" style="padding: 15px;">${gb.description}<br></td></tr>
         
         <tr>
            <th style="border-right: 1px solid black;"><font color=blue>#</font>관련태그</th>
            <td>
            <c:forEach var="tag" items="${tags}">        
	   			<a href='<c:url value="/shop/search/viewItem.do">
	   			<c:param name="tagName" value="${tag.tagName}"/></c:url>'>
	   			#${tag.tagName}
				</a>&nbsp;
			</c:forEach>
            </td>
         </tr>
         
         <tr>
            <th style="border-right: 1px solid black;"><font color=red>마감기한</font></th>
            <td><font color=red>
               ${gb.deadLine}
            </font></td>
         </tr>
         
         <tr>
         <th style="border-right: 1px solid black;">할인율</th>
            <td>
               <p><del>정가 : ${gb.listPrice}원</del></p>
               할인가 : ${gb.unitCost}원&nbsp;<font color=red>-${gb.discount}%</font> <br>
            </td>
         </tr>
         
         <tr>
         <th style="border-right: 1px solid black;">수량 </th> 
         <td>${gb.qty}</td>
         </tr>
         
         <tr>
            <td colspan="2" style="border-bottom: none;">
               <span id="blue">
   				<a href="<c:url value="/shop/addItemToCart.do">
					     <c:param name="workingItemId" value="${gb.itemId}"/>
					     <c:param name="productId" value="${gb.productId}"/></c:url>">
					 장바구니 추가</a>
            </span>
            &nbsp;&nbsp;&nbsp;
            <span id="blue">
               <a href="
                     <c:url value='/shop/groupBuying/joint.do'>
                        <c:param name="workingItemId" value="${gb.itemId}" />
                        <c:param name="productId" value="${gb.productId}" />
                     </c:url>
               ">공동구매 참여하기</a>
            </span>
            &nbsp;&nbsp;&nbsp;
            <span id="blue">
               <a href="
                     <c:url value='/note/${gb.itemId}'/>   
            ">쪽지 보내기</a>
            </span>
            
            </td>
         </tr>
         <c:if test="${gb.userId eq userSession.account.userId}"> <!-- ë¡ ê·¸ì ¸ì   ì ¤í   -->
            <tr>
               <td colspan="2" style="text-align: right; padding: 0px; font-size: small; border-bottom: none; border-top: 1px solid black;">
               <a href="<c:url value='/shop/groupBuying/edit.do'>
                           <c:param name="itemId" value="${gb.itemId}" />
                        </c:url>
                        ">[게시물 수정하기]</a>
               <a href="<c:url value='/shop/groupBuying/delete.do'>
                           <c:param name="itemId" value="${gb.itemId}" />
                           <c:param name="productId" value="${gb.productId}" />
                        </c:url>
                        "> [게시물 삭제하기]</a>
            </td>
          </tr>
      </c:if>
<!--* 현재 로그인 user가 글 작성자 일때만 수정/삭제 버튼이 보임 
   * 작성자 정보는 controller에서 model(db에서 suppId찾아옴)로 넘겨줌
   * model로 넘어온 suppId와 세션의 로그인Id를 비교함 
   * 세션에 로그인 정보가 없으면, 즉 null이어도 수정/삭제 안보여줌-->
      </table>
      <br><br>
   
</body>
</html>