<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="itemTop.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ê³µëêµ¬ë§¤ ìì¸íì´ì§</title>
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
	
	span {
		width:10%; 
		height: 10px; 
		border: 1px solid blue;
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
							<c:url value='/addBookmark/${gb.userId}/${gb.itemId}'/>	<!-- ë¡ê·¸ì¸ ì¬ë¶ ë°ì§ê¸° -->
					">[ë¶ë§í¬ ì¶ê°]</a>
		</td>
	
	</tr>
   		<tr>
	   		<th style="border-right: 1px solid black; border-top: 1px solid black;">ì ëª©</th>
	   		<td style="border-top: 1px solid black;">${gb.title}</td>
   		</tr>
   		
   		<tr>
   			<th style="border-right: 1px solid black;">íë§¤ì</th>
   			<td>${gb.userId}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   			<span>
		   			<a href="
							<c:url value='/addFollow/${gb.userId}'/>	<!-- ë¡ê·¸ì¸ ì¬ë¶ ë°ì§ê¸° -->
					">íë¡ì</a>
				</span>
				&nbsp;
				<%@ include file="/WEB-INF/jsp/account/accuseFunction.jsp" %>
   			</td>
   		</tr>
   		
   		<tr><td colspan="2" style="padding: 15px;">${gb.description}<br></td></tr>
   		
   		<tr>
   			<th style="border-right: 1px solid black;"><font color=blue>#</font>ê´ë ¨íê·¸</th>
   			<td>
   			<c:forEach var="tag" items="${tags}">        
	   			<a href="
						<c:url value='/searchTag/${gb.itemId}'/>	<!-- tagê²ì ê²°ê³¼ íì´ì§ë¡ ì´ë -->
					">#${tag.tagName}
				</a>&nbsp;
			</c:forEach>
   			</td>
   		</tr>
   		
   		<tr>
   			<th style="border-right: 1px solid black;"><font color=red>ë§ê° ë ì§</font></th>
   			<td><font color=red>
   				${gb.deadLine}
   			</font></td>
   		</tr>
   		
   		<tr>
   		<th style="border-right: 1px solid black;">íë§¤ê°</th>
   			<td>
   				<del>ì ê° : ${gb.unitCost} ì</del> <br>
   				ê³µëêµ¬ë§¤ê° : ${gb.listPrice}ì&nbsp;<font color=red>-${gb.discount}%</font> <br>
   			</td>
   		</tr>
   		
   		<tr>
   		<th style="border-right: 1px solid black;">ìë </th> 
   		<td>${gb.qty}</td>
   		</tr>
   		
   		<tr>
   			<td colspan="2" style="border-bottom: none;">
   			<span>
		   			<a href="
							<c:url value='/addCart/${gb.itemId}'/>	<!-- ë¡ê·¸ì¸ ì¬ë¶ ë°ì§ê¸° -->
					">ì¥ë°êµ¬ë ì¶ê°</a>
				</span>
				&nbsp;&nbsp;&nbsp;
				<span>
					<a href="
							<c:url value='/order/${gb.itemId}'/>	<!-- ë¡ê·¸ì¸ ì¬ë¶ ë°ì§ê¸° -->
					">ê³µëêµ¬ë§¤ ì°¸ì¬</a>
				</span>
				&nbsp;&nbsp;&nbsp;
				<span>
   				<a href="
							<c:url value='/note/${gb.itemId}'/>	<!-- ë¡ê·¸ì¸ ì¬ë¶ ë°ì§ê¸° -->
				">ìª½ì§ ë³´ë´ê¸°</a>
				</span>
   			
   			</td>
   		</tr>
   		<c:if test="${gb.userId eq suppId}"> <!-- ë¡ê·¸ì¸ì ì¤í -->
	   		<tr>
		   		<td colspan="2" style="text-align: right; padding: 0px; font-size: small; border-bottom: none; border-top: 1px solid black;">
				   <a href="<c:url value='/shop/groupBuying/edit.do'>
				   				<c:param name="itemId" value="${gb.itemId}" />
				   			</c:url>
				   			">[ê²ìë¬¼ ìì íê¸°]</a>
				   <a href="<c:url value='/shop/groupBuying/delete.do'>
				   				<c:param name="itemId" value="${gb.itemId}" />
				   				<c:param name="productId" value="${gb.productId}" />
				   			</c:url>
				   			"> [ê²ìë¬¼ ì­ì íê¸°]</a>
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