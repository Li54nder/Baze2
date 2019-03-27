package primer1;

import java.sql.*;

public class DBF {
	public static void unesiNastavnika(Nastavnik n){
		PreparedStatement pstmt=null;
		try{
			pstmt=DBConnection.getConnection().
					prepareStatement("insert into NASTAVNIK "
							+ "(nastavnik_id,ime, prezime, zvanje) "
							+ "values (?,?,?,?)");
			pstmt.setInt(1, n.getNastavnik_id());
			pstmt.setString(2, n.getIme());
			pstmt.setString(3, n.getPrezime());
			pstmt.setString(4, n.getZvanje());
			pstmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null){
				try{
					pstmt.close();
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		}
	}
	
	public static boolean obrisiNastavnika(int nastavnik_id){
		boolean rezultat=false;
		PreparedStatement pstmt=null;
		try{
			DBConnection.getConnection().setAutoCommit(false);
			pstmt=DBConnection.getConnection().prepareStatement(
					"delete from PREDAJE where nastavnik_id=?");
			pstmt.setInt(1, nastavnik_id);
			pstmt.executeUpdate();
			pstmt=DBConnection.getConnection().prepareStatement(
					"delete from NASTAVNIK where nastavnik_id=?");
			pstmt.setInt(1, nastavnik_id);
			pstmt.executeUpdate();
			DBConnection.getConnection().commit();
			rezultat=true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			try{
				DBConnection.getConnection().rollback();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		finally{
			if(pstmt!=null){
				try{
					pstmt.close();
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
			}
		}
		return rezultat;	
	}
	
	public static void prikaziPredmete(int nastavnik_id){
		Statement stmt=null;
		ResultSet rset=null;
		try{
			stmt=DBConnection.getConnection().createStatement();
			rset=stmt.executeQuery("select naziv from PREDMET p, PREDAJE pr where "
					+ "p.predmet_id=pr.predmet_id and pr.nastavnik_id="
							+nastavnik_id);
			//"select naziv from PREDMET where predmet_id in(select 
			//predmet_id from predaje where nastavnik_id="+nastavnik_id+")"
			while(rset.next())
				System.out.println(rset.getString(1));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(rset!=null){
				try{
					rset.close();
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
			}
			if(stmt!=null){
				try{
					stmt.close();
				}
				catch(SQLException e2){
					e2.printStackTrace();
				}
			}
		}
	}
	
	public static boolean promeniPrezime(int nastavnik_id, String novoPrezime){
		boolean rezultat=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=DBConnection.getConnection().prepareStatement(
					"update NASTAVNIK set prezime=? where nastavnik_id=?");
			pstmt.setString(1, novoPrezime);
			pstmt.setInt(2, nastavnik_id);
			pstmt.executeUpdate();
			rezultat=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null){
				try{
					pstmt.close();
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
		return rezultat;
	}
}
