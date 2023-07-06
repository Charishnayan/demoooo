import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
   public static void main(String[] args) {
       // Database connection details
       String url = "jdbc:mysql://localhost:4928/";
       String username = "ecwDbUser";
       String password = "123456789";

       try {
           // Load the JDBC driver
           Class.forName("com.mysql.cj.jdbc.Driver");

           // Establish the connection
           Connection connection = DriverManager.getConnection(url, username, password);
           
           

           // Connection successful
           System.out.println("Connected to the database!");

           // Perform database operations...

           // Close the connection
           connection.close();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

public static Connection getConnection() {
	// TODO Auto-generated method stub
	return null;
}
}