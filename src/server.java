import java.io.*;  
import java.net.*;

class server extends Thread{
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
}
