<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="offset-4 col-4">
	<form action="LoginServlet" method="post">
		<div class="card">
			<div class="card-header">
				<b>Login to System</b>
			</div>
			<div class="card-body">
			<jsp:include page="/display/thongbao.jsp"></jsp:include>
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						class="form-control" name="id" id="username" value="${id}"
						aria-describedby="usernameId" placeholder="Username" Required> <small
						id="usernameId" class="form-text text-muted">Nhap
						Username!!!</small>
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="password" id="password" value="${password}"
						aria-describedby="passwordID" placeholder="Password" Required> <small
						id="passwordID" class="form-text text-muted">Nhap
						Password!!!</small>
				</div>
				<div class="form-check form-check-inline">
					<label><input type="checkbox" class="form-check-input"
						name="remember">Remember Me</label>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-primary">Login</button>
			</div>
		</div>
	</form>
</div>