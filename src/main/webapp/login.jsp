<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="employee.User,employee.UserDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<form action="LoginServlet" method="get">
		<table>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>
					<button type="submit">Login</button>
		</table>
	</form>
	<a href="index.jsp">register</a>
</body>
</html>