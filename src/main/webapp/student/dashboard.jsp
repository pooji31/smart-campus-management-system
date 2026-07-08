<%@ page import="com.scms.model.User"%>

<%
User user = (User) session.getAttribute("loggedInUser");
%>

<h1>Student Dashboard</h1>

Welcome

<%=user.getUsername()%>

<br>
<br>

<a href="../logout"> Logout </a>