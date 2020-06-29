<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="itemTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>랭킹 페이지</title>
<style>
	th, td {
      text-align: center;
      height:70px;
      padding-left:43px;
      padding-right:43px;
   }
</style>
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
   <form name = "pform" action="" style="position:absolute; left:42%; margin:0 0 0 -420px;">
      <div class="container" >
         <div class="row"  style="display:inline">
            <div style="display:inline;float:left;">
               <div style="font-size:15px">
                  <h3>조회수 순위</h3><br>
                  
                   <a href="
                     <c:url value='/shop/rank/HmToJson.do'/>   
          		  	">수공예 판매</a><br>
                  
					<a href="javascript:showSH();">중고거래</a><br>
                  
                  <a href="javascript:showAT();">경매</a><br>
                  
                  <a href="javascript:showGB();">공동구매</a><br> 

               </div>
            </div>
         </div>
      </div>
      <br><br>
      
      
   </form>
  
</body>
</html>