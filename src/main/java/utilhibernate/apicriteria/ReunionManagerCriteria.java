/**
 * @author kbenjabr 28 déc. 2017/14:25:47 Software Engineer At Capgemini Morocco
 *
 */
package utilhibernate.apicriteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import bean.Reunion;
import utilhibernate.HibernateUtil;
import utilhibernate.hibernateQueryLanguage.ReunionManager;

public class ReunionManagerCriteria {

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

	public void updateReunion(String titre, Date date, long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Reunion reunion = new Reunion();
		reunion.setDateReunion(date);
		reunion.setIdReunion(id);
		reunion.setTitreReunion(titre);
		session.update(reunion);
		session.getTransaction().commit();
	}

	public void addListReunion(List<Reunion> lsitReunion) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for (Reunion reunion : lsitReunion) {
			addReunion(reunion.getTitreReunion(), reunion.getDateReunion(), reunion.getIdReunion());
		}
	}

	public List<Reunion> getListOfReunion() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Reunion.class);
		criteria.addOrder(Order.asc("titreReunion"));
		@SuppressWarnings("unchecked")
		List<Reunion> reunions = criteria.list();
		return reunions;
	}

	public void remveReunion(String nomReunion) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from Reunion r where r.titreReunion= :nomReunion");
		query.setParameter("nomReunion", nomReunion);
		query.executeUpdate();
		session.getTransaction().commit();
	}

	public void changeTitleOfReunion(long id, String newTitle) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Reunion.class);
		Criterion critere = Restrictions.eq("idReunion", id);
		criteria.add(critere);
		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		List<Reunion> reunions = criteria.list();
		reunions.get(0).setTitreReunion(newTitle);
		updateReunion(reunions.get(0).getTitreReunion(), reunions.get(0).getDateReunion(),
				reunions.get(0).getIdReunion());
	}

	public static void main(String[] args) {
		ReunionManagerCriteria managerCriteria = new ReunionManagerCriteria();
		managerCriteria.addListReunion(getReunion());
		managerCriteria.changeTitleOfReunion(13, "RESTFULL");
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
