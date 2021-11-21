<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-9">
	<div class="row p-2">
	<c:forEach var="item" items="${video}">
		<div class="col-3 mt-2">
			<div class="card text-center">
				<div class="card-body">
					<!--điều chỉnh kích thước img-fluid khắc phục bể hình-->
<!-- 					<img src="images/poster1.jpg" width="130px" height="200px" alt=""> -->
					<video width="100%" height="120px" controls>
                            <source  src="/DUAN1_QLPA//fileAnh/${item.poster}" type="video/mp4" ></video>
					<div class="row border-top mt-2">
						<b>${item.title}</b>
					</div>
				</div>
				<div class="card-footer">
					<a href="likevideo?id=${item.id}" class="btn btn-success">Like</a>
					<a href="sharevideo?id=${item.id}" class="btn btn-info">Share</a>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	<div class="row">
		<div class="col">
			<nav aria-label="Page navigation example">
				<!--justify-content-center đưa phân trang ra giữa-->
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
<div class="col-3">
	<div class="row mt-3 mb-3">
		<div class="col">
			<div class="card">
				<div class="card-header">
					<i class="fa fa-thumbs-up"></i>Yêu Thích

				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item"></li>
					<li class="list-group-item"></li>
					<li class="list-group-item"></li>
					<li class="list-group-item"></li>
					<li class="list-group-item"></li>
				</ul>
			</div>
		</div>
	</div>
</div>