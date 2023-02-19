import packages.*;
import java.io.*;  
import java.net.*;  

class Client extends Thread{
    public void run() {
        
    }

    public static void main(String[] args) {
        try {
            //TODO: replace host and port number with appropriate 
            //  keywords id's to allow connections other than localhost
            Socket connection_socket = new Socket("localhost", 6666);

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

