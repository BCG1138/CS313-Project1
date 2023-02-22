package gui;

import javax.swing.*;

public class userWindow {
    JFrame userListFrame = new JFrame("CS313 Project 1");
	JTextArea userListDisplay = new JTextArea();
	JLabel userListLabel = new JLabel("Active users");

	/**
	 * initializes user window
	 */
    public userWindow() {
		userListDisplay.setBounds(30, 50, 240, 400);
		userListDisplay.setEditable(false);

		userListLabel.setBounds(30, 20, 100, 30);

		userListFrame.add(userListDisplay);
		userListFrame.add(userListLabel);

		userListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      	userListFrame.setSize(300, 500);
	  	userListFrame.setLayout(null);
		userListFrame.setLocation(10, 60);
    }

	public void show() {
		userListFrame.setVisible(true);
	}

	public void hide() {
		userListFrame.setVisible(false);
	}

	public void toggleVisible() {
		userListFrame.setVisible(!userListFrame.isVisible());
	}

	public void updateList (String users) {
		userListDisplay.setText(users);
	}
    
}
