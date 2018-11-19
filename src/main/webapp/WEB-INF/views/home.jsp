<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
​<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>CoffeeShop</title>
</head>
<body>
<p class="message">${ message }</p>

<ul id="header">
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
	<div class="main">
		<h1>50 ROASTS DARKER Coffee Shop</h1>
	</div>


</body>
</html>