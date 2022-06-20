<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if (session.getAttribute("name") == null || session.getAttribute("password") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<form action="CreateServlet" method="post">
		<table>

			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="number" name="age"></td>
			</tr>
			<tr>
				<td>Technology</td>
				<td><input type="text" name="technology"></td>
			</tr>
			<tr>
				<td><button type="submit">submit</button></td>
			</tr>
		</table>

	</form>
	<a href="GetServlet">Employees Data</a>

</body>
</html>