package employee;

import java.sql.*;
import java.util.ArrayList;


public class EmployeeDao {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","compaq");
		return con;
	}
	
	public ArrayList<Employee> getEmployees() throws ClassNotFoundException, SQLException{
		PreparedStatement ps=EmployeeDao.getConnection().prepareStatement("select * from employee");
		ResultSet rs=ps.executeQuery();
		ArrayList<Employee> employees=new ArrayList<>();
		while(rs.next()) {
			Employee employee=new Employee();
			employee.setAge(rs.getInt(2));
			employee.setId(rs.getInt(4));
			employee.setName(rs.getString(1));
			employee.setTechnology(rs.getString(3));
			employees.add(employee);
		}
		return employees;
	}
	
	public void createEmployee(Employee employee) throws SQLException, ClassNotFoundException {
		PreparedStatement ps=EmployeeDao.getConnection()
				.prepareStatement("insert into employee (name,age,technology) values(?,?,?)");
		ps.setString(1, employee.getName());
		ps.setInt(2, employee.getAge());
		ps.setString(3, employee.getTechnology());
		ps.executeUpdate();
	}
	
	public Employee getEmployeeById(int Id) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=EmployeeDao.getConnection()
				.prepareStatement("select * from employee where id=?");
		ps.setInt(1, Id);
		ResultSet rs=ps.executeQuery();
		Employee employee=new Employee();
		if(rs.next()) {
			employee.setAge(rs.getInt(2));
			employee.setId(rs.getInt(4));
			employee.setName(rs.getString(1));
			employee.setTechnology(rs.getString(3));
		}
		return employee;
	}
	
	public void updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=EmployeeDao.getConnection()
				.prepareStatement("update employee set name=?,age=?,technology=? where id=?");
		ps.setString(1, employee.getName());
		ps.setInt(2, employee.getAge());
		ps.setString(3, employee.getTechnology());
		ps.setInt(4, employee.getId());
		ps.executeUpdate();
	}
	
	public void deleteEmployee(int id) throws ClassNotFoundException, SQLException {
		PreparedStatement ps=EmployeeDao.getConnection()
				.prepareStatement("delete from employee where id=?");
		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
