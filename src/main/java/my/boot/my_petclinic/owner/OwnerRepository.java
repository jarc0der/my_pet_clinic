package my.boot.my_petclinic.owner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OwnerRepository extends Repository<Owner, Integer>{

	    @Query("SELECT DISTINCT owner FROM Owner owner left join fetch owner.petsList WHERE owner.lastName LIKE :lastName%")
	    @Transactional(readOnly = true)
	    Collection<Owner> findByLastName(@Param("lastName") String lastName);

	    /**
	     * Retrieve an {@link Owner} from the data store by id.
	     * @param id the id to search for
	     * @return the {@link Owner} if found
	     */
	    @Query("SELECT owner FROM Owner owner left join fetch owner.petsList WHERE owner.id =:id")
	    @Transactional(readOnly = true)
	    Owner findById(@Param("id") Integer id);

	    /**
	     * Save an {@link Owner} to the data store, either inserting or updating it.
	     * @param owner the {@link Owner} to save
	     */
	    void save(Owner owner);


}
