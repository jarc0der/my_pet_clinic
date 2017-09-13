package my.boot.my_petclinic.vet;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.repository.CrudRepository;

import my.boot.my_petclinic.utils.HibernateUtils;

public interface VetRepository extends CrudRepository<Vet, Integer>{
	
	public List<Vet> findAll();
	
}
