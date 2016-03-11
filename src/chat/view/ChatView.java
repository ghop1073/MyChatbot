package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * handles all our gui components with pop ups and user input pop ups
 * @author nhay7834
 * @version 1.0 10/21/15
 */

public class ChatView
{
	
	private String windowMessage;
	private ImageIcon chatIcon;
	
	/**
	 * Displays pop up with a picture
	 */
	public ChatView()
	{
		windowMessage = "THis Messag is brought to you by chatbot";
		chatIcon = new ImageIcon(getClass().getResource("images/satan.png"));
	}
	

	/**
	 * This method will get the users
	 * 
	 * @param input
	 *            : Holds the user Input.
	 * @return returns the users answer to show.
	 */

	public String getUserText(String wordsShowing)
	{
		String answer = "";

		answer = JOptionPane.showInputDialog(null, wordsShowing, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon, null, "Type here plz").toString();

		return answer;
	}

	/**
	 * This will show the user their input dialog.
	 * 
	 * @param displayText
	 *  What is going to be displayed on the screen
	 */

	public void displayUserText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon);
	}

}
