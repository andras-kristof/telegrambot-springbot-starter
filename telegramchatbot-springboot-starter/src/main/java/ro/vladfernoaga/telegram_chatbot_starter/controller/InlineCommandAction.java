package ro.vladfernoaga.telegram_chatbot_starter.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

import ro.vladfernoaga.telegram_chatbot_starter.dto.MedicationDTO;
import ro.vladfernoaga.telegram_chatbot_starter.dto.MedicationUserDTO;
import ro.vladfernoaga.telegram_chatbot_starter.model.Medication;
import ro.vladfernoaga.telegram_chatbot_starter.service.MedicationStorageService;

@Component
public class InlineCommandAction implements MessageCommandAction {

	@Override
	public Boolean execute(TelegramBot bot, Message m, MedicationStorageService mss) {
//		Integer chatId = m.from().id();
//		String messageText = m.text();
//		Integer messageId = m.messageId();
//		MedicationUserDTO user = mss.addNewOrGet(m.from().id().toString());
//		Set<MedicationDTO> medications = user.getMedications();
//		InlineKeyboardButton[] buttons = new ArrayList<InlineKeyboardButton>();
//		for (MedicationDTO medication: medications) {
//			buttons.add(new InlineKeyboardButton(medication.getName()).callbackData(medication.getId().toString()));
//		}
//		InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup((InlineKeyboardButton[])buttons.toArray());
//		
//		SendMessage request = new SendMessage(chatId,
//				String.format("<b>Hello inline  %s", messageText))
//						.disableNotification(false).replyToMessageId(messageId)
//						.replyMarkup(inlineKeyboard);
//		bot.execute(request);
//		return true ;
		return false;
	}

}
