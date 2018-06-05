package ro.vladfernoaga.telegram_chatbot_starter.controller;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

import ro.vladfernoaga.telegram_chatbot_starter.dto.MedicationUserDTO;
import ro.vladfernoaga.telegram_chatbot_starter.service.MedicationStorageService;

public class RegisterCommandAction implements MessageCommandAction {

	@Override
	public Boolean execute(TelegramBot bot, Message m, MedicationStorageService mss) {
		Integer chatId = m.from().id();
		String messageText = m.text();
		Integer messageId = m.messageId();
		MedicationUserDTO user = mss.addNewOrGet(m.from().id().toString());
		SendMessage request = new SendMessage(chatId,
				String.format("Sucessfully Registered: %s",user.toString() )).parseMode(ParseMode.HTML)
						.disableNotification(false).replyToMessageId(messageId).replyMarkup(new ForceReply());
		bot.execute(request);
		return true;
	}

}
