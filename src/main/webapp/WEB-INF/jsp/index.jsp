<%@ include file="IncludeTop.jsp" %>

<table style="border:none;border-collapse:collapse;width:100%">
  <tr>
    <td style="text-align:left;vertical-align:top;width:100%">
      <table style="border:none;border-collapse:collapse;width:80%">
        <tr>
          <td valign="top">                    
            <!-- SIDEBAR -->
            <table id="index">
              <tr>
                <td>
                <!--<c:if test="${!empty userSession.account}">
			       <b><i><font size="4" color="RED">Welcome ${userSession.account.firstName}!</font></i></b>
                </c:if>&nbsp;  -->
                </td>
              </tr>
              <tr>
                <td>
                  <a href="<c:url value="/shop/viewCategory.do?catId=0"/>"> <!-- Product -->
                  <p>Product</p>
                </td>
                <td>
	                <select>
	                  	<option value="0"><a href="<c:url value="/shop/viewProduct.do?productId=0"/>">스토어</a></option>
	                  	<option value="1"><a href="<c:url value="/shop/viewProduct.do?productId=1"/>">공동구매</a></option>
	                  	<option value="2"><a href="<c:url value="/shop/viewProduct.do?productId=2"/>">중고거래</a></option>
	                  	<option value="3"><a href="<c:url value="/shop/viewProduct.do?productId=3"/>">경매</a></option>
	                </select>
                </td>
              </tr>
              <tr>
                <td>
                    <a href="<c:url value="/shop/viewCategory.do?catId=1"/>"> <!-- Event -->
                     <p>Event</p>
                  	<select>
                  		<option value="2"><a href="<c:url value="/shop/viewEvent.do?catId=2"/>">퀴즈</option>
                  		<option value="3"><a href="<c:url value="/shop/viewEvent.do?catId=3"/>">출석체크</option>
                  	</select>
                </td>
              </tr>
<!--               <tr> -->
<!--                 <td> -->
<%--                   <a href="<c:url value="/shop/viewCategory.do?categoryId=DOGS"/>"> --%>
<!--                     <img border="0" src="../images/dogs_icon.gif" /></a> -->
<!--                 </td> -->
<!--               </tr> -->
<!--               <tr> -->
<!--                 <td> -->
<%--                   <a href="<c:url value="/shop/viewCategory.do?categoryId=CATS"/>"> --%>
<!--                     <img border="0" src="../images/cats_icon.gif" /></a> -->
<!--                 </td> -->
<!--               </tr> -->
<!--               <tr> -->
<!--                 <td> -->
<%--                   <a href="<c:url value="/shop/viewCategory.do?categoryId=REPTILES"/>"> --%>
<!--                     <img border="0" src="../images/reptiles_icon.gif" /></a> -->
<!--                 </td> -->
<!--               </tr> -->
<!--               <tr> -->
<!--                 <td> -->
<%--                   <a href="<c:url value="/shop/viewCategory.do?categoryId=BIRDS"/>"> --%>
<!--                     <img border="0" src="../images/birds_icon.gif" /></a> -->
<!--                 </td> -->
<!--               </tr> -->
            </table>
          </td>
          <td style="text-align:center;background-color:white;height:300;width:100%">
            <!-- MAIN IMAGE -->
            <map name="estoremap">
              <area alt="Birds" coords="72,2,280,250" href="viewCategory.do?categoryId=BIRDS" shape="RECT" />
<!--               <area alt="Fish" coords="2,180,72,250" href="viewCategory.do?categoryId=FISH" shape="RECT" /> -->
<!--               <area alt="Dogs" coords="60,250,130,320" href="viewCategory.do?categoryId=DOGS" shape="RECT" /> -->
<!--               <area alt="Reptiles" coords="140,270,210,340" href="viewCategory.do?categoryId=REPTILES" shape="RECT" /> -->
<!--               <area alt="Cats" coords="225,240,295,310" href="viewCategory.do?categoryId=CATS" shape="RECT" /> -->
<!--               <area alt="Birds" coords="280,180,350,250" href="viewCategory.do?categoryId=BIRDS" shape="RECT" /> -->
            </map>
            <img src="../images/splash.gif" usemap="#estoremap" style="float:center;width:350;height:355;border:0;" />
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>

<%@ include file="IncludeBanner.jsp" %>

<%@ include file="IncludeBottom.jsp" %>