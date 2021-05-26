<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
	<div class="offset-3 col-6 mt-4">
	<form action="/myvideo//user/Chanpassword" method="post">
		<div class="card">
			<div class="card-header">
				<b>Change Password</b>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username">Fullname</label> <input type="text"
								class="form-control" name="fullname" id="fullname"
								aria-describedby="usernamehelpId" placeholder="fullname">
						</div>
						<div class="form-group">
							<label for="">Password</label> <input type="password"
								class="form-control" name="password" id="password"
								placeholder="password">
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="currentpassword">Current Password</label> <input
								type="password" class="form-control" name="currentpassword"
								id="currentpassword" placeholder="current password">
						</div>
						<div class="form-group">
							<label for="confirmpassword">Confirm Password</label> <input
								type="password" class="form-control" name="confirmpassword"
								id="confirmpassword" placeholder="confirm password">
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Change Password</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>