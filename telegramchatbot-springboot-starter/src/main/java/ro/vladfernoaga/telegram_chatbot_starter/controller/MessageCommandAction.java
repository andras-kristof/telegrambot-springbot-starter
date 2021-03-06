package ro.vladfernoaga.telegram_chatbot_starter.controller;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;

import ro.vladfernoaga.telegram_chatbot_starter.service.MedicationStorageService;

public interface MessageCommandAction {

	public Boolean execute(TelegramBot bot, Message m, MedicationStorageService mss);
}
