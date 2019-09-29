import java.sql.*;
import javax.swing.*;


	public class dbConnectionHelper {
		
		static Connection conn=null;
		public static Connection Connect() throws ClassNotFoundException {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Admin","zabeen");
				return conn;
				
			} catch (SQLException e) {
				System.out.println("Error in db connection establishment");
				e.printStackTrace();
				return conn;
			}
	    }
	}


