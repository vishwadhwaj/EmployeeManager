<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="employee.EmployeeDao,employee.Employee" errorPage="Error.jsp"%>
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

	<%
	int id = Integer.parseInt(request.getParameter("id"));
	EmployeeDao dao = new EmployeeDao();
	Employee e = dao.getEmployeeById(id);
	if (e.getName() == null) {
		throw new Exception();
	}
	%>
	<form action="EditServlet" method="post">
		<table>
			<tr>

				<td><input type="hidden" name="id" value="<%=e.getId()%>"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="<%=e.getName()%>"></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="number" name="age" value="<%=e.getAge()%>"></td>
			</tr>
			<tr>
				<td>Technology</td>
				<td><input type="text" name="technology"
					value="<%=e.getTechnology()%>"></td>
			</tr>
			<tr>
				<td><button type="submit">submit</button></td>
			</tr>

		</table>

	</form>

	<a href="GetServlet">Employees Data</a>

</body>
</html>