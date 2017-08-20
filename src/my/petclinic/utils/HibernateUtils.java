package my.petclinic.utils;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.petclinic.owner.Owner;
import my.petclinic.owner.Pet;
import my.petclinic.owner.PetType;
import my.petclinic.visit.Visit;

public class HibernateUtils {

	private static SessionFactory _instance = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory(){
		return new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Owner.class)
				.addAnnotatedClass(Pet.class)
				.addAnnotatedClass(PetType.class)
				.addAnnotatedClass(Visit.class)
				
				.buildSessionFactory();
	}
	
	public static SessionFactory getSesionFactory(){
		return _instance;
	}
	
}
