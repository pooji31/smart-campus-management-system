<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String error =
(String)request.getAttribute("error");

if(error!=null){
%>

<p style="color:red">

<%=error%>

</p>

<%
}
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Register User</title>

<style>
body {
	font-family: Arial;
	background: #f4f4f4;
}

.container {
	width: 400px;
	margin: 50px auto;
	background: white;
	padding: 25px;
	border-radius: 8px;
}

input, select {
	width: 100%;
	padding: 10px;
	margin-top: 8px;
	margin-bottom: 15px;
}

button {
	width: 100%;
	padding: 10px;
}
</style>

</head>

<body>

	<div class="container">

		<h2>User Registration</h2>

		<form action="register" method="post">

			Username <input type="text" name="username"> Password <input
				type="password" name="password"> Email <input type="email"
				name="email"> Role <select name="roleId">

				<option value="1">ADMIN</option>

				<option value="2">FACULTY</option>

				<option value="3">STUDENT</option>

			</select>

			<button type="submit">Register</button>

		</form>

	</div>

</body>

</html>