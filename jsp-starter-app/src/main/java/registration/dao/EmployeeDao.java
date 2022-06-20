package registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import registration.model.Employee;

public class EmployeeDao {
	
  public int registerEmployee(Employee employee) throws ClassNotFoundException {
	  
  
  String INSERT_USER_SQL = 
		  "INSERT INTO employee"+
		  "(id, first_name, last_name, username, password, address, contact)" +
		  "(?,?,?,?,?,?,?)";
  
  int result = 0;
  
  Class.forName("com.mysql.jdbc.Driver");
  
  try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_starter?useSSL=false","root","mysqlroot");
		  
		  PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)){
	      preparedStatement.setInt(1,1);
	      preparedStatement.setString(2, employee.getFirstName());
	      preparedStatement.setString(2, employee.getLastName());
	      preparedStatement.setString(4, employee.getUsername());
	      preparedStatement.setString(5, employee.getPassword());
	      preparedStatement.setString(6, employee.getAddress());
	      preparedStatement.setString(7, employee.getContact());
	      
	      System.out.print(preparedStatement);
	      
	      result = preparedStatement.executeUpdate();
	     
  }
  catch(Exception e) {
	  e.printStackTrace();
  }
   return result;
  }
 
		  
}
