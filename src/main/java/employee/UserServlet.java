package employee;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			User user = new User();
			user.setName(request.getParameter("name"));
			user.setPassword(request.getParameter("password"));
			UserDao dao = new UserDao();
			dao.saveUser(user);
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Error.jsp");
		}
	}
}
