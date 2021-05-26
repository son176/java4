<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>


	<c:if test="${not empty message }">
		<div class="row">
			<div class="col">
				<div class="alert alert-success">${message }</div>

			</div>
		</div>
	</c:if>
	<c:if test="${not empty error }">
		<div class="row">
			<div class="col">

				<div class="alert alert-danger">${error }</div>
			</div>
		</div>
	</c:if>

</body>
</html>