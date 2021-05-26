<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="col">
		<div class="row p-2">
			<c:forEach var="item" items="${listvideo}">
			<div class="col-3 mt-2">
				<div class="card">
					<div class="card-body">
						<img src="${item.poster}" width="90%" alt="" class="img-fluid">
						<div class="row">
							<b>${item.title}</b>
						</div>
					</div>
					<div class="card-footer text-muted">
						<a href="/myvideo/user/UnlikeServlet?id=${item.id}" class="btn btn-primary">Unlike</a> <a href="/myvideo/user/ShareServlet?id=${item.id}"
							class="btn btn-info">Share</a>
					</div>
				</div>
			</div>
			</c:forEach>
	</div>
</body>
</html>