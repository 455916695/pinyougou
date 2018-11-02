package entity;

import java.io.Serializable;

/**
 *  结果集
 * */
public class Result  implements Serializable{

    private  int status;

    private  String message;

    public Result() {
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
