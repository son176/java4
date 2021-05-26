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
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item" role="presentation"><a
				class="nav-link active" id="videoEditing-tab" data-toggle="tab"
				href="#videoEditing" role="tab" aria-controls="home"
				aria-selected="true">Video Editing</a></li>
			<li class="nav-item" role="presentation"><a class="nav-link"
				id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
				aria-controls="profile" aria-selected="false">Video List</a></li>

		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="videoEditing"
				role="tabpanel" aria-labelledby="videoEditing-tab">
				<form action="/admin/VideosManagement" method="POST">
					<div class="card">

						<div class="card-body">
							<div class="row">
								<div class="col-3">
									<div class="border p-3">
										<img src="${video.poster}" width="90%" alt=""
											class="img-fluid">
									</div>
								</div>
								<div class="col-9">
									<div class="form-group">
										<label for="youtubeId">Youtube ID</label> <input type="text"
											readonly="readonly" class="form-control" name="id" id="id"
											value="${video.id}" aria-describedby="youtubeIdhelpId"
											placeholder="youtubeId">
									</div>
									<div class="form-group">
										<label for="videoTitle">Video Title</label> <input type="text"
											class="form-control" name="title" id="title"
											value="${video.title}" aria-describedby="videoTitle"
											placeholder="videoTitle"> <small id="videoTitile"
											class="form-text text-muted">VideoTitle is required</small>
									</div>
									<div class="form-group">
										<label for="viewCount">View Count</label> <input type="text"
											class="form-control" name="views" id="views"
											value="${video.views}" aria-describedby="viewCounthelpId"
											placeholder="viewCount"> <small id="viewCounthelpId"
											class="form-text text-muted">View Count is required</small>
									</div>
									<div class="form-group">
										<label for="poster">Poster Link</label> <input type="text"
											class="form-control" name="poster" id="poster"
											value="${video.poster}" aria-describedby="poster"
											placeholder="poster"> <small id="viewCounthelpId"
											class="form-text text-muted">Poster Link</small>
									</div>
									<div class="form-check form-check-inline">
										<label> <input type="radio" class="form-check-input"
											value="1" name="active" id="active"
											${video.active==1? 'checked':'' }>Active
										</label> <label> <input type="radio" class="form-check-input"
											value="2" name="active" id="active"
											${video.active!=1? 'checked':'' }>Inactive
										</label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<label for="description">Description</label>
									<textarea name="description" id="description" cols="30"
										rows="4" class="form-control">${video.description }</textarea>
								</div>
							</div>
						</div>
						<div class="card-footer text-muted">
							<button formaction="/myvideo/admin/VideosManagement/create"
								class="btn btn-primary">Create</button>
							<button formaction="/myvideo/admin/VideosManagement/update"
								class="btn btn-warning">Update</button>
							<button formaction="/myvideo/admin/VideosManagement/delete"
								class="btn btn-danger">Delete</button>
							<button formaction="/myvideo/admin/VideosManagement/reset"
								class="btn btn-primary">Reset</button>
						</div>
					</div>
				</form>
			</div>
			<div class="tab-pane fade" id="videoList" role="tabpanel"
				aria-labelledby="videoList-tab">
				<table class="table table-stripe">
					<tr>
						<td>Video ID:</td>
						<td>Video title</td>
						<td>View Count</td>
						<td>Description</td>
						<td>Active</td>
						<td>&nbsp;</td>
					</tr>
					<c:forEach var="item" items="${listvideo}">
						<tr>
							<td>${item.id}</td>
							<td>${item.title}</td>
							<td>${item.views}</td>
							<td>${item.description}</td>
							<td>${item.active}</td>
							<td><a
								href="/myvideo/admin/VideosManagement/edit?id=${item.id }"><i
									class="fa fa-edit" aria-hidden="true"></i>Edit</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</div>
</body>
</html>