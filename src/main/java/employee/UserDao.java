package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "compaq");
		return con;
	}

	public void saveUser(User user) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = UserDao.getConnection()
				.prepareStatement("insert into users (name,password) values (?,?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.executeUpdate();
	}

	public Boolean getUser(User user) throws ClassNotFoundException, SQLException{
		PreparedStatement ps = UserDao.getConnection().prepareStatement("select * from users where password=? and name=?");
		ps.setString(1, user.getPassword());
		ps.setString(2, user.getName());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return true;
		} else {
			return false;
		}

	}
	
}
