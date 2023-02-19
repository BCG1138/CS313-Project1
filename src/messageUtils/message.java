package messageUtils;

import java.io.Serializable;

public class message implements Serializable {
    private String messageSender;
    private boolean messageWhisper;
    private String messageReceiver;
    private String messageContent;

    @Override
    public String toString() {
        return messageSender + ": " + messageContent + "\n";
    }

    public message(){
        messageSender = "";
        messageWhisper = false;
        messageReceiver = "n/a";
        messageContent = "";
    }

    public message(String sender, String message) {
        messageSender = sender;
        messageWhisper = false;
        messageReceiver = "n/a";
        messageContent = message;
    }

    public message(String sender, String receiver, String message) {
        messageSender = sender;
        messageWhisper = true;
        messageReceiver = receiver;
        messageContent = message;
    }

    public String getSender() {
        return messageSender;
    }

    public String getReceiever() {
        return messageReceiver;
    }

    public boolean isWhispered() {
        return messageWhisper;
    }

    public String getMessage() {
        return messageContent;
    }

    public void setSender(String sender) {
        messageSender = sender;
    }

    public void setReceiever(String receiver) {
        messageReceiver = receiver;
    }

    public void setWhispered(boolean whispered) {
        messageWhisper = whispered;
    }

    public void setMessage(String message) {
        messageContent = message;
    }


}