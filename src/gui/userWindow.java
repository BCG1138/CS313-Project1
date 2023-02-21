package gui;

import javax.swing.*;
//import java.awt.event.*;

public class userWindow {
    public JFrame userListFrame = new JFrame("CS313 Project 1");

    public userWindow(){
        //////////////////////////user window///////////////////////////////
		//text area
		JTextArea userListDisplay = new JTextArea();
		userListDisplay.setBounds(30, 50, 240, 400);
		userListDisplay.setEditable(false);

		//label
		JLabel userListLabel = new JLabel("Active users");
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
    
}
