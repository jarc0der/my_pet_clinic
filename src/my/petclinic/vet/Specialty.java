package my.petclinic.vet;

import javax.persistence.Entity;
import javax.persistence.Table;

import my.petclinic.model.NamedEntity;

@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity{

}
