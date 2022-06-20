package employee;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployeeDao dao;
    public GetServlet() {
        super();
        
        dao=new EmployeeDao();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Employee> employees = null;
		try {
			employees = dao.getEmployees();
			request.setAttribute("Employees", employees);
			
			RequestDispatcher rd=request.getRequestDispatcher("EmployeeRecords.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

