<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="styles.css">
<meta charset="UTF-8">
<title>Summary</title>
</head>
<header>
	<a href="/">Home</a>
	
	<span>
	<c:choose>
		<c:when test="${ not empty user }">
			Welcome ${ user.firstname }
			<a href="/logout">Logout</a>
		</c:when>
		<c:otherwise>
			<a href="/login">Login</a>
			<a href="/signup">Sign Up</a>
		</c:otherwise>
	</c:choose>
	</span>
</header>




<body>
${message }
	<ul>
		<li><a href="/registration">Back To Form</a></li>
		<li><a href="/">Home</a></li>
		<li><a href="/menu">Menu</a></li>
		<li><a>RoastPost</a></li>
		<li><a>About</a></li>
	</ul>



	<h1>Summary</h1>
	<p>Hello! ${ firstname } you've been signed up to receive coupons,
		deals & our monthly newsletter the 'roastpost' in your email. Head
		over to your inbox to check those out & since you've decided to become
		a member your first roast is on US......yes FREE coffee! See you soon!</p>
</body>
</html>