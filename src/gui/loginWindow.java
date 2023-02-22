package gui;

import javax.swing.*;

public class loginWindow {
    public JFrame loginFrame = new JFrame("CS313 Project 1");
	public JTextField usernameField = new JTextField();
	public JLabel usernameLabel = new JLabel("Enter Username");
	public JButton loginButton = new JButton("Log in");
    
	/**
	 * initializes loginn window
	 */
	public loginWindow() {
		usernameField.setBounds(50, 50, 150, 30);

		usernameLabel.setBounds(75, 20, 100, 30);

		loginButton.setBounds(75, 100, 100, 30);

		loginFrame.add(loginButton);
		loginFrame.add(usernameField);
		loginFrame.add(usernameLabel);

		loginFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		loginFrame.setSize(250, 200);
		loginFrame.setLayout(null);
		loginFrame.setVisible(true);
		loginFrame.setLocationRelativeTo(null);
	}
}
