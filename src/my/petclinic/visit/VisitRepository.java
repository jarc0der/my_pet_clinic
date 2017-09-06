package my.petclinic.visit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import my.petclinic.utils.HibernateUtils;

public class VisitRepository {

	private SessionFactory sFactory = HibernateUtils.getSesionFactory();
	
	public void saveVisit(Visit visit) {
		Session session = sFactory.getCurrentSession();
		
		session.beginTransaction();
		
		session.save(visit);
		
		session.getTransaction().commit();
		
	}
	
}
