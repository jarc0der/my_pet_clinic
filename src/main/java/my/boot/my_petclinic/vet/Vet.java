package my.boot.my_petclinic.vet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import my.boot.my_petclinic.model.Person;

@Entity
@Table(name = "vets")
public class Vet extends Person{
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specialty_id"))
	private Set<Specialty> specialties;
	
	public Set<Specialty> getSpecialtiesInternal(){
		return specialties;
	}
	
	public void setSpecialtiesInternal(Set<Specialty> specialties){
		this.specialties = specialties;
	}
	
	public List<Specialty> getSpecialties(){
		return new ArrayList<>(getSpecialtiesInternal());
	}
	
	public int getNrOfSpecialties(){
		return getSpecialtiesInternal().size();
	}
	
	public void addSpecialty(Specialty specialty){
		getSpecialtiesInternal().add(specialty);
	}

}
