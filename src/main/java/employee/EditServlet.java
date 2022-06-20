package employee;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			Employee employee=new Employee();
			employee.setId(Integer.parseInt(request.getParameter("id")));
			employee.setAge(Integer.parseInt(request.getParameter("age")));
			employee.setTechnology(request.getParameter("technology"));
			employee.setName(request.getParameter("name"));
			EmployeeDao dao=new EmployeeDao();
			dao.updateEmployee(employee);
			response.sendRedirect("GetServlet");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
