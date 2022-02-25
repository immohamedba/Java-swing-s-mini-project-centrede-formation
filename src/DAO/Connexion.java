package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
	
	 Connection con;
	public 	Connexion() {
		
	try{  
		System.out.println("Here Connexion!");
		 con =DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/centre_formation","root","root");  
		//here bdd_catalogue is database name, root is username and password   
		System.out.println("Connection succes !");
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public  Connection getConnexion() {

		return con;
	}
}
