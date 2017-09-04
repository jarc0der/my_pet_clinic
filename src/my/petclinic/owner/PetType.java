package my.petclinic.owner;

import javax.persistence.Entity;
import javax.persistence.Table;

import my.petclinic.model.NamedEntity;

@Entity
@Table(name="types")
public class PetType extends NamedEntity{

	@Override
	public int hashCode() {
	    return super.getId();
	}
	
	@Override
	public boolean equals(Object obj) {
	    return (this == obj);
	}
}
