package employee;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			User user = new User();
			user.setName(request.getParameter("name"));
			user.setPassword(request.getParameter("password"));
			UserDao dao = new UserDao();
			Boolean flag = dao.getUser(user);
			if (flag == true) {
				HttpSession session = request.getSession();
				session.setAttribute("name", user.getName());
				session.setAttribute("password", user.getPassword());
			}
			
				response.sendRedirect("Welcome.jsp");
				
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("<h1>Something Went Wrong</h1>");
		}
	}

}
