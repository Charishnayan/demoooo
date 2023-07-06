package basicJavaClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import basicJavaClass.JDBCMySQLTest;


public class QueryTable {
	public static void main(String args[]){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
	
		String query = "CREATE TABLE `eCWreports`.`PatientDetails` ("
				 +" `idPatient` INT NOT NULL,"
				 +" `patientFirstName` VARCHAR(45) NULL,"
				 +" `patientLastName` VARCHAR(45) NULL,"
				 +" `patientAddress` VARCHAR(255) NULL,"
				 +"`patientPhoneNo` VARCHAR(45) NULL,"
				 +" PRIMARY KEY (`idPatient`))";
		
		
		
		/**String query = "INSERT INTO `riajava`.`employee` ("
				+"`idemployee`, `employeeFirstName`, `employeeLastName`, `EmployeeAddress`, `EmployeePhoneNo`)"
				+ " VALUES ('002', 'SR', 'K', 'mumbai', '555555');";**/
		
		try{			
			//get connection
			conn = JDBCMySQLTest.getConnection();
			
			//create preparedStatement
			preparedStatement = conn.prepareStatement(query);
			
			//execute query
			preparedStatement.execute();
			
			//close connection
			preparedStatement.close();
			conn.close();
			
			System.out.println("Table created successfully.");
			System.out.println("Data inserted successfully.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
}
