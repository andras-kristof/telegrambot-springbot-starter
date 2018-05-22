package ro.vladfernoaga.telegram_chatbot_starter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
}
