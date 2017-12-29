/**
 * @author kbenjabr 20 déc. 2017/15:15:50 Software Engineer At Capgemini Morocco
 *
 */
package bean;

import java.util.Date;

public class Personnes {

	private int idPersonne;
	private String nomPersonne;
	private String prenomPersonne;
	private Date datenaissPersonne;

	public Personnes(String nomPersonne, String prenomPersonne, Date datenaissPersonne) {
		super();
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.datenaissPersonne = datenaissPersonne;
	}

	public Personnes() {
		super();
	}

	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomPersonne() {
		return prenomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}

	public Date getDatenaissPersonne() {
		return datenaissPersonne;
	}

	public void setDatenaissPersonne(Date datenaissPersonne) {
		this.datenaissPersonne = datenaissPersonne;
	}

}
