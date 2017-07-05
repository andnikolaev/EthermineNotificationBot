package com.nikolaev.bot;

import java.util.ResourceBundle;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.nikolaev.Runner;

public class Bot extends TelegramLongPollingBot {

	private static final String CONFIG_FILE = "config";

	private static final String NAME_BOT_CONFIG = "BOTNAME";
	private static final String TOKEN_CONFIG = "TOKEN";

	ResourceBundle config = null;

	public static void main(String[] args) {
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new Bot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	public Bot() {
		config = ResourceBundle.getBundle(CONFIG_FILE);
	}

	public String getBotUsername() {
		return config.getString(NAME_BOT_CONFIG);
	}

	public String getBotToken() {
		return config.getString(TOKEN_CONFIG);
	}

	public void onUpdateReceived(Update update) {
		System.out.println(update.getMessage().getText());

		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(update.getMessage().getChatId());
		sendMessage.setText(Runner.mainMethod().toString());
		ReplyKeyboardMarkup emptyKeyboard = new ReplyKeyboardMarkup();
		sendMessage.setReplyMarkup(emptyKeyboard);
		sendMsg(sendMessage);
	}

	public void sendMsg(SendMessage sendMessage) {
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}
