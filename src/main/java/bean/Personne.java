/**
 * @author kbenjabr 20 déc. 2017/15:15:50 Software Engineer At Capgemini Morocco
 *
 */
package bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Personne {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int idPersonne;
	@Column(name = "Nom")
	private String nomPersonne;

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Reunion> getReunionSet() {
		return reunionSet;
	}

	public void setReunionSet(Set<Reunion> reunionSet) {
		this.reunionSet = reunionSet;
	}

	@Column(name = "Prenom")
	private String prenomPersonne;
	@Column(name = "DateNaiss")
	private Date datenaissPersonne;
	@Embedded
	private Adresse adresse;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "REUNIONS_PERSONNES", joinColumns = { @JoinColumn(name = "ID_Personne") }, inverseJoinColumns = {
			@JoinColumn(name = "ID_REUNIONS") })
	private Set<Reunion> reunionSet = new HashSet<>();

	public Personne(String nomPersonne, String prenomPersonne, Date datenaissPersonne, Adresse adresse) {
		super();
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.datenaissPersonne = datenaissPersonne;
		this.adresse = adresse;
	}

	public Personne() {
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
