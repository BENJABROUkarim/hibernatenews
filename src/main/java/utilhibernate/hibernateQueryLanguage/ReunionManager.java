/**
 * @author kbenjabr 21 d�c. 2017/14:50:26 Software Engineer At Capgemini Morocco
 *
 */
package utilhibernate.hibernateQueryLanguage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bean.Personne;
import bean.Reunion;
import utilhibernate.HibernateUtil;

public class ReunionManager {

	public void addReunion(String titre, Date date, long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Reunion reunion = new Reunion();
		reunion.setDateReunion(date);
		reunion.setIdReunion(id);
		reunion.setTitreReunion(titre);
		session.save(reunion);
		session.getTransaction().commit();
	}

	public void addReunionToPersonne(int idPersonne, long idReuniuon) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		// charger la personne
		Personne personne = (Personne) session.load(Personne.class, idPersonne);
		// charger la r�union
		Reunion reunion = (Reunion) session.load(Reunion.class, idReuniuon);
		/**
		 * pas d'appel explicite � save ou update hibernate detecte
		 * auomatiquement que la collection a �t� modifi�e et a besoin d'etre
		 * mise � jour (automatic dirty cheking)
		 */
		personne.getReunionSet().add(reunion);
		session.getTransaction().commit();
	}

	public void addListReunion(List<Reunion> lsitReunion) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for (Reunion reunion : lsitReunion) {
			addReunion(reunion.getTitreReunion(), reunion.getDateReunion(), reunion.getIdReunion());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Reunion> getListOfReunion() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from Reunion");
		return query.list();
	}

	public void remveReunion(String nomReunion) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from Reunion r where r.titreReunion= :nomReunion");
		query.setParameter("nomReunion", nomReunion);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	public static void main(String[] args) {
		ReunionManager manager = new ReunionManager();
		manager.addListReunion(getReunion());
		manager.remveReunion("hibernate");
		manager.addReunionToPersonne(1, (long) 4);
		HibernateUtil.getSessionFactory().close();
	}

	private static List<Reunion> getReunion() {
		List<Reunion> reunions = new ArrayList<>();
		reunions.add(new Reunion((long) 1, new Date(), "hibernate"));
		reunions.add(new Reunion((long) 4, new Date(), "angularJs"));
		reunions.add(new Reunion((long) 5, new Date(), "Tapestry"));
		reunions.add(new Reunion((long) 6, new Date(), "j2ee"));
		reunions.add(new Reunion((long) 7, new Date(), "javascript"));
		reunions.add(new Reunion((long) 8, new Date(), "java8"));
		reunions.add(new Reunion((long) 9, new Date(), "Jboss"));
		reunions.add(new Reunion((long) 10, new Date(), "HQL"));
		reunions.add(new Reunion((long) 11, new Date(), "API Criteria"));
		reunions.add(new Reunion((long) 12, new Date(), "JPA"));
		reunions.add(new Reunion((long) 13, new Date(), "REST"));
		reunions.add(new Reunion((long) 14, new Date(), "SOAP"));
		return reunions;
	}

}
