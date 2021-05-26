<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="col-8 offset-2">
	<form action="/myvideo/Registration" method="post">
		<div class="card">
			<div class="card-header">
				<b>Registration</b>
			</div>
			<div class="card-body">
				
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="">Fullname</label> <input type="text"
								class="form-control" name="fullname" id="fullname"
								aria-describedby="fullnamehelpId" placeholder="fullname"
								> <small id="fullnamehelpId"
								class="form-text text-muted">Fullname is required</small>
						</div>
							<div class="form-group">
							<label for="">Email</label> <input type="text"
								class="form-control" name="email" id="email"
								aria-describedby="emailhelpId" placeholder="email"
								> <small id="emailhelpId"
								class="form-text text-muted">Email is required</small>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="">Password</label> <input type="password"
								class="form-control" name="password" id="password"
								aria-describedby="passwordhelpId" placeholder="password">
							<small id="passwordhelpId" class="form-text text-muted">Password
								is required</small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Sign Up</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>