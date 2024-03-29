<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="en">
<head>
<title></title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="container">
		<header class="row pt-5 pb-2">
			<div class="col-7">
				<h1>Online Entertainment</h1>
			</div>
			<div class="col-5 text-right">
				<img src="https://fpt.edu.vn/Content/images/assets/Poly.png"
					height="100px" alt="" class="mr-1">
			</div>
		</header>
		<nav class="row">
			<nav class="col navbar navbar-expand-sm navbar-light bg-light">
				<a class="navbar-brand col-5 mr-5" href="/myvideo/trangchu"> <i class="fa fa-home" aria-hidden="true"></i>Home
				</a>
				<div class="collapse navbar-collapse col-6" id="collapsibleNavId">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item"><a class="nav-link"
							href="/myvideo//admin/VideosManagement"><i class="fa fa-user"
								aria-hidden="true"></i> ADMIN</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/myvideo/user/LikeVideoServlet"><i
								class="fa fa-comment" aria-hidden="true"></i> My Favorite</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdownId"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="fa fa-user" aria-hidden="true"></i> My Account
						</a>
							<div class="dropdown-menu" aria-labelledby="dropdownId">
								<a class="dropdown-item" href="/myvideo/user/EditServlet">${user.fullname}</a>
								<c:if test="${ ! isLogin }">
								<a class="dropdown-item" href="/myvideo/LoginServlet">Login</a>
								<a class="dropdown-item" href="/myvideo/ForgotPassword">Forgot Password</a> <a
									class="dropdown-item" href="/myvideo/Registration">Register</a>
								</c:if>
								<c:if test="${isLogin }">	
							    <a class="dropdown-item" href="/myvideo/Logout">Logoff</a> <a
								class="dropdown-item" href="/myvideo/user/Chanpassword">Change
									Password</a>
								</c:if>

							</div></li>
					</ul>

				</div>
			</nav>
		</nav>
		<section class="row">
			<jsp:include page="${view}"></jsp:include>
		</section>
		<footer class="row">
			<div class="col text-center border-top">
				<strong>FPT Poly &copy;2021 </strong>
			</div>
		</footer>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>