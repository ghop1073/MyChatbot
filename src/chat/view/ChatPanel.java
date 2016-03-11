package chat.view;

import javax.swing.*;


import chat.controller.ChatController;

import java.awt.event.*;

/**
 * 
 * @author ghop1073
 *
 */

public class ChatPanel extends JPanel
{
	
	private ChatController baseController;
	private SpringLayout baseLayout;
	
	private JButton chatButton;
	private JTextArea chatTextViewer;
	private JTextField chatTextField;
	private JLabel chatLabel;
	
	private ChatFrame baseFrame; 
	
	public ChatPanel (ChatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatButton = new JButton("Submit");
		chatTextViewer = new JTextArea(10,30);
		chatTextField = new JTextField(30);
		chatLabel = new JLabel();
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * adding our GUI components, and setting them up for use. 
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(chatButton);
		this.add(chatTextViewer);
		this.add(chatTextField);
		this.add(chatLabel);
		chatTextViewer.setEnabled(false);
		chatTextField.setToolTipText("Type here for chatBobt");
		chatLabel.setText("Talk to me!");
		
	}
	
	/**
	 * "Junk method for all our layout code.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 181, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -88, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextField, 206, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextField, -54, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatLabel, 0, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatLabel, -25, SpringLayout.NORTH, chatTextField);
		
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Clicked)
			{
				String userText = chatTextField.getText(); //Grab user text
				String response = baseController.fromUserToChatbot(userText); //send the text to the controller.
				
				chatTextViewer.append("\nUser:" + userText); //display user text.
				chatTextViewer.append("\nChatbot:" + response); //display chatbot text.
				chatTextField.setText(""); //clears field.
			}
		});
	}

	
	
	
	
	
	public JTextField getTextField()
	{
		return chatTextField;
	}


	
	
	
}

