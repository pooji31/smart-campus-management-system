<%@ page import="com.scms.model.User"%>

<%
User user = (User) session.getAttribute("loggedInUser");
%>

<!DOCTYPE html>

<html>

<head>

<title>Admin Dashboard</title>

</head>

<body>

	<h1>Welcome Admin</h1>

	<h2>

		<%=user.getUsername()%>

	</h2>

	<a href="../logout"> Logout </a>

</body>

</html>