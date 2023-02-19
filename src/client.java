import gui.*;
import messageUtils.*;
import java.io.*;  
import java.net.*;  
import java.awt.event.*;
import java.util.ArrayList;

public class client extends Thread {
    ArrayList<String> user_list;

    private loginWindow login;
    private chatWindow chat;
    private userWindow activeUsers;
    private String username = "";

    Socket connection_socket;
    ObjectInputStream messageIn;
    ObjectOutputStream messageOut;

    /* public void run() {
        
    } */

    public static void main(String[] args) {

        /* try {
            //TODO: replace host and port number with appropriate 
            //  keywords id's to allow connections other than localhost
            connection_socket = new Socket("localhost", 6666);
            messageIn = new ObjectInputStream(connection_socket.getInputStream());
            messageOut = new ObjectOutputStream(connection_socket.getOutputStream());

            //TODO: create thread to listen for incoming messages +
            //  separata thread for sending messages

            //TODO: handle disconnecting by sending appropriate request to server
            //  and wait for confirmation before closing connection and exiting
            
            connection_socket.close();
        } catch (Exception e) {
            //TODO: add error handling
        } */

        client Client = new client();
        Client.setupLogin();
        
        //System.exit(0);
    }

    private void setupLogin() {
        login = new loginWindow();
        login.loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.loginFrame.setVisible(false);
                username = login.usernameField.getText();

				if (checkUsername(username)) {
                    if (requestConnection(username)) {
                        try {
                            //TODO: connect to server
                            setupChat();
                        } catch(Exception ex) {
                            showMessage("Error: Failed to connect to server");
                            System.exit(1);
                        }
                    } else {
                        showMessage("Username '" + username + "' is already taken. Please enter a unique username");
                        setupLogin();
                    }
                } else {
                    setupLogin();
                }
			}
		});
    }

    void setupChat() {
        chat = new chatWindow();
        setupActiveUsers();
        activeUsers.userListFrame.setVisible(false);
        chat.toggleUserButton.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					activeUsers.userListFrame.setVisible(true);
                    updateActiveUsers();
				} else {
					activeUsers.userListFrame.setVisible(false);
				}

			}
        });

        chat.sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String content = chat.messageField.getText();
				String[] data = processMessage(content);
                String target = data[0];
                String message = data[1];
                showMessage("target: " + target + "\nmessage: " + message);
                sendMessage(username, target, message);
                chat.messageField.setText("");
			}
		});
    
    }

    void setupActiveUsers() {
        activeUsers = new userWindow();
        /* user_list = new ArrayList<String>();
        user_list.add("sanjay"); */
        updateActiveUsers();
    }

    void updateActiveUsers() {
        //TODO: request userlist from server and update activeUsers accordingly
    }

    boolean checkUsername(String username) {
        boolean lengthMin = true;
        //TODO: add more restrictions to username here, like character limit, must start with letter and forbidden characters
        if (username.length() < 4) {
            lengthMin = false;
        }

        if (!lengthMin) {
            String error = "You username violated the following:\n";
            error += "-Username must be at least 4 characters long";
            showMessage(error);
        }
        
        return lengthMin;
    }
    
    void showMessage(String message) {
        messageBox display;
        display = new messageBox(message);
    }

    boolean requestConnection(String username) {
        //TODO: send connection request to server, return result
        return true;
    }

    //check if whisper prompt is used, target exists and returns appropriate target and message
    String[] processMessage(String content) {
        String target = "";
        String message;
        int i;
        if (content.startsWith("@")) {
            for (i = 1; i < content.length(); i++) {
                if (content.charAt(i) == ' ') {
                    break;
                } else {
                    target += content.charAt(i);
                }
            }

            if (user_list.contains(target)) {
                message = content.substring(i);
                //showMessage("target = " + target);
                String[] result = {target, message};
                return result;
            }            
        }
        String[] result = {"n/a", content};
        return result;
    }

    boolean sendMessage(String username, String target, String message) {
        message mess = new message();
        
        mess.setSender(username);
        mess.setMessage(message);
        mess.setWhispered(!target.equals("n/a"));
        mess.setReceiever(target);

        //TODO: serialize mess and send through objectoutputstream messageOut
        
        return true;
    }
    
}