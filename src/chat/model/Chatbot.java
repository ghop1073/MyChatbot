package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part of the project.
 * 
 * @author Nick Haynes
 * @version 1.6 10/28/15 Updated and created a switch method of conversation.
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;

	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * 
	 * @param userName
	 *            The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.userName = userName;
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.content = "Getting yolked";

		buildMemesList();
		buildPoliticalTopicsList();
	}

	/**
	 * this has all the values we put in our memesList with the .add
	 */
	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("Farmer memes");
		this.memesList.add("John Cena");
		this.memesList.add("Pepe");
		this.memesList.add("Donald Trump");
		this.memesList.add("Spoopy");
		this.memesList.add("SkeletonWar");
		this.memesList.add("Do you even lift bro?");
		this.memesList.add("Spooterman");

	}

	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("election");
		this.politicalTopicList.add("Democrat");
		this.politicalTopicList.add("Republican");
		this.politicalTopicList.add("liberal");
		this.politicalTopicList.add("conservative");
		this.politicalTopicList.add("Trump");
		this.politicalTopicList.add("Clinton");
		this.politicalTopicList.add("Biden");
		this.politicalTopicList.add("Carson");
		this.politicalTopicList.add("Rubio");
		this.politicalTopicList.add("Fiorina");
		this.politicalTopicList.add("Sanders");
		this.politicalTopicList.add("vote");
		this.politicalTopicList.add("11/4/16");
		this.politicalTopicList.add("Bush did 9/11");

	}

	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null, otherwise returns true.
	 * 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;

		if (currentInput != null)
		{
			if (currentInput.length() > 0)
			{
				hasLength = true;
			}
		}

		return hasLength;
	}

	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;

		if (currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}

		return hasContent;
	}

	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns true if it does find a match and false if it does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPoliticalTopic = false;
		
		for (String politicalTopic : politicalTopicList)
		{
			if(currentInput.toLowerCase().equals(politicalTopic.toLowerCase()))
			{
				hasPoliticalTopic = true;
			}
		}
		
		
		return hasPoliticalTopic;
	}

	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMemes = false;

		for (String meme : memesList)
		{
			if (currentInput.toLowerCase().equals(meme.toLowerCase()))
			{
				hasMemes = true;
			}

		}
		return hasMemes;
	}
	
	
	public boolean quitChecker(String currentInput)
	{
		boolean isQuit = false;
		
		if(currentInput.toLowerCase().contains("quit"))
		{
			isQuit = true;
		}
		return isQuit;
	}
	
	
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean isMash = false;
		
		if(currentInput.toLowerCase().contains("dfg")) 
		{
			isMash = true;
		}
		
		if(currentInput.toLowerCase().contains("sdf"))
		{
			isMash = true;
		
		}
		
		if (currentInput.toLowerCase().contains("cvb"))
		{
			isMash = true;
		}
		
		if(currentInput.toLowerCase().contains(",./"))
		{
			isMash = true;
		}
		
		return isMash;
	
	}
	
	
	public String processQuestion(String currentInput)
	{
		String nextConversation = "What else what would you like to talk about?";
		;
		int randomTopic = (int) (Math.random() * 5);

		switch (randomTopic)
		{
		case 0:
			if(contentChecker(currentInput))
			{
				nextConversation = "Hey you said my favorite thing! What else do you like?";
			}
			break;
		case 1:
			if(memeChecker(currentInput))
			{
				nextConversation = "That is a pretty ank meme bro way to stay current";
			}
			break;
		case 2:if(politicalTopicChecker(currentInput))
			{
				nextConversation = "Wow I hate trump too! Do you like bernie??";
			}
			break;
		case 3: if(currentInput.contains("yolked"))
		{
			nextConversation = "Wow you seem prety cool. Do you like to be a asshole in public?";
		}
			
			break;
		case 4:
			
			nextConversation ="Boy you are sure dandy! have you heard of our true lord and savior and dark prince? His name is Satan. ";
			
			break;
		default:
			nextConversation = "I love me some satan. Do you like warlocks?";
			break;
		}

		return nextConversation;
	}

	/**
	 * Returns the username of this Chatbot instance.
	 * 
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * Returns the content area for this Chatbot instance.
	 * 
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * Getter method for the memesList object.
	 * 
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}

	/**
	 * Getter method for the politicalTopicList object.
	 * 
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}

	/**
	 * Updates the content area for this Chatbot instance.
	 * 
	 * @param content
	 *            The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

}
