package my.boot.my_petclinic.owner;

import javax.persistence.Entity;
import javax.persistence.Table;

import my.boot.my_petclinic.model.NamedEntity;

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
