package ro.vladfernoaga.telegram_chatbot_starter.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.vladfernoaga.telegram_chatbot_starter.model.MedicationUser;

public interface MedicationUserRepo extends JpaRepository<MedicationUser, Long> {

	Optional<MedicationUser> findByName(String name);
}
