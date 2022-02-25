package Object;

public class Specialite {
	private int id;
	private String nomSpecialite, desciption;
	
	public Specialite( ) {}
	public Specialite(int id, String nomSpecialite, String desciption) {
		super();
		this.id = id;
		this.nomSpecialite = nomSpecialite;
		this.desciption = desciption;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomSpecialite() {
		return nomSpecialite;
	}

	public void setNomSpecialite(String nomSpecialite) {
		this.nomSpecialite = nomSpecialite;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

}
