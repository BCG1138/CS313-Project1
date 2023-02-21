package messageUtils;

import java.io.Serializable;
import java.util.ArrayList;

public class updateUsers implements Serializable{
    private ArrayList<String> userList = new ArrayList<String>();
    private String activeUsers;

    public updateUsers(String list) {
        activeUsers = list;
    }

    public updateUsers(ArrayList<String> arrlist) {
        userList = arrlist;
        activeUsers = userList.toString().replace("[", "");
        activeUsers = userList.toString().replace("]", "");
        activeUsers.replace(", ", "\n");
        activeUsers += "\n";
    }

    public String getUsersString() {
        return activeUsers;
    }

    public ArrayList<String> getUsersArrayList() {
        return userList;
    }
}
