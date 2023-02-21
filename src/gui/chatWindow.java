package gui;

import javax.swing.*;

public class chatWindow {
    public JFrame chatFrame = new JFrame("CS313 Project 1");
    public JTextArea chatDisplay = new JTextArea();
    public JTextField messageField = new JTextField();
    public JButton sendButton = new JButton("Post");
    public JToggleButton toggleUserButton = new JToggleButton("Users");

    public chatWindow() {
		//text area
		chatDisplay.setBounds(50, 50, 700, 400);
		chatDisplay.setEditable(false);
		chatDisplay.setLineWrap(true);

		//textfield
		messageField.setBounds(50, 475, 625, 30);

		//button
		sendButton.setBounds(675, 475, 75, 30);

		//toggle button
		toggleUserButton.setBounds(675, 505, 75, 30);

		//frame adds
		chatFrame.add(chatDisplay);
		chatFrame.add(messageField);
		chatFrame.add(sendButton);
		chatFrame.add(toggleUserButton);

		//frame code
		chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chatFrame.setSize(800,600);
		chatFrame.setLayout(null);
		chatFrame.setVisible(true);
		chatFrame.setLocationRelativeTo(null);
    }
    
}
