import java.io.*;
import java.net.*;
import java.util.ArrayList;

import messageUtils.*;

public class server extends Thread
{
	private static ArrayList<String> user_list = new ArrayList<String>();

    public void run() 
	{

    }

    public static void main(String[] args) 
	{
		String user;
		String input, output;
		int port = Integer.parseInt(args[0]);

        try {
            //TODO: replace host and port number with appropriate 
            //  keywords id's to allow connections other than localhost
            ServerSocket s_socket = new ServerSocket(port);
            Socket connection_socket = s_socket.accept();

			//very placeholder, will likely move individual thread stuff into
			//a separate class file, just trying to get things up and running
			PrintWriter out = new
			Printwriter(connection_socket.getOutputStream(), true);

			BufferedReader in = new BufferedReader(new
			InputStreamReader(connection_socket.getInputStream()));
				
			while ((input = in.readLine()) != null) {
				output = input;
				System.out.println(output);
				out.println(output);
			}

            //TODO: create thread that listens for incoming requests,
            //  see if username is taken, then add/deny user
			if (check_list(user)) {
			
			} else {

			}

            //TODO: create listening thread for messages from users,
            //  and distribute according to scope (public/whisper)
			

            //TODO: handle disconnect request of users
			update_list(1, user);

            s_socket.close();
        } catch (Exception e) {
			System.err.println("Error assigning socket");
			System.exit(0);
        }
    }

	/**
	 * Private method for the server to update the active user list, also
	 * prints corresponding actions to terminal.
	 *
	 * @param action add/remove user, corresponding to values of 0 and 1
	 * 				respectively
	 *
	 * @param username User upon which action should take place
	 *
	 */
	private static void update_list(int action, String username) 
	{
		//Possibly switch over to if/else, using switch for safety with default

		switch(action) {
			case 0:
				user_list.add(username);
				System.out.println("'" + username + "' connected");
				break;

			case 1:
				for (int i = 0; i < user_list.size(); i++) {
					if (user_list.get(i).equals(username)) {
						user_list.remove(i);
						System.out.println("'" + username + "' disconnected");
						break;
					}
				}
				break;

			default:
				System.out.println("Invalid operation value");
				break;
			}
	}

	/**
	 * Private method for server to determine uniqueness of client username
	 *
	 * @param username unique id with which user attempts to connect
	 * @return boolean determining if username is available (true if so)
	 *
	 */
	private static boolean check_list(String username) 
	{
		boolean valid = true;

		for (int i = 0; i < user_list.size(); i++) {
			if (user_list.get(i).equals(username)) {
				valid = false;
				break;
			}
		}

		return valid;
	}

	/**
	 * Public method for client to request the user list.
	 *
	 * @return Arraylist containing connected users
	 *
	 */
	public static ArrayList<String> request_list() 
	{
		// Very placeholder, determine how requests will be handled via sockets.
		return	user_list;
	}
}
