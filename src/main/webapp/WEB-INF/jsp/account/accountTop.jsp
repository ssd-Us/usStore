<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
  <title>UsStore</title>
  <meta http-equiv="Cache-Control" content="max-age=0">
  <meta http-equiv="Cache-Control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT">
  <meta http-equiv="Pragma" content="no-cache">
  <link rel="stylesheet" href="../style/usstore.css" type="text/css" />
  <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="../resources/css/all.css" rel="stylesheet">
  <link href="../resources/css/account.css" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="2020-01 소프트웨어 시스템 개발 ">
  <meta name="author" content="愛+">
  <link rel="stylesheet" href="../../style/usstore.css" type="text/css" />
  
    <!-- Bootstrap core JavaScript -->
  <script src="../../resources/vendor/jquery/jquery.min.js"></script>
  <script src="../../resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="../../resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom JavaScript for this theme -->
  <script src="../../resources/js/scrolling-nav.js"></script>

  <!-- Bootstrap core CSS -->
  <link href="../../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../../resources/css/scrolling-nav.css" rel="stylesheet">
</head>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-white" id="mainNav">
     <a class="navbar-brand js-scroll-trigger" href="<c:url value="/shop/index.do"/>">
     	<img border="0" src="../images/usStore3.png" style="float:left;width:80;height:60;border:0;"/>
     	<img border="0" src="../images/logo.png" style="float:left;width:120;height:60;border:0;" />
     </a>
    <div class="container">
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="<c:url value="/shop/viewCart.do"/>"><font color="black">CART</font></a>
          </li>
          <c:if test="${empty userSession.account}" >
	          <li class="nav-item">
	            <a class="nav-link js-scroll-trigger" href="<c:url value="/shop/signonForm.do"/>"><font color="black">LOGIN</font></a>
	          </li>
          </c:if>
      	  <c:if test="${!empty userSession.account}" >
	      <li class="nav-item">
	        <a class="nav-link js-scroll-trigger" href="<c:url value="/shop/editAccount.do"/>"><font color="black">MYPAGE</font></a>
	      </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="<c:url value="/shop/signoff.do"/>"><font color="black">LOGOUT</font></a>
          </li>
          </c:if>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="../help.html"><font color="black">HELP</font></a>
          </li>
<!--           <li> -->
<%--               <form action="<c:url value="/shop/searchProducts.do"/>" method="post"> --%>
<!-- 			    <input type="hidden" name="search" value="true"/> -->
<!-- 		        <input type="text" name="keyword" size="14" />&nbsp; -->
<!-- 		        <input src="../../images/search.gif" type="image"/> -->
<%-- 		      </form> --%>
<!--           </li> -->
        </ul>
      </div>
    </div>
  </nav>