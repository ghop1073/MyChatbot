package chat.view;

import javax.swing.*;
import chat.controller.ChatController;
import java.awt.event.*;
import java.awt.Color;
/**
 * 
 * @author ghop1073
 *
 */

public class ChatPanel extends JPanel
{
	
	private ChatController chatController;
	private JButton chatterButton;
	private JTextArea chatText;
	private SpringLayout mainLayout;
	private JTextField typingField;
	private JButton getTweet;
	private JButton sendTweet;
	private JButton analyzeTwitterButton;
	private JButton saveButton;
	private JButton loadButton;
	
	
	public ChatPanel(ChatController chatController)
	{
				
		this.chatController = chatController;
		mainLayout = new SpringLayout();
		chatterButton = new JButton("Click");
		chatText = new JTextArea("Input will be placed here ");
		getTweet = new JButton("Tweet");
		analyzeTwitterButton = new JButton("Check Twitter");
		sendTweet = new JButton("Tweet");
		
		
		setupPanel();
		setupLayout();
		setupListeners();

	}
	
	private void setupPanel()
	{
		this.setLayout(mainLayout);
		this.add(chatterButton);
		this.add(chatText);
		this.add(sendTweet);
		this.add(analyzeTwitterButton);
		
		setForeground(Color.WHITE);
		setBackground(Color.CYAN);
		chatText.setEnabled(false);
		chatText.setForeground(new Color(0, 0, 0));
		chatText.setBackground(new Color(250, 250, 210));
		chatText.setColumns(15);
		chatText.setLineWrap(true);
		typingField = new JTextField("",15);
		typingField.setBackground(new Color(250, 250, 210));
		chatterButton.setForeground(new Color(0, 0, 0));
		chatterButton.setBackground(new Color(250, 250, 210));
		add(typingField);

		
		
	}
	
	/**
	 * "Junk method for all our layout code.
	 */
	private void setupLayout()
	{
		mainLayout.putConstraint(SpringLayout.SOUTH, chatterButton, -10, SpringLayout.SOUTH, this);
		mainLayout.putConstraint(SpringLayout.EAST, chatterButton, -10, SpringLayout.EAST, this);
		mainLayout.putConstraint(SpringLayout.NORTH, chatText, 33, SpringLayout.NORTH, this);
		mainLayout.putConstraint(SpringLayout.WEST, chatText, -406, SpringLayout.EAST, this);
		mainLayout.putConstraint(SpringLayout.SOUTH, chatText, 229, SpringLayout.NORTH, this);
		mainLayout.putConstraint(SpringLayout.EAST, chatText, -39, SpringLayout.EAST, this);
		mainLayout.putConstraint(SpringLayout.NORTH, typingField, -1, SpringLayout.NORTH, chatterButton);
		mainLayout.putConstraint(SpringLayout.WEST, typingField, 10, SpringLayout.WEST, this);
		mainLayout.putConstraint(SpringLayout.NORTH, sendTweet, 0, SpringLayout.NORTH, this);
		mainLayout.putConstraint(SpringLayout.NORTH, analyzeTwitterButton, 0, SpringLayout.NORTH, sendTweet);
		mainLayout.putConstraint(SpringLayout.WEST, sendTweet, 20, SpringLayout.WEST, this);
		mainLayout.putConstraint(SpringLayout.EAST, analyzeTwitterButton, -21, SpringLayout.EAST, this);
		
	}
	
	private void setupListeners()
	{
		chatterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
				//give text to chatbot √
				//give chatbots answer √
				String userText = typingField.getText();//grab user text √
				String response = chatController.fromUserToChatbot(userText);//send text to controller √
				chatText.append("\nUser: " + userText);//display text √
				chatText.append("\nChatbot: " + response); //display answer √
				typingField.setText(""); //clear user field √ 
			}
	});	
	
	sendTweet.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent click)
		{
			chatController.sendTweet("no text to send");
		}
	}
	);
	analyzeTwitterButton.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent click)
		{
			String user = typingField.getText();
			String results = chatController.analyze(user);
			chatText.setText(results);
		}
	});
	}

	public JTextField getTextField()
	{
		return typingField;
	}


	
	
	
}

