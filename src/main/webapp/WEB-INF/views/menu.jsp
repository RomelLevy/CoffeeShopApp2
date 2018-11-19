<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
​<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- <tag library JSTL ^^^^^^^^^-->
<html>
<head>
<link type="text/css" rel="stylesheet" href="menu.css">
<meta charset="UTF-8">
<title>Menu</title>
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

	<h1>Menu</h1>
	

	<table id="menu">
		<tr>

			<th>Id</th>
			<th>Name</th>
			<th>Category</th>
			<th>Description</th>
			<th>Price</th>
			<th>Pick Up</th>
		</tr>
		<c:forEach var="menuitem" items="${ menuitems }">
			<tr>
				<td>${menuitem.id }</td>
				<td>${menuitem.name }</td>
				<td>${menuitem.category }</td>
				<td>${menuitem.description }</td>
				<td>${menuitem.price }</td>
				
				
				
				<td><a href="/add-to-cart?id=${ menuitem.id }"
					class="btn btn-light btn-sm">Add To Cart</a> 
					</td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	
</body>
</html>