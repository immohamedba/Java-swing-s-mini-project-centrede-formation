package Object;

public class Formation {

	private  String description;
	private float prix; 
	private int id;
	private boolean certifie;
	public Formation(){}
	
	public Formation(String description, boolean certifie, float prix, int id) {
		super();
		this.description = description;
		this.certifie = certifie;
		this.prix = prix;
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean getCertifie() {
		return certifie;
	}
	public void setCertifie(boolean certifie) {
		this.certifie = certifie;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
