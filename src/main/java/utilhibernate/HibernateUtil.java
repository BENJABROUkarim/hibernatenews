/**
 * @author kbenjabr 21 déc. 2017/14:42:00 Software Engineer At Capgemini Morocco
 *
 */
package utilhibernate;

import org.hibernate.SessionFactory;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	public static final SessionFactory sessionFactory;
	static {
		try {
			// Création de la SessionFactory à partir de hibernate.cfg.xml
			sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	// public static final ThreadLocal session = new ThreadLocal();
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
