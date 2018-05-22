package ro.vladfernoaga.telegram_chatbot_starter.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ro.vladfernoaga.telegram_chatbot_starter.dto.MedicationUserDTO;

@Entity
@Table(name = "medicationuser")
public class MedicationUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "morning",unique=true)
	private Integer morning;
	
	@Column(name = "lunch",unique=false)
	private Integer lunch;
	
	@Column(name = "dinner",unique=false)
	private Integer dinner;
	
	@Column(name = "night",unique=false)
	private Integer night;
	
	@Column(name = "name",unique=true)
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Medication> medications = new HashSet<Medication>();
	
	protected MedicationUser(MedicationUserDTO medicationUserDTO) {
		name = medicationUserDTO.getName();
		morning = medicationUserDTO.getMorning();
		lunch = medicationUserDTO.getLunch();
		dinner = medicationUserDTO.getMorning();
		night = medicationUserDTO.getNight();
	}

	protected Integer getMorning() {
		return morning;
	}

	protected void setMorning(Integer morning) {
		this.morning = morning;
	}

	protected Integer getLunch() {
		return lunch;
	}

	protected void setLunch(Integer lunch) {
		this.lunch = lunch;
	}

	protected Integer getDinner() {
		return dinner;
	}

	protected void setDinner(Integer dinner) {
		this.dinner = dinner;
	}

	protected Integer getNight() {
		return night;
	}

	protected void setNight(Integer night) {
		this.night = night;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected Set<Medication> getMedications() {
		return medications;
	}

	protected void setMedications(Set<Medication> medications) {
		this.medications = medications;
	}
	
}
