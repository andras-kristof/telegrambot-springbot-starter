package ro.vladfernoaga.telegram_chatbot_starter.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.vladfernoaga.telegram_chatbot_starter.model.Medication;

public interface MedicationRepo extends JpaRepository<Medication, Long> {
	
	Optional<Medication> findById(Long id);
	
}
