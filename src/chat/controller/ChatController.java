package chat.controller;

import chat.view.*;
import chat.model.Chatbot;

/**
 * Controller for the chatbot project.
 * 
 * @author nhay7834
 * @version 1.3 10/23/15 Updated documentation and added a while loop.
 */

public class ChatController
{
	private Chatbot nickChatBot;
	private ChatView chatDisplay;
	private ChatFrame baseFrame;
	private ChatPanel basePanel;

	public ChatController()
	{
		chatDisplay = new ChatView();
		String user = chatDisplay.getUserText("What is your name?");
		nickChatBot = new Chatbot(user);
		baseFrame = new ChatFrame(this);

	}
	
	
	/**
	 * Gets our username.
	 */
	public void start()
	{
		chatDisplay.displayUserText("Hello " + nickChatBot.getUserName());
		//chat();
	}

	/**
	 * Will return the latest text from our user.
	 */
	
	public String fromUserToChatbot(String conversation)
	{
		String botResponse = "";
		
		if(nickChatBot.quitChecker(conversation))
		{
			shutDown();
		}
		botResponse = nickChatBot.processQuestion(conversation);
		
		return botResponse;
	}
	
	private void shutDown()
	{
		chatDisplay.displayUserText("GoodBye, " + nickChatBot.getUserName() + " Loved talking with you");
		System.exit(0);
	}
	
	
	private void chat()
	{
		String conversation = chatDisplay.getUserText("Talk to the chatbot");

		while (nickChatBot.lengthChecker(conversation))
		{
			conversation = nickChatBot.processQuestion(conversation);
			conversation = chatDisplay.getUserText(conversation);

		}
	}

	public Chatbot getNickChatBot()
	{
		return nickChatBot;
	}

	public void setNickChatBot(Chatbot nickChatBot)
	{
		this.nickChatBot = nickChatBot;
	}

	public ChatView getChatDisplay()
	{
		return chatDisplay;
	}

	public void setChatDisplay(ChatView chatDisplay)
	{
		this.chatDisplay = chatDisplay;
	}

	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}

	public void setBaseFrame(ChatFrame baseFrame)
	{
		this.baseFrame = baseFrame;
	}

	public ChatPanel getBasePanel()
	{
		return basePanel;
	}

	public void setBasePanel(ChatPanel basePanel)
	{
		this.basePanel = basePanel;
	}

}
