package chat.controller;

import twitter4j.TwitterException;
import chat.view.*;
import chat.model.CTECTwitter;
import chat.model.Chatbot;

/**
 * Controller for the chatbot project.
 * 
 * @author ghop1073
 * @version 1.1 3/2/15
 */

public class ChatController
{
	private Chatbot gageChatBot;
	private ChatView chatDisplay;
	private ChatFrame baseFrame;
	private ChatPanel basePanel;
	private CTECTwitter myTwitter;

	public ChatController()
	{
		myTwitter = new CTECTwitter(this);
		chatDisplay = new ChatView();
		String user = chatDisplay.getUserText("What is your name?");
		gageChatBot = new Chatbot(user);
		baseFrame = new ChatFrame(this);

	}
	
	
	/**
	 * Gets our username.
	 */
	public void start()
	{
		chatDisplay.displayUserText("Hello " + gageChatBot.getUserName());
		//chat();
	}

	/**
	 * Will return the latest text from our user.
	 */
	
	public String fromUserToChatbot(String conversation)
	{
		String botResponse = "";
		
		if(gageChatBot.quitChecker(conversation))
		{
			shutDown();
		}
		botResponse = gageChatBot.processQuestion(conversation);
		
		return botResponse;
	}

	private void chat()
	{
		String conversation = chatDisplay.getUserText("Talk to the chatbot");

		while (gageChatBot.lengthChecker(conversation))
		{
			conversation = gageChatBot.processQuestion(conversation);
			conversation = chatDisplay.getUserText(conversation);

		}
	}

	public Chatbot getgageChatBot()
	{
		return gageChatBot;
	}

	public void setGageChatBot(Chatbot gageChatBot)
	{
		this.gageChatBot = gageChatBot;
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

	public String analyze(String userName)
	{
		String userAnalysis = "The Twitter user " + userName +  " has many tweets. ";
		try
		{
			myTwitter.loadTweets(userName);
		}
		catch(TwitterException error)
		{
			handleErrors(error.getErrorMessage());
		}
		userAnalysis += myTwitter.topResults();
		
		return userAnalysis;
		
		
	}

	public void handleErrors(String errorMessage)
	{
		chatDisplay.displayUserText(errorMessage);
		
	}

	private void shutDown()
	{
		chatDisplay.displayUserText("Goodbye, " + gageChatBot.getUserName() + " it has been my pleasure to talk to you");
		System.exit(0);
	}


	public void sendTweet(String tweet)
	{
		myTwitter.sendTweet(tweet);
	}
}
