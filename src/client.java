import gui.*;
//import messageUtils.*;
import java.io.*;  
import java.net.*;  

public class client extends Thread{
    String username = "";

    public void run() {
        
    }

    public static void main(String[] args) {

        try {
            //TODO: replace host and port number with appropriate 
            //  keywords id's to allow connections other than localhost
            Socket connection_socket = new Socket("localhost", 6666);
            ObjectInputStream messageIn = new ObjectInputStream(connection_socket.getInputStream());
            ObjectOutputStream messageOut = new ObjectOutputStream(connection_socket.getOutputStream());

            //TODO: get username through use of InputDialogBox and
            //  MessageBox (see gui.java)

            //TODO: send username to server, prompt for new one if necessary


            //TODO: create thread to listen for incoming messages +
            //  separata thread for sending messages

            //TODO: handle disconnecting by sending appropriate request to server
            //  and wait for confirmation before closing connection and exiting
            
            connection_socket.close();
        } catch (Exception e) {
            //TODO: add error handling
        }
    }
}

