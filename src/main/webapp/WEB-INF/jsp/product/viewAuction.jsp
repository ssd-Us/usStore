<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="itemTop.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ê²½ë§¤ ìì¸ íì´ì§Â</title>
</head>
<style type="text/css"> 
	a { text-decoration:none } 
</style> 
<style>
	.right-box {
	  float: right;
	  border-radius: 2em;
	  text-align: center;
	}
	
	span {
		width:10%; 
		height: 10px; 
		border: 1px solid blue;
		border-radius: 2em;
		font-size: small;
		text-align: center;
		padding: 5px;
	}
	
	table {
			border: none;
		 	text-align: center;
			font-size: medium;
			padding: 15px;
	}
	
	 th, td {
				border-bottom: 1px solid black;
			    border-collapse: collapse;
			    text-align: center;
			    font-size: medium;
			    padding: 15px;
	}
	
</style>
<script>
function participation(price, unitCost) {
	var p = parseInt(price);
	var u = parseInt(unitCost);
	
	alert("ìë ¥ ê°ê²© : " + p + "\nìµëê° : " + u);

	if (p > u) {
		var c = confirm("ê²½ë§¤ì ì°¸ì¬íìê² ìµëê¹?");

		if (c) {
			form.submit();
		}
		else {
			alert("ì°¸ì¬ ì·¨ì");
		}
	}
}
</script>
<body>
<table id="main-menu">
  <tr>
    <td><a href='<c:url value="/shop/auction/listItem.do?productId=1"/>'>
        <b><font color="black" size="2">
          &lt;&lt; Go to Auction List</font></b></a>
    </td>
  </tr>
</table>	
	<table style="margin-left: auto; margin-right: auto;">
	<tr>
		<td style="text-align: left; padding: 0px; font-size: small; border-bottom: none;">
		${auction.viewCount}<font color=gray>view</font>
		</td>
		<td style="text-align: right; padding: 0px; font-size: small; border-bottom: none;">
		<a href="
							<c:url value='/addBookmark/${auction.userId}/${auction.itemId}'/>	<!-- ë¡ê·¸ì¸ ì¬ë¶ ë°ì§ê¸° -->
					">[ë¶ë§í¬ ì¶ê°]</a>
		</td>
	
	</tr>
   		<tr>
	   		<th style="border-right: 1px solid black; border-top: 1px solid black;">ì ëª©</th>
	   		<td style="border-top: 1px solid black;">${auction.title}</td>
   		</tr>
   		
   		<tr>
   			<th style="border-right: 1px solid black;">íë§¤ì</th>
   			<td>ê¹ë¬¸ì &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   			<span>
		   			<a href="
							<c:url value='/addFollow/${auction.userId}'/>	<!-- ë¡ê·¸ì¸ ì¬ë¶ ë°ì§ê¸° -->
					">íë¡ì</a>
				</span>
				&nbsp;
				<span>
					<a href="
							<c:url value='/addAccuse/${auction.userId}'/>	<!-- ë¡ê·¸ì¸ ì¬ë¶ ë°ì§ê¸° -->
					">íë§¤ì ì ê³ </a>
				</span>
   			</td>
   		</tr> <!-- userId = suppId -->
   		
   		<tr><td colspan="2" style="padding: 15px;">${auction.description}<br></td></tr>
   		
   		<tr>
   			<th style="border-right: 1px solid black;"><font color=blue>#</font>ê´ë ¨íê·¸</th>
   			<td>
   			<c:forEach var="tag" items="${tags}">        
	   			<a href="
						<c:url value='/searchTag/${gb.itemId}'/>	
					">#${tag.tagName}
				</a>&nbsp;
			</c:forEach>
   			</td>
   		</tr>
   		
   		<tr>
   			<th style="border-right: 1px solid black;"><font color=red>ë§ê° ë ì§</font></th>
   			<td><font color=red>
   				${auction.deadLine}
   			</font></td>
   		</tr>
   		
   		<tr>
   		<th style="border-right: 1px solid black;">ê°ê²©</th>
   			<td>
   				ìì ê°ê²© : ${auction.startPrice} ì<br>
   				ëì°° ê°ê²© : <ins></ins> ${auction.bidPrice}ì&nbsp;
   				<c:set var="state" value="${auction.auctionState}"/>
   				<c:if test="${state eq 0}">
   					<font color=red>(ê²½ë§¤ ì§íì¤)</font> <br><br>
   				</c:if>
   				<c:if test="${state eq 1}">
   					<font color=red>(ê²½ë§¤ ì¢ë£)</font> <br><br>
   				</c:if>
   				íì¬ ìµë ê¸ì¡ : ${auction.unitCost}ì<br>
   			</td>
   		</tr>
   		
   		<tr>
   		<th style="border-right: 1px solid black;">ìë </th> 
   		<td>${auction.qty}</td>
   		</tr>
   		
   		<tr>
   			<td colspan="2" style="border-bottom: none;">
   				<span>
   				<a href="
							<c:url value='/note/${auction.userId}'/>	<!-- ë¡ê·¸ì¸ ì¬ë¶ ë°ì§ê¸° -->
				">ìª½ì§ ë³´ë´ê¸°</a>
				</span><br><br>
				
				<c:if test="${state eq 0}">
   				<form name="form" action="<c:url value='/shop/auction/participateItem.do'/>">
   					<input type="text" id="price" name="price" placeholder="ì°¸ì¬ ê°ê²©ì ìë ¥íì¸ì."/>
				&nbsp;
				<span onclick="participation(price.value, ${auction.unitCost})">
					<!-- ë¡ê·¸ì¸ ì¬ë¶ ë°ì§ê¸° -->
					<a href="#">ê²½ë§¤ ì°¸ì¬</a>
				</span>
				</form>
				</c:if>
   			</td>
   		</tr>
   		
   		<c:if test="${sh.suppId==session.userId}"> <!-- ë¡ê·¸ì¸ì ì¤í -->
   		<tr>
   		<td colspan="2" style="text-align: right; padding: 0px; font-size: small; border-bottom: none; border-top: 1px solid black;">
		   <a href="<c:url value='/shop/auction/updateItem.do'/>">[게시물 수정하기]</a>
		   <a href="<c:url value='/shop/auction/deleteItem.do?itemId=${auction.itemId}'/>"> [게시물 삭제하기]</a>
		   </td>
		 </tr>
		</c:if>
   <!-- íëì urlì ê³µì íë©° íë¼ë¯¸í°ë¡ ìì´ë ê°ì ëê²¨ì¤ì§
   ë¤ê°ì ì»¨í¸ë¡¤ë¬ë¥¼ ê°ì êµ¬íí ì§ ì í´ì¼í¨
   deleteItem ìì´ëë§ ë°ììì íë²ë§ ì­ì í ì ìëê² ìëê³ 
    ì´ì°¨í¼ dbíì´ë¸ì´ ë¤ë¥´ëê¹ deleteë¬¸ì 4ë² ì¨ì¤ì¼í¨  -->
   	</table>
   	<br><br>
	
</body>
</html>