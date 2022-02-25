import DAO.DaoEtudiant;
import Object.Etudiant;

public class Main {

	public static void main(String[] args) {

		
		Etudiant e1 = new Etudiant (0, 0021653351, "Ba", "Mohamed", "ba.mhd778@gmail.com", "sfax"  ) ;
		Etudiant e2 = new Etudiant (0, 0021653351, "Ball", "Ahmed", "ba.cjam@gmail.com", "Soussa"  ) ;
		Etudiant e3 = new Etudiant (0, 0021653452, "Diallo", "Alassane", "bdia.mhd778@gmail.com","tunise") ;
		DaoEtudiant daoEtud =new DaoEtudiant ();
		/*daoEtud.SupprimerEtudiants ();
		daoEtud.AjouterEtudiant(e1);
		daoEtud.AjouterEtudiant(e2);
		daoEtud.AjouterEtudiant(e3);
		System.out.println(daoEtud.chercherEtudiant(25).toString()); */

		}
}
