package my.boot.my_petclinic.visit;

import org.springframework.data.repository.Repository;

public interface VisitRepository extends Repository<Visit, Integer>{
	
	public void save(Visit visit);
	
}
