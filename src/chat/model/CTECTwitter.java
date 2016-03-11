package chat.model;

import twitter4j.*;
import java.util.ArrayList;
import chat.controller.ChatController;
import java.util.List;

public class CTECTwitter
{

	private ArrayList <Status> statusList;
	private ArrayList <String> wordsList;
	private Twitter chatbotTwitter;
	private ChatController baseController;

	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		this.statusList = new ArrayList <Status>();
		this.wordsList = new ArrayList <String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
	}
	
	public void sendTweet(String message)
	{
		try
		{
			chatbotTwitter.updateStatus("I just tweeted from my Java Chatbot program @ChatbotCTEC!");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
		
	}
}
