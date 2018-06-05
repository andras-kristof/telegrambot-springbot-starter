package ro.vladfernoaga.telegram_chatbot_starter.handler;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;

import ro.vladfernoaga.telegram_chatbot_starter.controller.FreeTextCommand;
import ro.vladfernoaga.telegram_chatbot_starter.controller.InvalidCommand;
import ro.vladfernoaga.telegram_chatbot_starter.service.BasicService;
import ro.vladfernoaga.telegram_chatbot_starter.service.MedicationStorageService;

@Service
public class SimpleUpdateHandler implements UpdatesListener {

	/** The Constant LOGGER. */
	public static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private TelegramBot bot;
	
	@Autowired
	private MedicationStorageService mss;
	// Process free text input from user
	InvalidCommand ic = new InvalidCommand();
	public void process(Message m) {
		String messageText = m.text();
		for (FreeTextCommand command : FreeTextCommand.values()) {
			if (messageText.startsWith(command.getCommandText())) {
				Boolean sucess = command.getAction().execute(bot, m, mss);
				if (sucess) {
					return;
				}
			}
		}
		ic.execute(bot, m, mss); 
	}

	public void procces(CallbackQuery callback) {
		Message m = callback.message();
		
		Integer chatId = m.from().id();
		Integer messageId = m.messageId();

		SendMessage request = new SendMessage(chatId,
				String.format("I recived your callback: %s", callback.data())).parseMode(ParseMode.HTML)
						.disableNotification(false).replyMarkup(new ForceReply());
		
		bot.execute(request);
	}
	
	private void process(Update u) {
		if(u.callbackQuery() != null) {
			procces(u.callbackQuery());
			return;
		}
		
		if(u.message() != null) {
			process(u.message());
			return;
		}
	}
	
	@Override
	public int process(List<Update> updates) {
		for (Update update : updates) {
			process(update);
		}

		return UpdatesListener.CONFIRMED_UPDATES_ALL;
	}

}
