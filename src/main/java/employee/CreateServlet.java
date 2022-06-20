package employee;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private Employee employee;
	private EmployeeDao dao;

	public CreateServlet() {
		super();
		employee = new Employee();
		dao = new EmployeeDao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			employee.setAge(Integer.parseInt(request.getParameter("age")));
			employee.setName(request.getParameter("name"));
			employee.setTechnology(request.getParameter("technology"));
			

			dao.createEmployee(employee);
			System.out.println("employee saved");
			response.sendRedirect("GetServlet");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
	}

}
