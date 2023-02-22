import java.io.*;
import java.net.*;
import messageUtils.*;
import java.util.ArrayList;

/**
 * Second half of server side, this class contains the threads for individual
 * clients as well as the processing and routing of messages between them.
 */
public class serverThread extends Thread {
	private Socket socket = null;
	private String username = "";
	private ArrayList<String> userlist;
	private boolean whisper;
	private String receiver, content;
	//private message messageout;

	/**
	 * Constructor for creating the client thread
	 *
	 * @param socketin Socket thread will run on
	 */
	public serverThread(Socket socketin) {
		socket = socketin;
	}

	/**
	 * Run method for the thread itself, creates in/out streams and processes
	 * incoming messages, checking for various commands, afterwards routes the 
	 * output back to the other clients.
	 */
	public void run() {
		String input,output;

		try {
			//TODO: change in/out streams to ObjectIn/Out streams
			//PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			//BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//TODO: figure out how fileinputstreams work with OIS
		ObjectInputStream messageIn = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream messageout = new ObjectOutputStream(socket.getOutputStream())
		} catch (Exception e) {
			System.err.println("Failed to create data streams");
		}

		//TODO: rewrite following loop with variables pulled from the message object
		//and make use of the new message box in main class
		while ((input = in.readLine()) != null) {
			if (input.equals("Disconnect")) {
				server.update_list(1, username);
				break;
			}

			if (username.equals("")) {
				if (server.check_valid(input)) {
					server.update_list(0, input);
					username = input;
				} else {
					out.println("Invalid username");
					break;
				}
			}

			if (input.equals("Update List")) {
				userlist = server.request_list();

				for (int i = 0; i < userlist.size; i++) {
					out.println(userlist.get(i));
				}
				out.println("End of List");
			}
		
			out.println(output);
		}

		messageIn.close();
		socket.close();
	}
}
