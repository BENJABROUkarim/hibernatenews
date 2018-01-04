/**
 * @author kbenjabr 2 janv. 2018/11:46:20 Software Engineer At Capgemini Morocco
 *
 */
package utilhibernate.hibernateQueryLanguage;

import java.util.Date;

import org.hibernate.Session;

import bean.Adresse;
import bean.Personne;
import utilhibernate.HibernateUtil;

public class PersonneManager {

	public void addPersonne(Personne personne) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(personne);
		session.getTransaction().commit();
	}

	public Personne getPersonne(int idPersonne) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Personne personne = (Personne) session.load(Personne.class, idPersonne);
		return personne;
	}

	public static void main(String[] args) {
		PersonneManager manager = new PersonneManager();
		Personne personne = new Personne("karim", "benjabrou", new Date(),
				new Adresse("ligne1", "linge2", "33", "salé", "hay errahme"));
		manager.addPersonne(personne);
		manager.getPersonne(1);
		HibernateUtil.getSessionFactory().close();
	}
}
