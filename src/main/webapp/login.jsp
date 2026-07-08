<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<title>Login</title>

<style>
body {
	font-family: Arial;
	background: #f2f2f2;
}

.container {
	width: 350px;
	margin: 80px auto;
	background: white;
	padding: 25px;
	border-radius: 10px;
}

input {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
}

button {
	width: 100%;
	padding: 10px;
}

.error {
	color: red;
}
</style>

</head>

<body>

	<div class="container">

		<h2>SCMS Login</h2>

		<%
		String error = (String) request.getAttribute("error");

		if (error != null) {
		%>

		<p class="error">

			<%=error%>

		</p>

		<%
		}
		%>

		<form action="login" method="post">

			<input type="text" name="username" placeholder="Username"> <input
				type="password" name="password" placeholder="Password">

			<button>Login</button>

		</form>

	</div>

</body>

</html>