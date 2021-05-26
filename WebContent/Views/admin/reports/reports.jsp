<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<div class="col mt-4">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			href="#videoEditing" role="tab" aria-controls="home"
			aria-selected="true">Favorites</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false">Favorites Users</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="shareFriends-tab" data-toggle="tab" href="#shareFriends"
			role="tab" aria-controls="shareFriends" aria-selected="false">Share
				Friends</a></li>
	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<table class="table table-bordered mt-3">
				<tr>
					<td>Video Title</td>
					<td>Favorties Count</td>
					<td>Lasted Date</td>
					<td>Oldest Date</td>
				</tr>
				<c:forEach var="item" items="${favList }">
				<tr>
					<td>${item.videoTitle }</td>
					<td>${item.favoriteCount }</td>
					<td>${item.newestDate }</td>
					<td>${item.oldestDate }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<form action="" method="GET">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group">
							<label>Video Title 
							<select name="videoUserId" id="videoUserId"
								class="form-control ml-3">
								<c:forEach var="item" items="${vidList}">
									<option value="${item.id }" ${item.id == user_id?'selected':'' }>${item.title }</option>
									</c:forEach>
							</select>
							</label>
							<button class="btb btn-info ml-2">Report</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
							<tr>
								<td>ID</td>
								<td>Fullname</td>
								<td>Email</td>
								<td>Favorite Date</td>
							</tr>
							<c:forEach var="item" items="${ favUsers }">
							<tr>
								<td>${item.id }</td>
								<td>${item.fullname }</td>
								<td>${item.email }<td>
								<td>${item.like_date }</td>
							</tr>
							</c:forEach>	
						</table>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="shareFriends" role="tabpanel"
			aria-labelledby="shareFriends-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
                           <tr>
                              <td>Sender</td>
                              <td>Email</td>
                              <td>Receive Email</td>
                              <td>Sent Date</td>
                           </tr>
                           <c:forEach var="item" items="${ listShare }">
                           <tr>
                              <td>${item.user.id}</td>
                              <td>${item.user.email}</td>
                              <td>${item.emails}</td>
                              <td>${item.share_date}</td>
                           </tr>
                          </c:forEach>
                        </table>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>