package my.petclinic.visit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import my.petclinic.model.BaseEntity;

@Entity
@Table(name="visits")
public class Visit extends BaseEntity{

	@Temporal(TemporalType.DATE)
	@Column(name="visit_date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date visitDate;
	
	@Column(name="description")
	private String description;
	
	@Column(name = "pet_id")
    private Integer petId;

	public Visit() {
		this.visitDate = new Date();
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}
	
}
