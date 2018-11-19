<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
​<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="menu.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul id="stuff">
	<c:choose>
		<c:when test="${ not empty user }">
			Welcome ${ user.firstname }
			<a href="/logout">Logout</a>
		</c:when>
		<c:otherwise>
			<a href="/login">Login</a>
		</c:otherwise>
	</c:choose>
</ul>

<ul>
        <li><a href="/">Home</a></li>
		<li><a href="/menu">Menu</a></li>
		<li><a href="/cart">Cart</a></li>
		<li><a href="/registration">Become 50 Roasts Member</a></li>
	</ul>
	
	
	<h1>Cart</h1>
	<table id="menu">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Category</th>
			<th>Description</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Remove</th>
		</tr>
		<c:forEach var="cartitem" items="${ cartitems }">
			<tr>
				<td>${cartitem.menuItem.id }</td>
				<td>${cartitem.menuItem.name }</td>
				<td>${cartitem.menuItem.category }</td>
				<td>${cartitem.menuItem.description }</td>
				<td>${cartitem.menuItem.price }</td>
				<td>${cartitem.quantity }</td>
				<td><a href="/admin/menu/delete?id=${cartitem.menuItem.id }"
					class="btn btn-light btn-sm">Remove</a></td>
			</tr>
		</c:forEach>
	</table>
</body>