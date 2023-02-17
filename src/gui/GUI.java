package gui;

//TODO: decide what gui components to use, then add/remove relevant imports

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class GUI {
    public static JFrame frame = new JFrame("CS313 Project 1");
    
    //TODO: declare gui components like buttons, menus, textboxes here

    //gui constructor
    GUI() {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800, 600);
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
