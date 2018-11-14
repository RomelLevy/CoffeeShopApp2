<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ title }</title>
</head>
<body>

	<main class="container">
	<h1>${ title }</h1>
	<!-- A form without an action submits back to the same URL, which is what we want here. -->
	<form method="post">
		<!-- We need to keep the ID and submit it with the form, but we don't want the user to have to see it. -->
		<input type="hidden" name="id" value="${menuitem.id}" />
		<div class="form-group">
			<label for="name">Name</label>
			<!-- pre-populate the input value from the existing food (if any) -->
			<input class="form-control" id="name" name="name"
				value="${menuitem.name}" required minlength="2" autocomplete="off">
		</div>
		<div class="form-group">
			<label for="category">Category</label> <input class="form-control"
				id="category" name="category" value="${menuitem.category}" required>
		</div>
		<div class="form-group">
			<label for="description">Description</label> <input
				class="form-control" id="description" name="description"
				value="${menuitem.description}" required minlength="3">
		</div>

		<div class="form-group">
			<label for="price">Price</label> <input class="form-control"
				id="price" name="price" value="${menuitem.price}" required
				minlength="3">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
		<a href="/menuitem" class="btn btn-link">Cancel</a>
	</form>
	</main>










</body>
</html>