package Object;
public class Session {

	private int formationId, formateurId;
	private String dateDebut, DateFin;
	private String heurDebut, heurFin;
	private String salle ;

	public Session() {}
	public Session(int formationId, int formateurId, String dateDebut, String dateFin, String heurDebut, String heurFin,
			String salle) {
		super();
		this.formationId = formationId;
		this.formateurId = formateurId;
		this.dateDebut = dateDebut;
		this.DateFin = dateFin;
		this.heurDebut = heurDebut;
		this.heurFin = heurFin;
		this.salle = salle;
	}
	public int getFormationId() {
		return formationId;
	}
	public void setFormationId(int formationId) {
		this.formationId = formationId;
	}
	public int getFormateurId() {
		return formateurId;
	}
	public void setFormateurId(int formateurId) {
		this.formateurId = formateurId;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return DateFin;
	}
	public void setDateFin(String dateFin) {
		DateFin = dateFin;
	}
	public String getHeurDebut() {
		return heurDebut;
	}
	public void setHeurDebut(String heurDebut) {
		this.heurDebut = heurDebut;
	}
	public String getHeurFin() {
		return heurFin;
	}
	public void setHeurFin(String heurFin) {
		this.heurFin = heurFin;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
	}
	
	
}
