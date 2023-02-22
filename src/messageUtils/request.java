package messageUtils;

import java.io.Serializable;

public class request implements Serializable {
    /**
     * request types:
     * 0: Connect request
     * 1: Disconnect request
     * 2: Request accepted
     * 3: Request denied
     * 4: Error
     */
    private int requestType;
    private String username;

    public request() {

    }

    public request(int type, String username) {
        requestType = type;
        this.username = username;
    }

    public int getType() {
        return requestType;
    }

    public String getUsername() {
        return username;
    }

    public void setType(int type) {
        requestType = type;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}