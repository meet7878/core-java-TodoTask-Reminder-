package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static String driver = "org.postgresql.Driver";
	static String url ="jdbc:postgresql://localhost:5432/ToDoApp";
	static String userName ="postgres";
	static String password ="root";
	public static Connection getConnection() {  //Add public static void main....
		//object
				
		try {
			//Driver Load
			Class.forName(driver);
			
				Connection con = DriverManager.getConnection(url,userName,password);
			
				
				if(con !=null) {
					System.out.println("DB Connected...");
				}
				return con; //remove
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;  //remove
		}
	}


	

