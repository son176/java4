<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="col-8 offset-2">
	<form action="/myvideo/ForgotPassword" method="POST">
		<div class="card">
			<div class="card-header">
				<b>Forgotpassword</b>
			</div>
			<div class="card-body">
				
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="">Email</label> <input type="text"
								class="form-control" name="email" id="email"
								aria-describedby="email" placeholder="email"
								> <small id="email"
								class="form-text text-muted">Email is required</small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Sub Mit</button>
			</div>
		</div>
	</form>
</body>
</html>