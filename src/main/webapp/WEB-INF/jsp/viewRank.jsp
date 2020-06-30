<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="IncludeTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script>
	function getJson(productId) {	//매개변수 전달 시도 
		
		var reqUrl = "../rest/shop/getData.do/" + productId;
		alert("url: " + reqUrl);	//request
	 	$.ajax({			/* Ajax 호출을 위해  JQuery 이용 */
			type: "get",
			url: reqUrl,
			processData: false,
			success: function(responseJson){	// responseJson: JS object parsed from JSON text			
				$("#result").html("Response Body: <div><div>");
				$("#result > div").append("<table><th>랭킹</th><th>글 제목</th><th>조회수</th><br>");
			   	var content = "";
		        $(responseJson).each(function(i, rank){	        	
		          	content += "<tr><td>" + rank.title + "</td><td>" + rank.viewCount + "</td></tr>";
		        });
		     	content += "</table><br>";
				$("#result").append(content);		
		    },
			error: function(){
				alert("ERROR", arguments);
			}
		});
	};
</script>
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
                  <h3>조회수 랭킹</h3><br>
                  
				<input type="button" id="button1" onclick="getJson(3);" value="수공예 판매" />&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" id="button2" onclick="getJson(2);" value="중고거래" />&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" id="button3" onclick="getJson(1);" value="경매" />&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" id="button4" onclick="getJson(0);" value="공동구매" /><br>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<div id="result"></div>
			