package my.petclinic.owner;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import my.petclinic.utils.HibernateUtils;

public class OwnerRepository {
	
	private SessionFactory sessionFactory = HibernateUtils.getSesionFactory();

	public List<Owner> getOwnersByName(String ownersName){
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
			
		List<Owner> results = session.createQuery("from Owner where last_name like '" + ownersName + "'").list();
	
		System.out.println("From repository: " + results);
		
		session.getTransaction().commit();
		
		
		return results;
	}
	
	public Owner getOwnerById(int ownerId){
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		Owner persist = session.get(Owner.class, ownerId);
		
		session.getTransaction().commit();
		
		
		return persist;
	}

	public void saveOwner(Owner owner){
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		session.save(owner);
		
		session.getTransaction().commit();
		
	}
	
	public void updateOwner(Owner owner){
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		session.update(owner);
		
		session.getTransaction().commit();
	}
	
}
