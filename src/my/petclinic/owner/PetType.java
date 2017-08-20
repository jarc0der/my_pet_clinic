package my.petclinic.owner;

import javax.persistence.Entity;
import javax.persistence.Table;

import my.petclinic.model.NamedEntity;

@Entity
@Table(name="types")
public class PetType extends NamedEntity{

}
