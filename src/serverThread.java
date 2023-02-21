import java.io.*;
import java.net.*;

import java.util.ArrayList;

public class serverThread extends Thread {
	private String username = "";
	private Socket socket = null;
	private ArrayList<String> userlist;

	public serverThread(Socket socketin) {
		this.socket = socketin;
	}

	public void run() {
		String input,output;

		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception e) {
			System.err.println("Failed to create data streams");
		}

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
		
			//TODO: determine how to get "input" from other threads
			out.println(output);
		}

		socket.close();
	}
}
