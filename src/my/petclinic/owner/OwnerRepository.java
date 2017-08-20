package my.petclinic.owner;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import my.petclinic.utils.HibernateUtils;

public class OwnerRepository {
	
	public static void main(String[] args) {
		Owner owner = new OwnerRepository().getOwnerById(13);
		owner.setFirstName("Harakl");
	}
	
	private SessionFactory sessionFactory = HibernateUtils.getSesionFactory();

	@Transactional
	public List<Owner> getOwnersByName(String ownersName){
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
			
		List<Owner> results = session.createQuery("from Owner where last_name like '" + ownersName + "'").list();
	
		System.out.println("From repository: " + results);
		
		session.getTransaction().commit();
		
		
		return results;
	}
	
	@Transactional
	public Owner getOwnerById(int ownerId){
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		Owner persist = session.get(Owner.class, ownerId);
		
		session.getTransaction().commit();
		
		
		return persist;
	}
	
	@Transactional
	public void saveOwner(Owner owner){
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		session.save(owner);
		
		session.getTransaction().commit();
		
	}
	
}
