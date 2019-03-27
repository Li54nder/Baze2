package primer1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection conn = null;
	
	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@nastava.is.pmf.uns.ac.rs:1521:xe",
					"baze2","baze2");
		}
		catch(Exception e){
			System.out.println("Database down");
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		return conn;
	}
	public static void closeConnection(){
		try{
			conn.close();
		}
		catch(Exception e){
			System.out.println("Neuspesno zatvaranje konekcije");
			e.printStackTrace();
		}
	}
}
