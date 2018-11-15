<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
​<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- <tag library JSTL ^^^^^^^^^-->
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>

	<h1>Menu</h1>
	<form>
		<input name="category" placeholder="category" />
		<button>Filter</button>
	</form>

	<table>
		<tr>

			<th>Id</th>
			<th>Name</th>
			<th>Category</th>
			<th>Description</th>
			<th>Price</th>
		</tr>
		<c:forEach var="menuitem" items="${ menuitems }">
			<tr>
				<td>${menuitem.id }</td>
				<td>${menuitem.name }</td>
				<td>${menuitem.category }</td>
				<td>${menuitem.description }</td>
				<td>${menuitem.price }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>