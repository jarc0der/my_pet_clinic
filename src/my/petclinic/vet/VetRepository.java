package my.petclinic.vet;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import my.petclinic.utils.HibernateUtils;

public class VetRepository {

	private SessionFactory sFactory = HibernateUtils.getSesionFactory();
	
	public List<Vet> getAllVets(){
		Session session = sFactory.getCurrentSession();
		
		session.beginTransaction();
		
		List<Vet> vetsResults = session.createQuery("from Vet").list();
		
		session.getTransaction().commit();
		
		return vetsResults;
	}
	
}
