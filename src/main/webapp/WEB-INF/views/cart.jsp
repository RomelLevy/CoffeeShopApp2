<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
​<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Menu</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Category</th>
			<th>Description</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<c:forEach var="cartitem" items="${ cartitems }">
			<tr>
				<td>${cartitem.menuitem.id }</td>
				<td>${cartitem.menuitem.name }</td>
				<td>${cartitem.menuitem.category }</td>
				<td>${cartitem.menuitem.description }</td>
				<td>${cartitem.menuitem.price }</td>
				<td>${cartitem.quantity }</td>
				<td><a href="/admin/menu/delete?id=${cartitem.menuitem.id }"
					class="btn btn-light btn-sm">Remove</a></td>
			</tr>
		</c:forEach>
	</table>
</body>