import java.io.*;  
import java.net.*;
import java.util.ArrayList;

class server extends Thread{
	ArrayList<String> user_list = new ArrayList<String>();

    public void run() {

    }

    //TODO: create data structure (probably an arraylist) to store usernames

    public static void main(String[] args) {
        try {
            //TODO: replace host and port number with appropriate 
            //  keywords id's to allow connections other than localhost
            ServerSocket s_socket = new ServerSocket(6666);
            Socket connection_socket = s_socket.accept();

            //TODO: create thread that listens for incoming requests,
            //  see if username is taken, then add/deny user

            //TODO: create listening thread for messages from users,
            //  and distribute according to scope (public/whisper)
            //TODO: handle disconnect request of users

            s_socket.close();
        } catch (Exception e) {
            //TODO: add error handling
        }
    }

	/**
	* Private method for the server to update the active user list.
	*
	* @param action add/remove user, corresponding to values of 0 and 1
	* 				respectively
	*
	* @param username User upon which action should take place
	*
	*/
	private static void update_list(int action, String username) {
		//Possibly switch over to if/else, using switch for safety with default

		switch(action):
			case 0:
				user_list.add(username);
				break;

			case 1:
				for (int i = 0; i < user_list.size(); i++) {
					if (user_list.get(i).equals(username)) {
						user_list.remove(i);
						break;
					}
				}
				break;

			default:
				System.out.println("Invalid operation value");
				break;
	}
}
