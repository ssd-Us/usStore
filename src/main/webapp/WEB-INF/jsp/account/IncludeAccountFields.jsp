<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3>
  <font color="darkgreen">Account Information</font>
</h3>

<table class="n13">
  <tr>
    <td>Name:</td>
    <td><form:input path="account.username" />
      <form:errors path="account.username" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Email:</td>
    <td><form:input path="account.email" />
      <form:errors path="account.email" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Phone:</td>
    <td><form:input path="account.phone" /> 
      <form:errors path="account.phone" cssClass="error" /></td>
  </tr>
  <tr>
    <td>University:</td>
    <td><form:input path="account.university" />
      <form:errors path="account.university" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Address 1:</td>
    <td><form:input path="account.address1" />
      <form:errors path="account.address1" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Address 2:</td>
    <td><form:input path="account.address2" />
      <form:errors path="account.address2" cssClass="error" /></td>
  </tr>
  <tr>
    <td>City:</td>
    <td><form:input path="account.city" /> 
      <form:errors path="account.city" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Zip:</td>
    <td><form:input path="account.zip" /> 
      <form:errors path="account.zip" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Country:</td>
    <td><form:input path="account.country" />
      <form:errors path="account.country" cssClass="error" /></td>
  </tr>
</table>