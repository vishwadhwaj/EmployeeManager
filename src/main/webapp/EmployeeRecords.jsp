<%@ page errorPage="Error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
if (session.getAttribute("name") == null || session.getAttribute("password") == null) {
	response.sendRedirect("login.jsp");
}
%>
<html>
<body>
	
	<br>
	<br>
	<table>

		<c:forEach var="employee" items="${Employees}">
			<tr>
				<td>${employee.getId()}</td>
				<td>${employee.getName()}</td>
				<td>${employee.getAge()}</td>
				<td>${employee.getTechnology()}</td>
				<td><form action="EditEmployee.jsp" method="post">
						<input type="hidden" name="id" value="${employee.getId() }">
						<button type="submit">edit</button>
					</form></td>
				<td><form action="DeleteServlet" method="post">
						<input type="hidden" name="id" value="${employee.getId() }">
						<button type="submit">Delete</button>
					</form>
				<td>
			</tr>
		</c:forEach>
	</table>
	<a href="LogOut">logout</a>
</body>
</html>