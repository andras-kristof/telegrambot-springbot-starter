package ro.vladfernoaga.telegram_chatbot_starter.dto;

import java.util.HashSet;
import java.util.Set;

public class MedicationUserDTO {

	private Integer morning;

	private Integer lunch;

	private Integer dinner;

	private Integer night;

	private String name;
	
	private Set<MedicationDTO> medications = new HashSet<MedicationDTO>();

	public MedicationUserDTO(String name) {
		super();
		this.name = name;
		morning = 7;
		lunch = 12;
		dinner = 19;
		night = 0;
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

	public Set<MedicationDTO> getMedications() {
		return medications;
	}

	public void setMedications(Set<MedicationDTO> medications) {
		this.medications = medications;
	}

	@Override
	public String toString() {
		return "MedicationUserDTO [morning=" + morning + ", lunch=" + lunch + ", dinner=" + dinner + ", night=" + night
				+ ", name=" + name + ", medications=" + medications + "]";
	}
	
	
	
}
