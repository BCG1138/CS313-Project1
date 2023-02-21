package gui;

import javax.swing.*;

public class userWindow {
    JFrame userListFrame = new JFrame("CS313 Project 1");
	JTextArea userListDisplay = new JTextArea();
	JLabel userListLabel = new JLabel("Active users");

    public userWindow(){
		//text area
		userListDisplay.setBounds(30, 50, 240, 400);
		userListDisplay.setEditable(false);

		//label
		userListLabel.setBounds(30, 20, 100, 30);

		//frame adds
		userListFrame.add(userListDisplay);
		userListFrame.add(userListLabel);

		//frame code
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
