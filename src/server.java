import java.io.*;
import java.net.*;
import java.util.ArrayList;
import messageUtils.*;
import java.util.concurrent.locks.*;
//import java.util.concurrent.locks.ReadWriteLock;
//import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * First half of the server implementation, this class contains the setup of the
 * port as well as the listener for incoming connections. It also contains
 * various static methods allowing the threads to adapt and request the list of
 * users as necessary.
 */
public class server
{
	private static ArrayList<String> user_list = new ArrayList<String>();
	private static ArrayList<message> inbox = new ArrayList<message>();
	private static final ReadWriteLock readwrite_lock = new ReentrantReadWriteLock();
	private static final Lock write_request = readwrite_lock.writeLock();
	private static final Lock read_request = readwrite_lock.readLock();

	/**
	 * Setup of the port and listener.
	 *
	 * @param args command line arguments, containing the port
	 */
    public static void main(String[] args) 
	{
		boolean listen = true;
		int port = Integer.parseInt(args[0]);

        try (ServerSocket s_socket = new ServerSocket(port)) {
			while (listen) {
				new serverThread(s_socket.accept()).start();
			}

            //TODO: create listening thread for messages from users,
            //  and distribute according to scope (public/whisper)
			
        } catch (Exception e) {
			System.err.println("Error listening on port " + port);
			System.exit(0);
        }
    }

	/**
	 * Public method for the server to update the active user list, also
	 * prints corresponding actions to terminal.
	 *
	 * @param action add/remove user, corresponding to values of 0 and 1
	 * 				respectively
	 *
	 * @param username User upon which action should take place
	 *
	 */
	public static void update_list(int action, String username) 
	{
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
	 * Public method for server to determine uniqueness of client username
	 *
	 * @param username unique id with which user attempts to connect
	 * @return boolean determining if username is available (true if so)
	 *
	 */
	public static boolean check_list(String username) 
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

	/**
	 * Public method allowing threads to add new messages to the global inbox
	 *
	 * @param mess_in Inbound message coming from client thread
	 */
	public static void update_inbox(message mess_in)
	{
		write_request.lock();
		try {
			inbox.add(mess_in);
		} finally {
			write_request.unlock();
		}
	}

	/**
	 * Public method allowing threads to read new messages from the global
	 * inbox, a lock is implemented to prevent multiple threads reading at once.
	 *
	 * @return message returns a new message object to the thread
	 */
	public static message access_inbox()
	{
		read_request.lock();
		message mess_out = new message();

		try {
			mess_out = inbox.get(inbox.size() - 1);

		} finally {
			read_request.unlock();
		}

		return mess_out;
	}
}
