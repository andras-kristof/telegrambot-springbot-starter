package ro.vladfernoaga.telegram_chatbot_starter.service;

import ro.vladfernoaga.telegram_chatbot_starter.dto.MedicationUserDTO;

public interface MedicationUserService {
	
	MedicationUserDTO addNewOrGet(String name);
	Boolean updateUser(MedicationUserDTO user);
	Boolean deactivateUser(String user);
	
}
