package ro.vladfernoaga.telegram_chatbot_starter.service;

import ro.vladfernoaga.telegram_chatbot_starter.dto.MedicationDTO;

public interface MedicationService {
	MedicationDTO storeMedication(MedicationDTO medication, String user);
	Boolean deactivateMedication(Long id);
	MedicationDTO getById(Long id);
}
