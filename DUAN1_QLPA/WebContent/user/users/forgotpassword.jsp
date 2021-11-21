<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="offset-4 col-4">
	<form action="" method="post">
		<div class="card mt-5">
			<div class="card-header">
				<b>Forgot PassWord</b>
			</div>
			<div class="card-body">
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						class="form-control" name="username" id="username"
						aria-describedby="usernameId" placeholder="Username" required> <small
						id="usernameId" class="form-text text-muted">Nhap
						Username!!!</small>
				</div>
				<div class="form-group">
					<label for="email">Email</label>
					<!-- required : yeu cau nhap thong tin tren form-->
					<input type="email" class="form-control" name="email" id="email"
						placeholder="Email" required>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Retrieve</button>
			</div>
		</div>
	</form>
</div>