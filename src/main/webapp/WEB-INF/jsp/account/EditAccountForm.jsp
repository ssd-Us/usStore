<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="accountTop.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
<form:form modelAttribute="accountForm" method="post">
  <form:errors cssClass="error" /> <br><br>
  
  <table id="account">
    <tr>
      <td>
        <h3><font color="darkgreen">User Information</font></h3>
        <table class="n13">
          <tr>
            <td>ID:</td>
            <td>
            <c:if test="${accountForm.newAccount}">
              <form:input path="account.userId" />
              <B><form:errors path="account.userId" cssClass="error" /></B>
            </c:if> 
            <c:if test="${!accountForm.newAccount}">
              <c:out value="${accountForm.account.userId}" />
            </c:if>
            </td>
          </tr>
          <tr>
            <td>New password:</td>
            <td>
              <form:password path="account.password" /> 
              <B><form:errors path="account.password" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>Repeat password:</td>
            <td>
              <form:password path="repeatedPassword" /> 
              <B><form:errors path="repeatedPassword" cssClass="error" /></B></td>
          </tr>
        </table> 
        
        <%@ include file="IncludeAccountFields.jsp"%>

      </td>
    </tr>
  </table>
  <br />
    <input type="image" src="../../images/button_submit.gif" name="submit"
      value="Save Account Information" />
</form:form>
<p></p>
  <h3><b><a href='<c:url value="/shop/listOrders.do"/>'>My Orders</a></b></h3>
  
</div>