package messageUtils;

import javax.swing.*;

public class messageBox {
	JFrame messageFrame;

	public messageBox(String message) {
		messageFrame = new JFrame();
		JOptionPane.showMessageDialog(messageFrame, message);
	}
}
