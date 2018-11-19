<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="registration.css">
<meta charset="UTF-8">
<title>Registration</title>
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

	<form action="/summary">
		<div class="container">
			<h1>Sign Up</h1>
			<p>Please fill in this form to create an account.</p>
			
			<hr>
			
			<label for="firstname"><b>First Name</b></label> <input type="text" placeholder="Enter First Name" name="firstname" required>
			
			<label for="lastname"><b>Last Name</b></label> <input type="text" placeholder="Enter Last Name" name="lastname" required>
			
			<label for="email"><b>Email</b></label> <input type="text" placeholder="Enter Email" name="email" required>
			
			<label for="username"><b>UserName</b></label> <input type="text" placeholder="Enter username" name="username" required>
			 
			<label for="password"><b>Password</b></label> <input type="password"placeholder="Enter Password" name="password" required> 
			
			<label for="password-repeat"><b>Repeat Password</b></label> <input type="password" placeholder="Repeat Password" name="confirm-password"required> 
			
			<label for="number"><b>Phone Number</b></label> <input type="number" placeholder="Enter Phone Number" name="number" required>
			<br>
			
			<label> <input type="checkbox"checked="checked" name="remember" style="margin-bottom: 15px">Remember me</label>

			<p>
				By creating an account you agree to our <a href="#"
					style="color: dodgerblue">Terms & Privacy</a>.
			</p>

			<div class="clearfix">
				<button type="button" class="cancelbtn">Cancel</button>
				<button type="submit" class="signupbtn">Sign Up</button>
			</div>
		</div>
	</form>

</body>
</html>










