package pojo;

import java.util.Date;


public class User {
    private String id;
    private String password;
    private Message message[];
    //private String message[].date;//信息数组中添加日期。


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Message[] getMessage() {
        return message;
    }

    public void setMessage(Message[] message) {
        this.message = message;
    }
}