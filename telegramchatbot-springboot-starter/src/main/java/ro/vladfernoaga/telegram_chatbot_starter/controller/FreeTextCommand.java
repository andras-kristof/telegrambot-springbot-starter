package ro.vladfernoaga.telegram_chatbot_starter.controller;

public enum FreeTextCommand {
	
	
	INLINE_COMMAND("/inline",new InlineCommandAction() ),
	START_COMMAND("/signup",new RegisterCommandAction() ),
	ADDMEDICATION_COMMAND("/addmedication", new AddMedicationCommand())
	;
	
	private String commandText;
	private MessageCommandAction action;
	
	
	private FreeTextCommand(String commandText, MessageCommandAction action) {
		this.commandText = commandText;
		this.action = action;
	}


	public String getCommandText() {
		return commandText;
	}


	public MessageCommandAction getAction() {
		return action;
	}
	
	
}
