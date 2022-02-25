package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Object.Session;

public class DaoSession {


	Connection con; 
	public DaoSession() {
		Connexion connexiton = new  Connexion();
		con = connexiton.getConnexion();
	}
	
	public boolean AjouterSession(Session S) {

		String Rquest = "INSERT INTO session (formationId, formateurId, date_debut, date_fin, heur_debut, heur_fin, salle ) VALUES (? , ?, ?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement stmt = con.prepareStatement(Rquest);
			stmt.setInt(1, S.getFormationId());
			stmt.setInt(2, S.getFormateurId());
			stmt.setString(3, S.getDateDebut());
			stmt.setString(4, S.getDateFin());
			stmt.setString(5, S.getHeurDebut());
			stmt.setString(6, S.getHeurFin());
			stmt.setString(7, S.getSalle());
			stmt.execute();
			System.out.println(" session Added !");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean SupprimerSession(int idformateur,int  idFormation, String date_debut,String date_fin ) {
	//	date_fin ="'"+date_fin+"'";
	//	date_debut ="'"+date_debut+"'";
	//	DELETE FROM centre_formation.session WHERE formateurId = 3 and FormationId =1 and date_debut ='15-05-2021' and date_fin ='25-02-2022';
		 
		String Request ="DELETE FROM session WHERE formateurId =? and FormationId =? and date_debut =? and date_fin =?";
		//String x ="DELETE FROM session WHERE formateurId =? and FormationId =? and date_debut ="+date_debut+" and date_fin = "+date_fin;
		try {
			//System.out.println(x);
			PreparedStatement stmt = con.prepareStatement(Request);
			stmt.setInt(1,idformateur );
			stmt.setInt(2,idFormation );
			stmt.setString(3, date_debut );
			stmt.setString(4,date_fin );
			stmt.execute();
			System.out.println(" delete succes !");
			return true;
		   
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}
	public boolean  SupprimerSessions() {
		String Request ="DELETE FROM session ";
		try {
			PreparedStatement stmt = con.prepareStatement(Request);
			stmt.execute();
			return true;
		    //	System.out.println(" delete succes !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean ModifierSession(Session newS, Session oldS) {
		String Request="UPDATE session SET formationId = ?, formateurId =?, date_debut = ?, date_fin = ?, heur_debut = ?, heur_fin = ?, salle = ? WHERE formationId = ? and formateurId =? and date_debut = ? and date_fin =? ";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(Request);
			
			stmt.setInt(1, newS.getFormationId());
			stmt.setInt(2, newS.getFormateurId());
			stmt.setString(3, newS.getDateDebut());
			stmt.setString(4, newS.getDateFin());
			stmt.setString(5, newS.getHeurDebut());
			stmt.setString(6, newS.getHeurFin());
			stmt.setString(7, newS.getSalle());	
			
			stmt.setInt(8, oldS.getFormationId());
			stmt.setInt(9, oldS.getFormateurId());
			stmt.setString(10, oldS.getDateDebut());
			stmt.setString(11, oldS.getDateFin());
			stmt.execute();
			
			System.out.println(" session updated  !");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  false;
	}
	
	public ArrayList<Session>  chercherSession(int idformateur,int  idFormation ) {
		String request = "SELECT * FROM session WHERE  formationId = ? and formateurId =? ";
		PreparedStatement stmt;
		ArrayList<Session> ListSession = new ArrayList<Session>();
		boolean exit = false;
		// (formationId, formateurId, date_debut, date_fin, heur_debut, heur_fin, salle
		try {
			stmt = con.prepareStatement(request);
			stmt.setInt(1, idFormation );
			stmt.setInt(2, idformateur );
			
			 ResultSet resulat = stmt.executeQuery();
			 while(resulat.next()) {
				 Session session = new Session () ;
				 session.setFormationId(resulat.getInt(1));
				 session.setDateDebut(resulat.getString(2));
				 session.setDateFin(resulat.getString(3));
				 session.setHeurDebut(resulat.getString(4));
				 session.setHeurFin(resulat.getString(5));
				 session.setFormateurId(resulat.getInt(6));
				 session.setSalle(resulat.getString(7));
				 ListSession.add(session);

			    System.out.println(" Got them !");
			    exit = true;
			 }
			 } catch (SQLException e) {
				 e.printStackTrace();
				 }
		   if(exit==true) { return ListSession; }
		   else return null;
	}
	
	public ArrayList<Session>   ListerSessions() {
		
		ArrayList<Session> listSession = new ArrayList<Session>();
		String request = "SELECT * FROM session ";
		PreparedStatement stmt;
		ResultSet resulat = null ;
		try {
			stmt = con.prepareStatement(request);
			 resulat = stmt.executeQuery();
			  
			 while(resulat.next()) {
				 Session session = new Session () ;
				 session.setFormationId(resulat.getInt(1));
				 session.setDateDebut(resulat.getString(2));
				 session.setDateFin(resulat.getString(3));
				 session.setHeurDebut(resulat.getString(4));
				 session.setHeurFin(resulat.getString(5));
				 session.setFormateurId(resulat.getInt(6));
				 session.setSalle(resulat.getString(7));
				 listSession.add(session);
			}
		
		 } catch (SQLException e) {
			e.printStackTrace();
		 }

		return  listSession ;
		
	} 
}
