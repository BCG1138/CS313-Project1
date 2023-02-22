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

    static Socket connection_socket;

    /* public void run() {
        
    } */

    public static void main(String[] args) {   
        /* int portNumber;
        portNumber = Integer.parseInt(args[0]);
        try {
            connection_socket = new Socket(InetAddress.getLocalHost(), portNumber);
        } catch (Exception e) {
            //TODO: error handling
            return;
        } */
        
        client Client = new client();
        Client.setupLogin();
    }

    /**
     * creates login window, and adds action events to buttons
     */
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

    /**
     * creates chat window, and adds action events to buttons
     */
    private void setupChat() {
        chat = new chatWindow();
        setupActiveUsers();
        activeUsers.hide();
        chat.toggleUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                activeUsers.toggleVisible();
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

    /**
     * creates active users window, and updates it's list
     */
    private void setupActiveUsers() {
        activeUsers = new userWindow();
        user_list = new ArrayList<String>();
        user_list.add("bencg");
        updateActiveUsers();
    }

    /**
     * requests a new list
     */
    private void updateActiveUsers() {
        //TODO: request userlist from server and update activeUsers accordingly
    }

    /**
     * checks if username passes minimum requirements
     * @param username name of user
     * @return true if username passed, otherwise displays message showing which checks
     *      failed and returns false
     */
    private boolean checkUsername(String username) {
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
    
    private void showMessage(String message) {
        messageBox display = new messageBox(message);
    }

    /**
     * send connection request to server, return result
     * @param username username of client
     * @return true if connection request was accepted, false otherwise
     */
    private boolean requestConnection(String username) {
        try {
            ObjectOutputStream requestStreamOut = new ObjectOutputStream(connection_socket.getOutputStream());
            ObjectInputStream requestStreamIn = new ObjectInputStream(connection_socket.getInputStream());
            request req = new request(1, username);
            request answer;
            requestStreamOut.writeObject(req);
            // wait for request to be accepted or denied
            while ((answer = (request) requestStreamIn.readObject()) != null) {
                if (answer.getUsername().equals(username)) {
                    requestStreamOut.close();
                    requestStreamIn.close();
                    
                    if ( answer.getType() == 2) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            requestStreamOut.close();
            requestStreamIn.close();
        } catch (Exception e) {
            return true;
        }
        return true;
    }

    /**
     * check if whisper prompt is used, target exists and returns appropriate target and message
     * @param content everything typed by the user in the message text field
     * @return the target of the message (where applicable) and the actual content of the message
     */
    private String[] processMessage(String content) {
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

    /**
     * Sends message to server through objectoutputstream using a message object
     * @param username Username of user sending the message
     * @param target Target of message, another user, ("n/a" for public).
     * @param message Content of message
     * @return 1 for message successfully sent, 0 for failure to send
     */
    private boolean sendMessage(String username, String target, String message) {
        message mess = new message();
        
        mess.setSender(username);
        mess.setMessage(message);
        mess.setWhispered(!target.equals("n/a"));
        mess.setReceiever(target);

        //TODO: serialize mess and send through objectoutputstream messageOut, return success/failure

        
        return true;
    }
    
}