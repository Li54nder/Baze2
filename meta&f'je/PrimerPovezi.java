package cas3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;

public class DemoFunc {
	
	public static void main(String args[]) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@nastava.is.pmf.uns.ac.rs:1521:xe", "baze2", "baze2");
			
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement("INSERT INTO NASTAVNIK "
					+ "(nastavnik_id, ime, prezime, zvanje) "
					+ "VALUES (?,?,?,?)");
			pstmt.setInt(1, 12);
			pstmt.setString(2, "Sima");
			pstmt.setString(3, "Simic");
			pstmt.setString(4, "docent");
			pstmt.executeUpdate();

			// može se koristiti i Statement
			// u tom sluèaju bi dodavanje novog nastavnika izgledalo ovako
			// Statement stmt =
			// conn.executeUpdate("INSERT INTO NASTAVNIK (nastavnik_id, ime, prezime, zvanje) VALUES (10, 'Sima', 'Simic', 'asistent')");

			pstmt = conn.prepareStatement("INSERT INTO PREDMET "
					+ "(predmet_id, naziv) " + "VALUES (?,?)");
			pstmt.setInt(1, 12);
			pstmt.setString(2, "Engleski jezik");
			pstmt.executeUpdate();

			//---------------------------------------------------

			cstmt = conn.prepareCall("{?=call povezi(?, ?, ?)}");
			cstmt.setString(2, "Sima1");
			cstmt.setString(3, "Simic");
			cstmt.setString(4, "Engleski jezik");
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.executeQuery();
			System.out.println("Status: " + cstmt.getInt(1));

			//---------------------------------------------------

			conn.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			try {
				cstmt.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


}
