package ro.vladfernoaga.telegram_chatbot_starter.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import ro.vladfernoaga.telegram_chatbot_starter.dto.MedicationDTO;
import ro.vladfernoaga.telegram_chatbot_starter.dto.MedicationUserDTO;
import ro.vladfernoaga.telegram_chatbot_starter.model.Medication;
import ro.vladfernoaga.telegram_chatbot_starter.model.MedicationUser;
import ro.vladfernoaga.telegram_chatbot_starter.repo.BasicRepo;
import ro.vladfernoaga.telegram_chatbot_starter.repo.MedicationRepo;
import ro.vladfernoaga.telegram_chatbot_starter.repo.MedicationUserRepo;
import ro.vladfernoaga.telegram_chatbot_starter.service.MedicationStorageService;
import ro.vladfernoaga.telegram_chatbot_starter.service.MedicationUserService;

@Service
public class MedicationStorageServiceImpl implements MedicationStorageService {

	private static final Logger LOGGER = LogManager.getLogger();
	  
	private MedicationUserRepo medicationUserRepo;
	private MedicationRepo medicationRepo;
	
	@Autowired
	public MedicationStorageServiceImpl(MedicationUserRepo medicationUserRepo, MedicationRepo medicationRepo) {
		this.medicationUserRepo = medicationUserRepo;
		this.medicationRepo = medicationRepo;
	}
	
	@Override
	@Transactional
	public MedicationUserDTO addNewOrGet(String name) {
		Optional<MedicationUser> medicationUser = medicationUserRepo.findByName(name);
		if (medicationUser.isPresent()) {
			LOGGER.info(() -> String.format("Fetched existing user: ",name));
			return medicationUser.get().toMedicationUserDTO();
		} else {
			MedicationUserDTO medUserDTO = new MedicationUserDTO(name);
			MedicationUser medUser = new MedicationUser(medUserDTO);
			try {
				medicationUserRepo.save(medUser);
				return medUserDTO;
			} catch (DataIntegrityViolationException ex) {
				throw new IllegalArgumentException(
						String.format("The name %s is already in use! ", name));
			}
		}
	}

	@Override
	public Boolean updateUser(MedicationUserDTO user) {
		Optional<MedicationUser> medicationUser = medicationUserRepo.findByName(user.getName());
		if (medicationUser != null) {
			LOGGER.info(() -> String.format("Fetched existing user for update: ",user.getName()));
			MedicationUser userObj = medicationUser.get();
			userObj.setMorning(user.getMorning());
			userObj.setDinner(user.getDinner());
			userObj.setLunch(user.getDinner());
			userObj.setNight(user.getNight());
			medicationUserRepo.save(new MedicationUser(userObj.toMedicationUserDTO()));
			return true;
		} else {
			MedicationUser medUser = new MedicationUser(user);
			try {
				medicationUserRepo.save(medUser);
				LOGGER.info(() -> String.format("Added new user: ",user.getName()));
				return true;
			} catch (DataIntegrityViolationException ex) {
				throw new IllegalArgumentException(
						String.format("The name %s is already in use! ", user.getName()));
			}
		}
	}

	@Override
	@Transactional
	public Boolean deactivateUser(String user) {
		Optional<MedicationUser> medicationUser = medicationUserRepo.findByName(user);
		if (medicationUser.isPresent()) {
			MedicationUser userObj = medicationUser.get();
			medicationUserRepo.delete(userObj);
			return true; 
		}
		return false;
	}
	
	@Override
	public MedicationDTO storeMedication(MedicationDTO medication, String user) {
		Optional<Medication> medicationMO = medicationRepo.findById(medication.getId());
		if (medicationMO.isPresent()) {
			return medicationMO.get().toMedicationDTO();
		}
		Optional<MedicationUser> medicationUser = medicationUserRepo.findByName(user);
		if (medicationUser.isPresent()) {
			MedicationUser userObj = medicationUser.get();
			Medication med = new Medication(medication);
			userObj.addMedication(med);
			medicationUserRepo.save(userObj);
			return med.toMedicationDTO();
		}
		return new MedicationDTO("", 0, 0, 0, 0, "", false);
	}
	
	@Override
	public Boolean deactivateMedication(Long id) {

		return null;
	}
	@Override
	public MedicationDTO getById(Long id) {

		return null;
	}
	
	

}
