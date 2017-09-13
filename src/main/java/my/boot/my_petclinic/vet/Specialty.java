package my.boot.my_petclinic.vet;

import javax.persistence.Entity;
import javax.persistence.Table;

import my.boot.my_petclinic.model.NamedEntity;

@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity{

}
