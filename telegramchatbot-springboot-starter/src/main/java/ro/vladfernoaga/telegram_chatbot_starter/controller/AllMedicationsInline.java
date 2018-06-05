package ro.vladfernoaga.telegram_chatbot_starter.controller;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;

import ro.vladfernoaga.telegram_chatbot_starter.service.MedicationStorageService;

public class AllMedicationsInline implements MessageCommandAction {

	@Override
	public Boolean execute(TelegramBot bot, Message m, MedicationStorageService mss) {
		// TODO Auto-generated method stub
		return null;
	}

}
