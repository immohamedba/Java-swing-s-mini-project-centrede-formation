package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Object.Personelle;


public class DaoPersonelle {

	Connection con; 
	public DaoPersonelle() {
		Connexion connexiton = new  Connexion();
		con = connexiton.getConnexion();
	}
	
	public void AjouterPersonelle(Personelle P) {
		String Rquest = "INSERT INTO personnelle (nom, prenom, tel,email,type_contra, type_perso) VALUES (? , ?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement stmt = con.prepareStatement(Rquest);
			stmt.setNString(1, P.getNom());
			stmt.setString(2, P.getPrenom() );
			stmt.setInt(3, P.getTel());
			stmt.setString(4, P.getEmail());
			stmt.setString(5, P.getType_contrat());
			stmt.setString(6, P.getType_perso());
			
			stmt.execute();
			System.out.println(" personnelle Added !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void SupprimerPersonelle(int id) {
		String Request ="DELETE FROM personnelle WHERE id = ? ";
		try {
			PreparedStatement stmt = con.prepareStatement(Request);
			stmt.setInt(1,id );
			stmt.execute();
		    //	System.out.println(" delete succes !");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
	
	
	public void SupprimerPersonelles() {

		String Request ="DELETE FROM personnelle ";
		try {
			PreparedStatement stmt = con.prepareStatement(Request);
			stmt.execute();
		    //	System.out.println(" delete all  succes !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	public void ModifierPersonelles(Personelle p) {
	
		String Request="UPDATE personelle SET  nom =?, prenom = ?, tel = ?, email = ?, type_contra = ?, type_perso = ?,  WHERE id = ?";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(Request);
			stmt.setNString(1, p.getNom());
			stmt.setString(2, p.getPrenom() );
			stmt.setInt(3, p.getTel());
			stmt.setString(4, p.getEmail());
			stmt.setString(5, p.getType_contrat());
			stmt.setString(6, p.getType_perso());
			stmt.setInt(7, p.getId());
			stmt.execute();
			System.out.println(" updated  !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	 public Personelle chercherPersonelle(int id) {
		 String request = "SELECT * FROM personelle WHERE  id = ?  ";
			PreparedStatement stmt;
			Personelle personelle = new Personelle () ;
			boolean exit = false;
			
			try {
				stmt = con.prepareStatement(request);
				stmt.setLong(1, id );
				 ResultSet resulat = stmt.executeQuery();
				 while(resulat.next()) {
					 personelle.setId(resulat.getInt(1));
					 personelle.setNom(resulat.getString(2));
					 personelle.setPrenom(resulat.getString(3));
					 personelle.setEmail(resulat.getString(4));
					 personelle.setTel(resulat.getInt(5));
					 personelle.setType_contrat(resulat.getString(6));
					 personelle.setType_perso(resulat.getString(7));
				     System.out.println(" Got it !");
				 exit = true;
				 }
			
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
			if(exit==true) { return personelle; }
			else return null;
	 }
	 
	 
	 
	public ArrayList <Personelle>  ListerPersonelle() {
		
		ArrayList<Personelle> ListPersonelle = new ArrayList<Personelle>();
		String request = "SELECT * FROM personelle ";
		PreparedStatement stmt;
		Personelle personelle = new Personelle () ;
		try {
			stmt = con.prepareStatement(request);
			 ResultSet resulat = stmt.executeQuery();
			 personelle.setId(resulat.getInt(1));
			 personelle.setNom(resulat.getString(2));
			 personelle.setPrenom(resulat.getString(3));
			 personelle.setEmail(resulat.getString(4));
			 personelle.setTel(resulat.getInt(5));
			 personelle.setType_contrat(resulat.getString(6));
			 personelle.setType_perso(resulat.getString(7));
			 ListPersonelle.add(personelle);
			
		
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		return ListPersonelle;
	}
	
	
	
}
