package my.petclinic.owner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

import my.petclinic.model.NamedEntity;
import my.petclinic.visit.Visit;

@Entity
@Table(name="pets")
public class Pet extends NamedEntity{
	
	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotNull
	private Date birthDate;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	@ManyToOne
	@JoinColumn(name="type_id")
	private PetType petType;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="petId", fetch=FetchType.EAGER)
	private Set<Visit> visits;

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthday) {
		this.birthDate = birthday;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}
	
	public Set<Visit> getVisitInternal(){
		if(visits == null){
			return new HashSet<>();
		}
		
		return visits;
	}
	
	public void setVisitInternal(Set<Visit> visits){
		this.visits = visits;
	}
	
    public List<Visit> getVisits() {
        List<Visit> sortedVisits = new ArrayList<>(getVisitInternal());
//        PropertyComparator.sort(sortedVisits,
//                new MutableSortDefinition("birthdate", false, false));
        return Collections.unmodifiableList(sortedVisits);
    }

    public void addVisit(Visit visit) {
        getVisitInternal().add(visit);
        visit.setPetId(this.getId());
    }

}
