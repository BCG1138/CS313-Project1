package gui;

//TODO: decide what gui components to use, then add/remove relevant imports

import javax.swing.*;
import java.awt.event.*;

public class GUI 
{
    public static JFrame frame = new JFrame("CS313 Project 1");
	public static JFrame cwf = new JFrame("CS313 Project 1");
    //gui constructor
    public GUI() 
	{
		////////////////////text box////////////////////////////
		JTextField un = new JTextField();
		un.setBounds(50, 50, 150, 30);
		///////////////////////////////////////////////////////

		////////////////////button////////////////////////////
		JButton b = new JButton("Log in");
		b.setBounds(75, 100, 100, 30);
		//b.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
			
			//}
		//});
		////////////////////////////////////////////////////////

		//////////////////label////////////////////////////////
		JLabel l = new JLabel("Enter Username");
		l.setBounds(75, 20, 100, 30);
		///////////////////////////////////////////////////////

		/////////////////////frame adds//////////////////////////
		frame.add(un);
		frame.add(b);
		frame.add(l);
		////////////////////////////////////////////////////////

		//////////////////////////frame code//////////////////////
	 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.setSize(250, 200);
	  	frame.setLayout(null);
	  	frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		//////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////


    }
}

class MessageBox {
  JFrame tempFrame;

  MessageBox(String message) {
    tempFrame = new JFrame();
    JOptionPane.showMessageDialog(tempFrame, message);
  }
}

class InputDialogBox {
  static JFrame f;
  static String input;

  InputDialogBox(String message) {
    f = new JFrame();
    input = JOptionPane.showInputDialog(f, message);
  }

  public static String getInput() {
    return input;
  }

}
