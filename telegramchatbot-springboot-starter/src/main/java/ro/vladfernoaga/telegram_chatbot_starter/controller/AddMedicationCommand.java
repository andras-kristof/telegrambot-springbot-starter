package ro.vladfernoaga.telegram_chatbot_starter.controller;

import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

import ro.vladfernoaga.telegram_chatbot_starter.dto.MedicationDTO;
import ro.vladfernoaga.telegram_chatbot_starter.dto.MedicationUserDTO;
import ro.vladfernoaga.telegram_chatbot_starter.service.MedicationStorageService;

public class AddMedicationCommand implements MessageCommandAction {

	@Override
	public Boolean execute(TelegramBot bot, Message m, MedicationStorageService mss) {
		Integer chatId = m.from().id();
		String messageText = m.text();
		Integer messageId = m.messageId();
		String[] strings = messageText.split(" ");
		if (strings.length == 2) {
			MedicationDTO medication = mss.storeMedication(new MedicationDTO(strings[0], 0, 0, 0, 0, "",true), m.from().id().toString());
			SendMessage request = new SendMessage(chatId,
					String.format("Sucessfully Registered: %s",medication.toString() )).parseMode(ParseMode.HTML)
							.disableNotification(false).replyToMessageId(messageId).replyMarkup(new ForceReply());
			bot.execute(request);
			return true;
		}
		return false;
	}
}
