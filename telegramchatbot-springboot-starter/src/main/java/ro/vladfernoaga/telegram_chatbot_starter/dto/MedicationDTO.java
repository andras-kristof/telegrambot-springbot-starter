package ro.vladfernoaga.telegram_chatbot_starter.dto;

public class MedicationDTO {

	private Long id;
	
	private String name;

	private Integer dosage1;
	
	private Integer dosage2;
	
	private Integer dosage3;
	
	private Integer dosage4;
	
	private String unit;
	
	private Boolean active;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
	
	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public MedicationDTO(String name, int dosage1, int dosage2, int dosage3, int dosage4, String unit, Boolean active) {
		this.id = (long) -1;
		this.name = name;
		this.dosage1 = dosage1;
		this.dosage2 = dosage2;
		this.dosage3 = dosage3;
		this.dosage4 = dosage4;
		this.unit = unit;
		this.active = active;
	}	
}
