package ro.vladfernoaga.telegram_chatbot_starter.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ro.vladfernoaga.telegram_chatbot_starter.dto.MedicationDTO;
import ro.vladfernoaga.telegram_chatbot_starter.dto.MedicationUserDTO;

@Entity
@Table(name = "medicationuser")
public class MedicationUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "morning",unique=false)
	private Integer morning;
	
	@Column(name = "lunch",unique=false)
	private Integer lunch;
	
	@Column(name = "dinner",unique=false)
	private Integer dinner;
	
	@Column(name = "night",unique=false)
	private Integer night;
	
	@Column(name = "name",unique=true)
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Medication> medications = new HashSet<Medication>();
	
	private MedicationUser() {
		super();
	}

	public MedicationUser(MedicationUserDTO medicationUserDTO) {
		name = medicationUserDTO.getName();
		morning = medicationUserDTO.getMorning();
		lunch = medicationUserDTO.getLunch();
		dinner = medicationUserDTO.getDinner();
		night = medicationUserDTO.getNight();
	}
	
	public MedicationUserDTO toMedicationUserDTO() {
		MedicationUserDTO medUDTO = new MedicationUserDTO(name);
		medUDTO.setMorning(morning);
		medUDTO.setDinner(dinner);
		medUDTO.setLunch(lunch);
		medUDTO.setNight(night);
		Set<MedicationDTO> medicatioDTOs = new HashSet<MedicationDTO>();
		medications.forEach((medication) -> medicatioDTOs.add(medication.toMedicationDTO()));
		medUDTO.setMedications(medicatioDTOs);
		return medUDTO;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMorning() {
		return morning;
	}

	public void setMorning(Integer morning) {
		this.morning = morning;
	}

	public Integer getLunch() {
		return lunch;
	}

	public void setLunch(Integer lunch) {
		this.lunch = lunch;
	}

	public Integer getDinner() {
		return dinner;
	}

	public void setDinner(Integer dinner) {
		this.dinner = dinner;
	}

	public Integer getNight() {
		return night;
	}

	public void setNight(Integer night) {
		this.night = night;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Medication> getMedications() {
		return medications;
	}

	public void setMedications(Set<Medication> medications) {
		this.medications = medications;
	}
	
	public void addMedication(Medication med) {
		this.medications.add(med);
	}
	
	public void removeMedication(Medication med) {
		this.medications.remove(med);
	}
}
