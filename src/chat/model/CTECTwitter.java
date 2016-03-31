package chat.model;

import twitter4j.*;

import java.util.ArrayList;

import chat.controller.ChatController;

import java.util.*;
import java.io.*;

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
	
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("<Gage Hopkins> I just tweeted from my Java Chatbot program @ChatbotCTEC!");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
		
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!;:\"(){}^[]<>-";
		
		String scrubbedString="";
		for(int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	
	private void removeEmptyText()
	{
		for(int spot = 0; spot < wordsList.size(); spot++)
		{
			if(wordsList.get(spot).equals(""))
			{
				wordsList.remove(spot);
				spot--;
			}
		}
	}
	
	private List removeCommonEnglishWords(List<String> wordList)
	{
		String[] boringWords = importWordsToArray();
		for(int count = 0; count < wordList.size(); count++)
		{
			for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if(wordsList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length;
				}
			}
		}
		return wordList;
	}
	
	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordCount = 0;
		
			Scanner wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
			while(wordFile.hasNext())
			{
				wordCount++;
				wordFile.next();
			}
			wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
			boringWords = new String[wordCount];
			int boringWordCount = 0;
			while(wordFile.hasNext())
			{
				boringWords[boringWordCount] = wordFile.next();
				boringWordCount++;
			}
			wordFile.close();
			
		return boringWords;
	}
	
	public String  topResults()
	{
		String tweetResults= "";
		
		int topWordLocation = 0;
		int topCount = 0;
		
		for(int index = 0; index < wordsList.size(); index++)
		{
			int wordUseCount = 1;
			
			for(int spot = index + 1; spot < wordsList.size(); spot++)
			{
				if(wordsList.get(index).equals(wordsList.get(spot)))
				{
					wordUseCount++;
				}
				if(wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}
		tweetResults = "The top word in the tweets was " + wordsList.get(topWordLocation) + " and it was used " + topCount + " times!";
		return tweetResults;
	}

	public void loadTweets(String userName) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while(page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(userName, statusPage));
			page++;
		}
		for(Status currentStatus : statusList)
		{
			statusList.clear();
			wordsList.clear();
			String[] tweetText = currentStatus.getText().split(" ");
			for(String word : tweetText)
			{
				wordsList.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(wordsList);
		removeEmptyText();
	}
//	
//	public String sampleInvestigation()
//	{
//		String results = "";
//		
//		Query query = new Query("school");
//		query.setCount(100);
//		query.setGeoCode(new GeoLocation(40.587521, -111.869178), 5, Query.MILES);
//		query.setSince("2016-1-1");
//		try
//		{
//			QueryResult result = chatbotTwitter.search(query);
//			results.concat("Count : " + results.getTweets().size());
//			for(Status tweet)
//			
//		}
//	}
//	
}
