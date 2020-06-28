<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="itemTop.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<title>검색 결과 페이지</title>
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
<form name = "form" action="" style="position:absolute; left:50%; margin:0 0 0 -500px;">
      <div class="container" >
         <div class="row"  style="display:inline">
            <div style="display:inline;float:left;width:1000px">
               <div style="font-size:15px">
                  <h2>
                     Search Results By '<c:out value="${searchWord}"/>'
                  </h2>
                  <hr>
                  <table>
                     <tr>
                        <th>tagId</th>
                        <th style="padding-left:120px">tagName</th>
                        <th style="padding-left:80px">itemId</th>
                     </tr>
                  <tbody>   
                  <c:forEach var="tl" items="${tagList}" varStatus="status">         
                  <tr style="height:70px;">
                  <td style="padding-left:20px">
				  	<c:out value="${tl.tagId}"/>
                  </td>
                  <td style="padding-left:120px">
                   	<c:out value="${tl.tagName}"/><br>
                  </td>
                  
                  <!-- product id에 따라서 viewItem 페이지로 넘어가게 수정해야 한다. -->
				  <td style="padding-left:80px">
					<a href="<c:url value='/shop/search/selectItem.do'>
                    <c:param name="itemId" value="${tl.itemId}"/>
                    </c:url>">
                    	<font><c:out value="${tl.itemId}"/></font>
                    </a>
				  </td>   
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