package my.boot.my_petclinic.owner;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import my.boot.my_petclinic.utils.HibernateUtils;

public interface PetRepository  extends Repository<Pet, Integer>{

	@Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
	public List<PetType> getAllTypes();
	
	void save(Pet pet);
	
	Pet findById(int petId);
	
}
