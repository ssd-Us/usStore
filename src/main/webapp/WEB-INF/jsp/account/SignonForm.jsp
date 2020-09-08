<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>UsStore Login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/usstore.css?after" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/account.css?after" type="text/css" />

	<!-- Bootstrap core JavaScript -->
	<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<!-- Plugin JavaScript -->
	<script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>
	<!-- Custom JavaScript for this theme -->
	<script src="${pageContext.request.contextPath}/js/scrolling-nav.js"></script>
	
	<!-- Bootstrap core CSS -->
	<link href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Custom styles for this template -->
	<link href="${pageContext.request.contextPath}/css/scrolling-nav.css" rel="stylesheet">
	
	<!-- Custom styles for this template -->
	<link href="${pageContext.request.contextPath}/css/simple-sidebar.css" rel="stylesheet">
</head>
	
<c:if test="${!empty message}">
	<div class="alert alert-success" role="alert">
	  <font color="#FF4500"><c:url value="${message}" /></font>
  	</div>
</c:if>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Sign In</h5>
            <h6 class="card-title text-center">Please enter your ID and password.</h6>
              <form action='<c:url value="/shop/signon.do"/>' method="POST">
				  <c:if test="${!empty signonForwardAction}">
				    <input type="hidden" name="forwardAction" value='<c:url value="${signonForwardAction}"/>' />
				  </c:if>
	              <div class="form-label-group">
	                <input type="text" id="inputUserId" name="userId" class="form-control" placeholder="ID" required autofocus>
	                <label for="inputUserId">Your ID</label>
	              </div>
	              <div class="form-label-group">
	                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="PASSWORD" required>
	                <label for="inputPassword">Your Password</label>
	              </div>
	              <div class="form-label-group">
	                <button class="btn btn-lg btn-block btn-info text-uppercase" type="submit">Sign in</button>
	              </div>
	              <hr class="my-4">
	              <div class="form-label-group">
	              	<a href='<c:url value="/shop/newAccount.do"/>' class="btn btn-lg btn-info btn-block text-uppercase">
		              		New Account
	              	</a>
	              </div>
			 </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>