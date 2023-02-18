package gui;

//TODO: decide what gui components to use, then add/remove relevant imports

import javax.swing.*;

public class GUI 
{
    public static JFrame frame = new JFrame("CS313 Project 1");
    
    //TODO: declare gui components like buttons, menus, textboxes here

    //gui constructor
    public GUI() 
	{
	 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.setSize(250, 200);
	  	frame.setLayout(null);
	  	frame.setVisible(true);
		frame.setLocationRelativeTo(null);

      	//TODO: initialize gui components here

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
