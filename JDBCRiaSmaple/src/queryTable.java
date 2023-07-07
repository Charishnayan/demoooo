
import java.sql.Connection;
import java.sql.PreparedStatement;


public class queryTable {
	public static void main(String args[]){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
	
		/*String query = "CREATE TABLE `riajava`.`employee` ("
				 +" `idemployee` INT NOT NULL,"
				 +" `employeeFirstName` VARCHAR(45) NULL,"
				 +" `employeeLastName` VARCHAR(45) NULL,"
				 +" `EmployeeAddress` VARCHAR(255) NULL,"
				 +"`EmployeePhoneNo` VARCHAR(45) NULL,"
				 +" PRIMARY KEY (`idemployee`))";
				 */
		
		
		
		String query = "INSERT INTO `riajava`.`employee` ("
				+"`idemployee`, `employeeFirstName`, `employeeLastName`, `EmployeeAddress`, `EmployeePhoneNo`)"
				+ " VALUES ('002', 'SR', 'K', 'mumbai', '555555');";
				
		
		try{			
			//get connection
			conn = JDBCSQLConnection.getConnection();
			
			//create preparedStatement
			preparedStatement = conn.prepareStatement(query);
			
			//execute query
			preparedStatement.execute();
			
			//close connection
			preparedStatement.close();
			conn.close();
			
			//System.out.println("Table created successfully.");
			System.out.println("Data inserted successfully.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
}
