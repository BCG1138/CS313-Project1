package packages.gui;
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
		//text box
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
		//label
		JLabel l = new JLabel("Enter Username");
		l.setBounds(75, 20, 100, 30);
		///////////////////////////////////////////////////////

		/////////////////////frame adds//////////////////////////
		frame.add(un);
		//button
		JButton b = new JButton("Log in");
		b.setBounds(75, 100, 100, 30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				un.setText("werk");
			}
		});

		//frame adds
		frame.add(b);
		frame.add(un);
		frame.add(l);
		////////////////////////////////////////////////////////

		//////////////////////////frame code//////////////////////
		//frame code
	 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.setSize(250, 200);
	  	frame.setLayout(null);
	  	frame.setVisible(true);
	  	frame.setVisible(false);
		frame.setLocationRelativeTo(null);
		//////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////


		cwf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cwf.setSize(800,600);
		cwf.setLayout(null);
		cwf.setVisible(true);
		cwf.setLocationRelativeTo(null);
    }
}

