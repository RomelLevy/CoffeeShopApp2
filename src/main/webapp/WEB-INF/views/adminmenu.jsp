<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
​<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="menu.css">
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>


	<h1>Admin</h1>
	<form>
		<input name="category" placeholder="category" />
		<button>Filter</button>
	</form>

	<table id="menu">
		<tr>

			<th>Id</th>
			<th>Name</th>
			<th>Category</th>
			<th>Description</th>
			<th>Price</th>
		</tr>
		<c:forEach var="menuitem" items="${ menu }">
			<tr>
				<td>${menuitem.id }</td>
				<td>${menuitem.name }</td>
				<td>${menuitem.category }</td>
				<td>${menuitem.description }</td>
				<td>${menuitem.price }</td>


				<td><a href="/admin/menu/update?id=${ menuitem.id }"
					class="btn btn-light btn-sm">Edit</a> <a
					href="/admin/menu/delete?id=${ menuitem.id }"
					class="btn btn-light btn-sm">Delete</a></td>

			</tr>
		</c:forEach>
	</table>
	<a class="btn btn-secondary" href="/admin/menu/create">Add</a>

</body>
</html>