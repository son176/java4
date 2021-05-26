<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

	<div class="col mt-4">
		<jsp:include page="inform.jsp"></jsp:include>
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item" role="presentation"><a
				class="nav-link active" id="videoEditing-tab" data-toggle="tab"
				href="#videoEditing" role="tab" aria-controls="home"
				aria-selected="true">User Editing</a></li>
			<li class="nav-item" role="presentation"><a class="nav-link"
				id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
				aria-controls="videoList" aria-selected="false">User List</a></li>

		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="videoEditing"
				role="tabpanel" aria-labelledby="videoEditing-tab">
				<form action="/admin/UserManagementServlet" method="post">
					<div class="card">
						<div class="card-body">
							<div class="row">
								<div class="col">

									<div class="form-group">
										<label for="">Fullname</label> <input type="text"
											class="form-control" name="fullname" id="fullname"
											value="${uadmin.fullname}" aria-describedby="fullnamehelpId"
											placeholder="fullname"> <small id="fullnamehelpId"
											class="form-text text-muted">Fullname is required</small>
									</div>
									<div class="form-group">
										<label for="">Password</label> <input type="password"
											value="${uadmin.password}" class="form-control" name="password"
											id="password" aria-describedby="passwordhelpId"
											placeholder="password"> <small id="passwordhelpId"
											class="form-text text-muted">Password is required</small>
									</div>
								</div>
								<div class="col">
									<div class="form-group">
										<label for="">Email</label> <input type="text"
											class="form-control" name="email" id="email"
											value="${uadmin.email}" aria-describedby="emailhelpId"
											placeholder="email"> <small id="emailhelpId"
											class="form-text text-muted">Email is required</small>
									</div>
									<div class="form-group">
										<label for="username">ROLE</label> <input type="text"
											class="form-control" name="role" id="role"
											value="${uadmin.role}" aria-describedby="usernamehelpId"
											placeholder="role"> <small id="role"
											class="form-text text-muted">Role is required</small>
									</div>

								</div>
							</div>
						</div>
						<div class="card-footer text-center">
							<button class="btn btn-warning"
								formaction="/myvideo/admin/UserManagementServlet/update?id=${uadmin.id}">Update</button>
							<button class="btn btn-danger"
								formaction="/myvideo/admin/UserManagementServlet/delete?id=${uadmin.id}">Delete</button>
							<button class="btn btn-primary"
								formaction="/myvideo/admin/UserManagementServlet/reset">Reset</button>
						</div>
					</div>
				</form>
			</div>
			<div class="tab-pane fade" id="videoList" role="tabpanel"
				aria-labelledby="videoList-tab">
				<table class="table table-stripe">
					<tr>
						<td>Fullname</td>
						<td>Email</td>
						<td>Password</td>
						<td>Role</td>
						<td>&nbsp;</td>
					</tr>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.fullname }</td>
							<td>${item.email }</td>
							<td>${item.password }</td>
							<td>${item.role }</td>
							<td><a
								href="/myvideo/admin/UserManagementServlet/edit?id=${item.id }"><i
									class="fa fa-edit" aria-hidden="true"></i>Edit</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>

		</div>
	</div>
</body>
</html>