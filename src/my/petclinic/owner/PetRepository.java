package my.petclinic.owner;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import my.petclinic.utils.HibernateUtils;

public class PetRepository {

	private SessionFactory sFactory = HibernateUtils.getSesionFactory();
	
	public List<PetType> getAllTypes(){
		Session session = sFactory.getCurrentSession();
		
		session.beginTransaction();
		
		List<PetType> types = session.createQuery("from PetType").list();
		
		session.getTransaction().commit();
		
		return types;
	}
	
	public void savePet(Pet pet){
		Session session = sFactory.getCurrentSession();
		
		session.beginTransaction();
		
		session.saveOrUpdate(pet);
		
		session.getTransaction().commit();
	}
	
	@Transactional
	public Pet getPetById(int petId) {
		Session session = sFactory.getCurrentSession();
		
		session.beginTransaction();
		
		Pet petFromDB = session.get(Pet.class, petId);
		
		session.getTransaction().commit();
		
		return petFromDB;
	}
	
}
