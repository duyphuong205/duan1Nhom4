<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quan ly Phim Anh</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--Liên kết đến font-awesome-->
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<!--Liên kết với fontawesome-->
<link rel="stylesheet" href="../fontawesome-free-5.15.4-web/css/all.css">
<style>
.carousel-inner {
	height: 400px;
}

body {
	margin-top: 5px;
}

.container {
	background-color: #708090;
	border-radius: 5px;
}
</style>
<!-- đuờng dẫn cơ sở để mọi đường link trong trang wed có thể tham chiếu tới -->
<base href="/DUAN1_QLPA/" />
</head>

<body>
	<main class="container"> <!--bìa--> <header class="row">
		<div class="col-10">
			<div class="corousel">
				<div id="carouselExampleFade" class="carousel slide carousel-fade"
					data-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="images/film1.jpg" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="images/film2.jpg" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="images/film3.png" class="d-block w-100" alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-target="#carouselExampleFade" data-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-target="#carouselExampleFade" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</button>
				</div>
			</div>
		</div>
		<div class="col-2 text-right">
			<img src="images/logo.png" width="100%" height="130px" alt=""
				class="mr-2">
		</div>
	</header> <!--menu-->
	<nav class="row">
		<nav class=" col navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">FILM ONLINE</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item "><a class="nav-link" href="HomeServlet"> <i
							class="fa fa-home"></i> Trang Chủ <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#"> <i
							class="fa fa-info-circle"></i> Giới Thiệu
					</a></li>
					<c:if test="${admin==true}">
					<li class="nav-item"><a class="nav-link" href="UserManagementServlet"> <i
							class="fa fa-id-card"></i> Quản Lý
					</a></li>
					</c:if>
					<c:if test="${ isLogin}">
					<li class="nav-item"><a class="nav-link" href="FavoriteVideoServlet"> <i
							class="fa fa-heart"></i> Yêu Thích
					</a></li>
					</c:if>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownID"
						role="button" data-toggle="dropdown" aria-expanded="false"> <i
							class="fa fa-user-circle"></i> Tài Khoản
					</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<c:if test="${! isLogin}">
							<a class="dropdown-item" href="LoginServlet">Đăng Nhập</a> 
							<a class="dropdown-item" href="#">Quên Mật Khẩu</a> 
							<a class="dropdown-item" href="RegistrationServlet">Đăng Ký</a> 
							</c:if>
							<c:if test="${ isLogin}">
							<a class="dropdown-item" href="LogoffServlet">Đăng Xuất</a>
							<a class="dropdown-item" href="EditprofileServet">Chỉnh Sửa Hồ Sơ</a>
							<a class="dropdown-item" href="ChangepasswordSevlet">Đổi Mật Khẩu</a>
							</c:if>
						</div></li>
				</ul>
			</div>
		</nav>
	</nav>

	<!--nội dung-->
	<section class="row">
		<jsp:include page="${page.section}"></jsp:include>
	</section>
	<footer class="row">
		<div class="col">
			<footer class="bg-light text-center text-white">
				<!-- Grid container -->
				<div class="container p-4 pb-0">
					<!-- Section: Social media -->
					<section class="mb-4">
						<!-- Facebook -->
						<a class="btn btn-primary btn-floating m-1"
							style="background-color: #3b5998;"
							href="https://www.facebook.com/H%E1%BB%96-TR%E1%BB%A2-107125404772168"
							role="button"><i class="fa fa-facebook-f"></i></a>

						<!-- Twitter -->
						<a class="btn btn-primary btn-floating m-1"
							style="background-color: #55acee;" href="#!" role="button"><i
							class="fa fa-twitter"></i></a>

						<!-- Google -->
						<a class="btn btn-primary btn-floating m-1"
							style="background-color: #dd4b39;" href="#!" role="button"><i
							class="fa fa-google"></i></a>

						<!-- Instagram -->
						<a class="btn btn-primary btn-floating m-1"
							style="background-color: #ac2bac;" href="#!" role="button"><i
							class="fa fa-instagram"></i></a>

						<!-- Linkedin -->
						<a class="btn btn-primary btn-floating m-1"
							style="background-color: #0082ca;" href="#!" role="button"><i
							class="fa fa-linkedin"></i></a>
						<!-- Github -->
						<a class="btn btn-primary btn-floating m-1"
							style="background-color: #333333;" href="#!" role="button"><i
							class="fa fa-github"></i></a>
					</section>
					<!-- Section: Social media -->
				</div>
				<!-- Grid container -->

				<!-- Copyright -->
				<div class="text-center p-3"
					style="background-color: rgba(0, 0, 0, 0.2);">
					© 2020 Copyright: <a class="text-white"
						href="https://mdbootstrap.com/">MDBootstrap.com</a>
				</div>
				<!-- Copyright -->
			</footer>
		</div>
	</footer> </main>
	<!-- Option 2: Separate Popper and Bootstrap JS -->

	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
		integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
		crossorigin="anonymous">
		
	</script>
<%--     <c:if test="${not empty page.scriptUrl}"> --%>
<%--     <jsp:include page="${page.scriptUrl}"></jsp:include>     --%>
<%--     </c:if> --%>
</body>

</html>