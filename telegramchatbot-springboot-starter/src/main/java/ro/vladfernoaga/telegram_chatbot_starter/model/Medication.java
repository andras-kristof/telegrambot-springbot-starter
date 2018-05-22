package ro.vladfernoaga.telegram_chatbot_starter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ro.vladfernoaga.telegram_chatbot_starter.dto.MedicationDTO;

@Entity
@Table(name = "medication")
public class Medication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "dosage1")
	private Integer dosage1;
	
	@Column(name = "dosage2")
	private Integer dosage2;
	
	@Column(name = "dosage3")
	private Integer dosage3;
	
	@Column(name = "dosage4")
	private Integer dosage4;
	
	@Column(name = "unit")
	private String unit;

	protected Medication(String name, Integer dosage1, Integer dosage2, Integer dosage3, Integer dosage4, String unit) {
		super();
		this.name = name;
		this.dosage1 = dosage1;
		this.dosage2 = dosage2;
		this.dosage3 = dosage3;
		this.dosage4 = dosage4;
		this.unit = unit;
	}
	
	protected Medication(MedicationDTO medicationDTO) {
		super();
		this.name = medicationDTO.getName();
		this.dosage1 = medicationDTO.getDosage1();
		this.dosage2 = medicationDTO.getDosage2();
		this.dosage3 = medicationDTO.getDosage3();
		this.dosage4 = medicationDTO.getDosage4();
		this.unit = medicationDTO.getUnit();
	}
	
	protected MedicationDTO toMedicationDTO() {
		return new MedicationDTO(getName(),
								 getDosage1(),
								 getDosage2(),
								 getDosage3(),
								 getDosage4(),
								 getUnit());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDosage1() {
		return dosage1;
	}

	public void setDosage1(Integer dosage1) {
		this.dosage1 = dosage1;
	}

	public Integer getDosage2() {
		return dosage2;
	}

	public void setDosage2(Integer dosage2) {
		this.dosage2 = dosage2;
	}

	public Integer getDosage3() {
		return dosage3;
	}

	public void setDosage3(Integer dosage3) {
		this.dosage3 = dosage3;
	}

	public Integer getDosage4() {
		return dosage4;
	}

	public void setDosage4(Integer dosage4) {
		this.dosage4 = dosage4;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
