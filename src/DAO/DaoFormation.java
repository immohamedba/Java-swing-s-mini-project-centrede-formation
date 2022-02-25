package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Object.Formation;
public class DaoFormation {

	Connection con; 
	public DaoFormation() {
		Connexion connexiton = new  Connexion();
		con = connexiton.getConnexion();
	}
	
	public void AjouterFormation(Formation F) {
		
		String Rquest = "INSERT INTO Formation (description, certifiee, prix ) VALUES (? , ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(Rquest);
			System.out.println(" Rquest!");
			stmt.setNString(1, F.getDescription());
			stmt.setBoolean(2, F.getCertifie());
			stmt.setFloat(3, F.getPrix());
			stmt.execute();
			System.out.println("Formation Added !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void SupprimerFormation(int id) {
		
		String Request ="DELETE FROM formation WHERE id = ? ";
		try {
			PreparedStatement stmt = con.prepareStatement(Request);
			stmt.setInt(1,id );
			stmt.execute();
		    //System.out.println(" delete succes !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void SupprimerFormations() {
		String Request ="DELETE FROM formation ";
		try {
			PreparedStatement stmt = con.prepareStatement(Request);
			stmt.execute();
		    //	System.out.println(" delete succes !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	public void ModifierFormation(Formation F) {
		// Formation(String description, String certifie, String prix, int id);
		String Request="UPDATE formation SET  description =?, certifiee = ?, prix = ? WHERE id = ?";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(Request);
			stmt.setNString(1,F.getDescription());
			stmt.setBoolean(2, F.getCertifie());
			stmt.setFloat(3, F.getPrix());
			stmt.setInt(4, F.getId() );
			stmt.execute();
			System.out.println(" formation updated  !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Formation chercherFormation(int id) {
		String request = "SELECT * FROM formation WHERE  id = ?  ";
		PreparedStatement stmt;
		Formation formation =new Formation() ;
		boolean exit = false;
		
		try {
			 stmt = con.prepareStatement(request);
			 stmt.setInt(1, id );
			 ResultSet resulat = stmt.executeQuery();
			 while(resulat.next()) {
				 formation.setId(resulat.getInt(1));
				 formation.setDescription(resulat.getString(2));
				 formation.setCertifie(resulat.getBoolean(3));
				 formation.setPrix(resulat.getFloat(4));
			 System.out.println(" Got it!");
			 exit = true;
			 }
		
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		if(exit==true) { return formation; }
		else return null;
	}
	
	public ArrayList <Formation>  ListerFormation(){
		
		ArrayList<Formation> ListFormation = new ArrayList<Formation>();
		String request = "SELECT * FROM formation ";
		PreparedStatement stmt;
		Formation formation = new Formation () ;
		try {
			stmt = con.prepareStatement(request);
			 ResultSet resulat = stmt.executeQuery();
			 while(resulat.next()) {
				formation.setId(resulat.getInt(1));
				formation.setDescription(resulat.getString(2));
				formation.setCertifie(resulat.getBoolean(3));
				formation.setPrix(resulat.getFloat(4));
				ListFormation.add(formation);
			}
		
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		return ListFormation;
	}
	
	
}
