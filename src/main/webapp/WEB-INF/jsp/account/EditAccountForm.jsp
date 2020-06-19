<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="accountTop.jsp"%>

  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
        <div class="card card-signin flex-row my-5">
          <div class="card-img-left d-none d-md-flex">
             <!-- Background image for card set in CSS! -->
          </div>
          <div class="card-body">
            <h5 class="card-title text-center">Register</h5>
            <form:form class="form-signin" modelAttribute="accountForm" method="post">
 			<form:errors cssClass="error" /> 			
              <div class="form-label-group">
                <c:if test="${accountForm.newAccount}">
	              <form:input path="account.userId" class="form-control"/>
	              <B><form:errors class="form-control" path="account.userId" id="inputUserId" cssClass="error" /></B>
	             
	            </c:if> 
	            <c:if test="${!accountForm.newAccount}">
	              <form:input path="account.userId" class="form-control" value="${accountForm.account.userId}" disabled="true"/>
	            </c:if>
                <label for="inputUserame">USER ID</label>
               
              </div>
              
              <div class="form-label-group">
                <form:password path="account.password" id="inputPassword" class="form-control"/>
                <B><form:errors path="account.password" cssClass="error" /></B>
                <label for="inputPassword">Password</label>
              </div>
              
              <div class="form-label-group">
                <form:password path="repeatedPassword" id="inputConfirmPassword" class="form-control"/>
                <B><form:errors path="repeatedPassword" cssClass="error" /></B>
                <label for="inputConfirmPassword">Confirm password</label>
              </div>
              
			  <hr class="my-4">
			  <%@ include file="IncludeAccountFields.jsp"%>
			  <hr class="my-4">
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
             </form:form>
             <%--   <h3><b><a href='<c:url value="/shop/listOrders.do"/>'>My Orders</a></b></h3> --%>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>

<!-- <div align="center"> -->
<%-- <form:form modelAttribute="accountForm" method="post"> --%>
<%--   <form:errors cssClass="error" /> <br><br> --%>
  
<!--   <table id="account"> -->
<!--     <tr> -->
<!--       <td> -->
<!--         <h3><font color="darkgreen">User Information</font></h3> -->
<!--         <table class="n13"> -->
<!--           <tr> -->
<!--             <td>ID:</td> -->
<!--             <td> -->
<%--             <c:if test="${accountForm.newAccount}"> --%>
<%--               <form:input path="account.userId" /> --%>
<%--               <B><form:errors path="account.userId" cssClass="error" /></B> --%>
<%--             </c:if>  --%>
<%--             <c:if test="${!accountForm.newAccount}"> --%>
<%--               <c:out value="${accountForm.account.userId}" /> --%>
<%--             </c:if> --%>
<!--             </td> -->
<!--           </tr> -->
<!--           <tr> -->
<!--             <td>New password:</td> -->
<!--             <td> -->
<%--               <form:password path="account.password" />  --%>
<%--               <B><form:errors path="account.password" cssClass="error" /></B></td> --%>
<!--           </tr> -->
<!--           <tr> -->
<!--             <td>Repeat password:</td> -->
<!--             <td> -->
<%--               <form:password path="repeatedPassword" />  --%>
<%--               <B><form:errors path="repeatedPassword" cssClass="error" /></B></td> --%>
<!--           </tr> -->
<!--         </table>  -->
        
<%--         <%@ include file="IncludeAccountFields.jsp"%> --%>

<!--       </td> -->
<!--     </tr> -->
<!--   </table> -->
<!--   <br /> -->
<!--     <input type="image" src="../../images/button_submit.gif" name="submit" -->
<!--       value="Save Account Information" /> -->
<%-- </form:form> --%>
<!-- <p></p> -->

<!--   </div> -->