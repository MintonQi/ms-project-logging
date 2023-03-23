package com.minton.logging.entity;


import java.util.Date;

public class ExceptionLog {

    private int exception_log_id;
    private String exception_name;
    private String exception_message;
    private Date exception_time;

    public int getException_log_id() {
        return exception_log_id;
    }

    public void setException_log_id(int exception_log_id) {
        this.exception_log_id = exception_log_id;
    }

    public String getException_name() {
        return exception_name;
    }

    public void setException_name(String exception_name) {
        this.exception_name = exception_name;
    }

    public String getException_message() {
        return exception_message;
    }

    public void setException_message(String exception_message) {
        this.exception_message = exception_message;
    }

    public Date getException_time() {
        return exception_time;
    }

    public void setException_time(Date exception_time) {
        this.exception_time = exception_time;
    }
}
