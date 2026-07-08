<%@ page language="java"%>

<%@ page import="com.scms.model.User"%>

<%
User user = (User) session.getAttribute("loggedInUser");

if (user == null) {

	response.sendRedirect("login.jsp");

	return;

}
%>

<!DOCTYPE html>

<html>

<head>

<title>Dashboard</title>

</head>

<body>

	<h2>

		Welcome

		<%=user.getUsername()%>

	</h2>

	<a href="logout"> Logout </a>

</body>

</html>