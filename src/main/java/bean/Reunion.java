/**
 * @author kbenjabr 20 déc. 2017/15:04:43 Software Engineer At Capgemini Morocco
 *
 */
package bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REUNION")
public class Reunion {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long idReunion;
	@Column(name = "DATE_REUNION")
	private Date dateReunion;
	@Column(name = "Titre_REUNION")
	private String titreReunion;

	public Reunion(Long idReunion, Date dateReunion, String titreReunion) {
		super();
		this.idReunion = idReunion;
		this.dateReunion = dateReunion;
		this.titreReunion = titreReunion;
	}

	public Reunion() {
		super();
	}

	public Long getIdReunion() {
		return idReunion;
	}

	public void setIdReunion(Long idReunion) {
		this.idReunion = idReunion;
	}

	public Date getDateReunion() {
		return dateReunion;
	}

	public void setDateReunion(Date dateReunion) {
		this.dateReunion = dateReunion;
	}

	public String getTitreReunion() {
		return titreReunion;
	}

	public void setTitreReunion(String titreReunion) {
		this.titreReunion = titreReunion;
	}

}
