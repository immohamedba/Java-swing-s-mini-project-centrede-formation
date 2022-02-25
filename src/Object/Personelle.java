package Object;

public class Personelle {
	private String nom, prenom, email, type_contrat, type_perso;
	int id, tel;
	
	public Personelle() {}
	public Personelle(int id, String nom, String prenom,  int tel, String email,String type_contrat, String type_pero) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;

		this.type_contrat = type_contrat;
		this.type_perso = type_pero;
		this.id = id;
		this.tel = tel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType_contrat() {
		return type_contrat;
	}
	public void setType_contrat(String type_contrat) {
		this.type_contrat = type_contrat;
	}
	public String getType_perso() {
		return type_perso;
	}
	public void setType_perso(String type_pero) {
		this.type_perso = type_pero;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	

}
