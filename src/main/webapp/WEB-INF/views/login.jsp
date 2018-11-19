<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="loginn.css">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<ul class="stuff">
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

	
	<form action="/login" method="post">
		<div class="container">

			<h1>Login</h1>
			<p class="message">${ message }</p>
			<p>Please Login</p>

			<hr>
			
			<label for="username"><b>Username</b></label> <input id="username" type="text" placeholder="Username" name="username" value="${ param.username }" required minlength="2">
			
			<label for="password"><b>Password</b></label> <input id="password" type="password" placeholder="Password" name="password" value="${ param.password }" required minlength="2">
	
			<label> <input type="checkbox" checked="checked"
				name="remember">Remember me
			</label>
			
			<br>
			
				<button>Login</button>

			</div>
		</div>
	</form>

</body>
</html>