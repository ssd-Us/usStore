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
	            <form:input path="account.userId" class="form-control" value="${accountForm.account.userId}" disabled="true"/>
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
			  <hr class="my-4">
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
             </form:form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>