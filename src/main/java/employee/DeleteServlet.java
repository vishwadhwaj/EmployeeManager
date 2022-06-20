package employee;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeDao dao = new EmployeeDao();
			Employee employee=dao.getEmployeeById(id);
			if(employee.getName()==null) {
				throw new Exception();
			}
			dao.deleteEmployee(id);
			response.sendRedirect("GetServlet");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Error.jsp");
		}

	}
}
