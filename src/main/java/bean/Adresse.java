/**
 * @author kbenjabr 2 janv. 2018/11:19:08 Software Engineer At Capgemini Morocco
 *
 */
package bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	@Column(name = "Ligne1", nullable = false)
	private String ligne1;
	@Column(name = "Ligne2")
	private String ligne2;
	@Column(name = "Cp")
	private String cp;
	@Column(name = "Ville")
	private String ville;
	@Column(name = "Ligne3")
	private String ligne3;

	public Adresse() {
		super();
	}

	public Adresse(String ligne1, String ligne2, String cp, String ville, String ligne3) {
		super();
		this.ligne1 = ligne1;
		this.ligne2 = ligne2;
		this.cp = cp;
		this.ville = ville;
		this.ligne3 = ligne3;
	}

	public String getLigne1() {
		return ligne1;
	}

	public void setLigne1(String ligne1) {
		this.ligne1 = ligne1;
	}

	public String getLigne2() {
		return ligne2;
	}

	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getLigne3() {
		return ligne3;
	}

	public void setLigne3(String ligne3) {
		this.ligne3 = ligne3;
	}

}
