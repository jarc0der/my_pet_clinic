package my.boot.my_petclinic.owner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import my.boot.my_petclinic.model.Person;

@Entity
@Table(name="owners")
public class Owner extends Person{

	@Column(name="address")
	@NotNull(message = "can't not be empty")
	@NotEmpty(message = "can't not be empty")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="telephone")
	@Digits(fraction = 2, integer = 10, message="should have exactly 10 numbers")
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner", fetch=FetchType.EAGER)
	private Set<Pet> petsList;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Set<Pet> getPetsInternal(){
		if(petsList == null){
			return new HashSet<>();
		}
		
		return petsList;
	}
	
	public void setPetsInternal(Set<Pet> pets){
		this.petsList = pets;
	}
	
	public List<Pet> getPets(){
		return new ArrayList<>(getPetsInternal());
	}
	
	public void addPet(Pet pet){
		if(pet.isNew()){
			getPetsInternal().add(pet);
		}
		
		pet.setOwner(this);
	}
	
	public Pet getPet(String name){
		return getPet(name, false);
	}
	
	public Pet getPet(String name, boolean ignoreNew){
		name = name.toLowerCase();
		
		for(Pet pet : getPetsInternal()){
			if(!ignoreNew || !pet.isNew()){
				String currentName = pet.getName().toLowerCase();
				if(name.equals(currentName)){
					return pet;
				}
			}
		}
		
		return null;
	}
	@Override
	public String toString() {
		return new StringBuilder()
				.append("id = " + this.getId())
	            .append("new = " + this.isNew())
	            .append("lastName = " + this.getLastName())
	            .append("firstName = " + this.getFirstName())
	            .append("address = " + this.address)
	            .append("city = " + this.city)
	            .append("telephone = " + this.telephone)
	            .toString();
	}
	
	
	
}
