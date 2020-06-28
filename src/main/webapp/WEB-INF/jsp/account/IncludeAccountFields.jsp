<<<<<<< HEAD
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h5 class="card-title text-center">Account Information</h5>

<div class="form-label-group">
	<form:input path="account.username" id="inputName" class="form-control" />
	<B><form:errors path="account.username" cssClass="error" /></B> <label for="inputName">Name</label>
</div>

<div class="form-label-group">
	<form:input path="account.email" id="inputEmail" class="form-control" />
	<B><form:errors path="account.email" cssClass="error" /></B> <label for="inputEmail">E-Mail</label>
</div>

<div class="form-label-group">
	<form:input path="account.phone" id="inputPhone" class="form-control" />
	<B><form:errors path="account.phone" cssClass="error" /></B> <label for="inputPhone">Phone</label>
</div>

<div class="form-label-group">
	<form:input path="account.university" id="inputUniversity" class="form-control" />
	<B><form:errors path="account.university" cssClass="error" /></B> <label for="inputUniversity">University</label>
</div>

<div class="form-label-group">
	<form:input path="account.address1" id="inputAddress1" class="form-control" />
	<B><form:errors path="account.address1" cssClass="error" /></B> <label for="inputAddress1">Address1</label>
</div>

<div class="form-label-group">
	<form:input path="account.address2" id="inputAddress2" class="form-control" />
	<B><form:errors path="account.address2" cssClass="error" /></B> <label for="inputAddress2">Address2</label>
</div>

<div class="form-label-group">
	<form:input path="account.city" id="inputCity" class="form-control" />
	<B><form:errors path="account.city" cssClass="error" /></B> <label for="inputCity">city</label>
</div>

<div class="form-label-group">
	<form:input path="account.zip" id="inputzip" class="form-control" />
	<B><form:errors path="account.zip" cssClass="error" /></B> <label for="inputzip">Zipcode</label>
</div>

<div class="form-label-group">
	<form:input path="account.country" id="inputCountry" class="form-control" />
	<B><form:errors path="account.country" cssClass="error" /></B> <label for="inputCountry">Country</label>
</div>
=======
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
>>>>>>> develop
