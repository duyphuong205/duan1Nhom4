<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="offset-2 col-8">
	<form action="RegistrationServlet" method="post">
		<div class="card">
			<div class="card-header">
				<b>Registration</b>
			</div>
			<div class="card-body">
          <jsp:include page="/display/thongbao.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								class="form-control" name="id" id="username" "
								aria-describedby="usernameId" placeholder="Username" Required> <small
								id="usernameId" class="form-text text-muted">Nhap
								Username!!!</small>
						</div>
						<div class="form-group">
							<label for="fullname">Fullname</label> <input type="text"
								class="form-control" name="fullname" id="fullname" "
								aria-describedby="fullnameId" placeholder="Fullname" Required> <small
								id="fullnameId" class="form-text text-muted">Nhap
								Fullname!!!</small>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" name="password" id="password"
								placeholder="Password" Required>
								<small class="form-text text-muted">Nhap Password!!!</small>
						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="email"
								class="form-control" name="email" id="email" "
								aria-describedby="emailId" placeholder="Email" Required> <small
								id="emailId" class="form-text text-muted">Nhap Email!!!</small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Sign Up</button>
				<a href="LoginServlet">Login</a>
			</div>
		</div>
	</form>
</div>