package gui;

import javax.swing.*;
//import java.awt.event.*;

public class loginWindow {
    public JFrame loginFrame = new JFrame("CS313 Project 1");
	public JTextField usernameField = new JTextField();
	public JLabel usernameLabel = new JLabel("Enter Username");
	public JButton loginButton = new JButton("Log in");
    
	public loginWindow() {
    /////////////////////////login window///////////////////////////////
		//text box
		
		usernameField.setBounds(50, 50, 150, 30);

		//label
		usernameLabel.setBounds(75, 20, 100, 30);

		//button
		loginButton.setBounds(75, 100, 100, 30);
		/* loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFrame.setVisible(false);
				loginPressed = true;
				username = usernameField.getText();
				//send username to client
			}
		}); */

		//frame adds
		loginFrame.add(loginButton);
		loginFrame.add(usernameField);
		loginFrame.add(usernameLabel);

		//frame code
		loginFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		loginFrame.setSize(250, 200);
		loginFrame.setLayout(null);
		loginFrame.setVisible(true);
		loginFrame.setLocationRelativeTo(null);
	}
}