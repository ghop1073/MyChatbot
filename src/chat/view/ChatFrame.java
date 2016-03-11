package chat.view;

import javax.swing.JFrame;

import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
	
	
	public ChatFrame(ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setSize(600, 600);
		this.setTitle("This isn't boring!");
		this.setVisible(true);
		
	}
	
	public ChatController getBaseController() 
	{
		return baseController;
	}
	
	
	
	
}
