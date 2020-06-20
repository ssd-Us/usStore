<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-white border-light" id="sidebar-wrapper">
      <div class="sidebar-heading">
      	<c:if test="${!empty userSession.account}">
		<b><i><font size="4" color="RED">Welcome ${userSession.account.userId}!</font></i></b>
        </c:if>
      </div>
      <div class="list-group list-group-flush">
        <a href="<c:url value="/shop/handMade/listItem.do?productId=3"/>" class="list-group-item list-group-item-action bg-light">HandMade</a>
        <a href="<c:url value="/shop/secondHand/listItem.do?productId=2"/>" class="list-group-item list-group-item-action bg-light">SecondHand</a>
        <a href="<c:url value="/shop/auction/listItem.do?productId=1"/>" class="list-group-item list-group-item-action bg-light">Auction</a>
        <a href="<c:url value="/shop/groupBuying/listItem.do?productId=0"/>" class="list-group-item list-group-item-action bg-light">GroupBuying</a>
		<ul class="navbar-nav ml-auto mt-2 mt-lg-0 list-group-item list-group-item-action bg-light">
		<li class="nav-item dropdown">
			<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			  	Event
			</a>
			<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
				<a class="dropdown-item" href="<c:url value="/shop/viewEvent.do?catId=2"/>">퀴즈</a>
				<a class="dropdown-item" href="<c:url value="/shop/viewEvent.do?catId=3"/>">출석체크</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">My Coupon</a>
			</div>
		</li>
		</ul>
      </div>
    </div>
    <!-- /#sidebar-wrapper -->

    <!-- Page Content -->
    <div id="page-content-wrapper">
      <div class="container-fluid" align="center">
      	<!-- MAIN IMAGE -->
        <img src="../images/open1.jpg" style="float:center;width:800;height:450;border:0;" />
       </div>
    </div>
    <!-- /#page-content-wrapper -->
  </div>
  <!-- /#wrapper -->

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Menu Toggle Script -->
  <script>
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
  </script>

<!-- 토글 바 레이아웃 -->
<!--         <div class="collapse navbar-collapse" id="navbarSupportedContent"> -->
<!--           <ul class="navbar-nav ml-auto mt-2 mt-lg-0"> -->
<!--             <li class="nav-item active"> -->
<!--               <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a> -->
<!--             </li> -->
<!--             <li class="nav-item"> -->
<!--               <a class="nav-link" href="#">Link</a> -->
<!--             </li> -->
<!--             <li class="nav-item dropdown"> -->
<!--               <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> -->
<!--                 Dropdown -->
<!--               </a> -->
<!--               <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown"> -->
<!--                 <a class="dropdown-item" href="#">Action</a> -->
<!--                 <a class="dropdown-item" href="#">Another action</a> -->
<!--                 <div class="dropdown-divider"></div> -->
<!--                 <a class="dropdown-item" href="#">Something else here</a> -->
<!--               </div> -->
<!--             </li> -->
<!--           </ul> -->
<!--         </div> -->