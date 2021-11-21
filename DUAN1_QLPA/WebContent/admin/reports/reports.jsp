<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col">
	<!-- để thực hiện đổi tab để hiển thị nội dung thì cần đến script #mytab -->
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<!--hiển thị thông tin các video lên trên form-->
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			href="#videoEditing" role="tab" aria-controls="videoEditing"
			aria-selected="true">Favorites</a></li>
		<!--hiển thị thông tin các video ở trên bảng-->
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false">Favorite Users</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="sharefriend-tab" data-toggle="tab" href="#sharefriend" role="tab"
			aria-controls="sharefriend" aria-selected="false">Share Friends</a></li>
	</ul>
	<!--hiển thị nội dung của các tab-->
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<table class="table table-bordered mt-3">
				<tr>
					<td>Video Title</td>
					<td>Favorites Count</td>
					<td>Latest Date</td>
					<td>Oldest Date</td>
				</tr>
				<c:forEach var="item" items="${favorite}">
				<tr>
					<td>${item.videotitle}</td>
					<td>${item.favoriteCount}</td>
					<td>${item.newdate}</td>
					<td>${item.olddate}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<form action="" method="post">
				<div class="row mt-3">
					<div class="col">
						<!--hiển thị form(combobox)-->
						<div class="form-inline">
							<div class="form-group">
								<label>Video Title <select name="" id=""
									class="form-control ml-3">
										<option value="">hien thi sau</option>
								</select>
								</label>
								<button class="btn btn-success ml-3">Report</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
							<tr>
								<td>Username</td>
								<td>Fullname</td>
								<td>Email</td>
								<td>Favorite Date</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="sharefriend" role="tabpanel"
			aria-labelledby="sharefriend-tab">
			<form action="" method="post">
				<div class="row mt-3">
					<div class="col">
						<!--hiển thị form(combobox)-->
						<div class="form-inline">
							<div class="form-group">
								<label>Video Title <select name="" id=""
									class="form-control ml-3">
										<option value="">hien thi sau</option>
								</select>
								</label>
								<button class="btn btn-success ml-3">Report</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
							<tr>
								<td>Sender Name</td>
								<td>Sender Email</td>
								<td>Receiver Email</td>
								<td>Sent Date</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>