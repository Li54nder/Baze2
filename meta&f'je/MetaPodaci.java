package cas3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaPodaci {
	
	public static void main(String[] args) {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@nastava.is.pmf.uns.ac.rs:1521:xe", "baze2", "baze2");
			
			//procitati proizvoljan upit sa konzole
			BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
			
			String s = b.readLine();
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(s);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int brojKolona = rsmd.getColumnCount();
			
			for(int i=1; i<=brojKolona; i++){
				System.out.print(rsmd.getColumnName(i) + "[" + rsmd.getColumnTypeName(i) + ") ");
			}
			System.out.println();
			
			while(rs.next()){
				for(int i=1; i<=brojKolona; i++){
					if(rsmd.getColumnTypeName(i).equals("NUMBER")){
						System.out.print(rs.getInt(i) + " ");
					}else if(rsmd.getColumnTypeName(i).equals("VARCHAR2")){
						System.out.print(rs.getString(i) + " ");
					}else if(rsmd.getColumnTypeName(i).equals("DATE")){
						System.out.print(rs.getDate(i) + " ");
					}
				}
				System.out.println();
			}
			
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


}
