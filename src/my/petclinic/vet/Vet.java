package my.petclinic.vet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import my.petclinic.model.Person;

public class Vet extends Person{
	
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
