package my.boot.my_petclinic.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.boot.my_petclinic.owner.Owner;
import my.boot.my_petclinic.owner.Pet;
import my.boot.my_petclinic.owner.PetType;
import my.boot.my_petclinic.vet.Specialty;
import my.boot.my_petclinic.vet.Vet;
import my.boot.my_petclinic.visit.Visit;

public class HibernateUtils {

	private static SessionFactory _instance = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory(){
		return new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Owner.class)
				.addAnnotatedClass(Pet.class)
				.addAnnotatedClass(PetType.class)
				.addAnnotatedClass(Visit.class)
				.addAnnotatedClass(Vet.class)
				.addAnnotatedClass(Specialty.class)
				
				.buildSessionFactory();
	}
	
	public static SessionFactory getSesionFactory(){
		return _instance;
	}
	
}
