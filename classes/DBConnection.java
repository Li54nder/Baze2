package primer1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection conn = null;
	
	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(
					"jdbc:oracle:thin:@SeRvEr:0000:xx",
					"name","****");
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
