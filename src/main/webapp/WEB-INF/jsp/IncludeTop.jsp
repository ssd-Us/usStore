<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>UsStore</title>
	<!-- MetaData -->
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Cache-Control" content="max-age=0">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT">
	<meta http-equiv="Pragma" content="no-cache">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="2020-01 소프트웨어 시스템 개발 ">
	<meta name="author" content="愛+">
	
	<!-- UsStore Stylesheet -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/usstore.css?after" type="text/css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/account.css?after" type="text/css" />
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

	<!-- Google Font -->
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700|Raleway:400,300,500,700,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css" type="text/css">

    <!-- Theme Stylesheet -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css">

	<script>
		function search(word) {
			alert("검색어 : " + word);
	
			searchForm.submit();
		}
	</script>

</head>

<!-- 맨 위의 nav bar  -->
<!-- IncludeTopBar start -->

<body>
    <div class="top-bar">

        <div class="container">
        
            <div class="row">

                <div class="col-md-6"></div>

				<div class="action pull-right">
					<ul>
						<c:if test="${empty userSession.account}">
							<li>
								<div class="shop-top btn-group">
									<button type="button" class="btn dropdown-toggle" aria-haspopup="true" aria-expanded="false">
										<a href="<c:url value="/shop/signonForm.do"/>">
											<i class="fa fa-user"></i> LOGIN </a>
									</button>
								</div>
							</li>
						</c:if>

						<c:if test="${!empty userSession.account}">
							<li>

								<div class="shop-top btn-group">
									<button type="button" class="btn dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										MYPAGE <span class="caret"></span>
									</button>

									<ul class="dropdown-menu">
										<li><a href="<c:url value="/shop/viewAccount.do"/>">
											My Account</a></li>
										<li><a href="<c:url value="/shop/editAccount.do"/>">
											Edit Account</a></li>
										<li><a href="<c:url value="/shop/listOrders.do"/>">
											My Orders</a></li>
									</ul>
								</div>
								
							</li>
							
							<li>
								<div class="shop-top btn-group">
									<button type="button" class="btn dropdown-toggle" aria-haspopup="true"
										aria-expanded="false">
										<a href="<c:url value="/shop/viewCart.do"/>">
										<i class="fa fa-shopping-cart"></i> CART </a></button>
								</div>
							</li>
							
							<li>							
								<div class="shop-top btn-group">
									<button type="button" class="btn dropdown-toggle" aria-haspopup="true"
										aria-expanded="false">
										<a href="<c:url value="/shop/signoff.do"/>">
										<i class="fa fa-lock"></i> LOGOUT </a></button>
								</div>
							</li>

						</c:if>

					</ul>

				</div>

			</div>

        </div>

    </div>
<!-- IncludeTopBar end -->


<!-- Before Data -->

<%-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/usstore.css?after"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/account.css?after"
	type="text/css" />

<!-- Bootstrap core JavaScript -->
<script
	src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script
	src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom JavaScript for this theme -->
<script src="${pageContext.request.contextPath}/js/scrolling-nav.js"></script>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/scrolling-nav.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/simple-sidebar.css"
	rel="stylesheet">
</head>

<!-- Navigation -->
<!-- fixed-top 사용시 상단 고정 -->
<nav class="navbar navbar-expand-lg navbar-light bg-white border-bottom">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<button class="btn btn-light" id="menu-toggle">Menu</button>
</nav>


<nav class="navbar navbar-expand-lg navbar-dark bg-white" id="mainNav">
	<a class="navbar-brand js-scroll-trigger"
		href="<c:url value="/shop/index.do"/>"> <img border="0"
		src="${pageContext.request.contextPath}/images/usStore3.png"
		style="float: left; width: 80; height: 60; border: 0;" /> <img
		border="0" src="${pageContext.request.contextPath}/images/logo.png"
		style="float: left; width: 120; height: 60; border: 0;" />
	</a>
	<div class="container">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle js-scroll-trigger" href="#"
					id="navbarDropdown" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <font color="black"> SEARCH
							&nbsp; ▼</font>
				</a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="navbarDropdown">
						<form name="searchForm"
							action="<c:url value='/shop/search/viewItem.do'/>">
							<input type="radio" name="sKind" value="title">제목&nbsp; 
							<input type="radio" name="sKind" value="tag" checked="checked">태그 <br> 
							<input type="text" id="word" name="word" placeholder="검색어" />
							<button class="btn btn-light dropdown-item"
								onclick="search(word.value)">Click To Search!</button>
						</form>
					</div>
				</li>

				<li class="nav-item"><a class="nav-link js-scroll-trigger"
					href="<c:url value="/shop/viewCart.do"/>"><font color="black">CART</font></a>
				</li>

				<c:if test="${empty userSession.account}">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="<c:url value="/shop/signonForm.do"/>"><font
							color="black">LOGIN</font></a></li>
				</c:if>
				<c:if test="${!empty userSession.account}">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="<c:url value="/shop/signoff.do"/>"><font color="black">LOGOUT</font></a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle js-scroll-trigger" href="#"
						id="navbarDropdown" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <font color="black"> MYPAGE
								&nbsp; ▼</font>
					</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdown">
							<a class="dropdown-item"
								href="<c:url value="/shop/viewAccount.do"/>">My Account</a> <a
								class="dropdown-item"
								href="<c:url value="/shop/editAccount.do"/>">Edit Account</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item"
								href="<c:url value="/shop/listOrders.do"/>">My Orders</a>
						</div></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>
<script>
	function search(word) {
		alert("검색어 : " + word);

		searchForm.submit();
	}
</script> --%>