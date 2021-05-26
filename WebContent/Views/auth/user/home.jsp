<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	<div class="col-9">
		<div class="row p-2">
			<c:forEach var="item" items="${listVideos}">
				<div class="col-4 mt-2">
					<div class="card text-center">

						<div class="card-body">
							<img src="${item.poster}" width="90%" alt="" class="img-fluid">
							<div class="row border-top mt-2">
								<b>${item.title}</b>
							</div>
						</div>
						<div class="card-footer">
							<a href="/myvideo/user/LikeServlet?id=${item.id }" class="btn btn-success">Like</a>
							<a href="/myvideo/user/ShareServlet?id=${item.id}" class="btn btn-info">Share</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="row">
			<div class="col">
				<nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<li class="page-item"><a
							href="/myvideo/trangchu?page=1" class="page-link">
								First </a></li>
						<li class="page-item"><a
							href="/myvideo/trangchu?page=${page-1 <= 0 ? 1 : page-1}"
							class="page-link"> Prev </a></li>
						<li class="page-item"><a class="page-link"> ${page} </a></li>
						<li class="page-item"><a
							href="/myvideo/trangchu?page=${page+1 > listVideoSize ? 1: page+1}"
							class="page-link"> Next </a></li>
						<li class="page-item"><a
							href="/myvideo/trangchu?page=${listVideoSize}"
							class="page-link"> Last </a></li>
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
						<i class="fa fa-thumbs-up" aria-hidden="true" ></i> Favorite
					</div>
					<ul class="list-group list-group-flush" >
						<li class="list-group-item">Laptop</li>
						<li class="list-group-item">Computer</li>

					</ul>
				</div>
			</div>
		</div>
	</div>

</body>