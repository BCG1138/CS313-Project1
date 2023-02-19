package gui;
//TODO: decide what gui components to use, then add/remove relevant imports
import javax.swing.*;
import java.awt.event.*;
public class GUI 
{
    public static JFrame frame = new JFrame("CS313 Project 1");
	public static JFrame cwf = new JFrame("CS313 Project 1");
	public static JFrame uf = new JFrame("CS313 Project 1");

    //gui constructor
    public GUI() 
	{
		//text box
		JTextField un = new JTextField();
		un.setBounds(50, 50, 150, 30);

		//label
		JLabel l = new JLabel("Enter Username");
		l.setBounds(75, 20, 100, 30);

		//button
		JButton b = new JButton("Log in");
		b.setBounds(75, 100, 100, 30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				cwf.setVisible(true);
			}
		});

		//frame adds
		frame.add(b);
		frame.add(un);
		frame.add(l);

		//frame code
	 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.setSize(250, 200);
	  	frame.setLayout(null);
	  	frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		//////////////////////////////////////////////////////////////////////
		//text area
		JTextArea chat = new JTextArea();
		chat.setBounds(50, 50, 700, 400);
		chat.setEditable(false);
		chat.setLineWrap(true);

		//textfield
		JTextField chmg = new JTextField();
		chmg.setBounds(50, 475, 625, 30);

		//button
		JButton cb = new JButton("Post");
		cb.setBounds(675, 475, 75, 30);

		//toggle button
		JToggleButton tb = new JToggleButton("Users");
		tb.setBounds(675, 505, 75, 30);
		ItemListener il = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					uf.setVisible(true);
				} else {
					uf.setVisible(false);
				}
			}
		};

		tb.addItemListener(il);

		//frame adds
		cwf.add(chat);
		cwf.add(chmg);
		cwf.add(cb);
		cwf.add(tb);

		//frame code
		cwf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cwf.setSize(800,600);
		cwf.setLayout(null);
		cwf.setVisible(false);
		cwf.setLocationRelativeTo(null);

		////////////////////////////////////////////////////////////////////
		//texxt area
		JTextArea ua = new JTextArea();
		ua.setBounds(30, 50, 240, 400);
		ua.setEditable(false);

		//label
		JLabel cl = new JLabel("Active users");
		cl.setBounds(30, 20, 100, 30);

		//frame adds
		uf.add(ua);
		uf.add(cl);

		//frame code
		uf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	uf.setSize(300, 500);
	  	uf.setLayout(null);
	  	uf.setVisible(false);
		uf.setLocation(10, 60);

    }
}

