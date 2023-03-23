package com.minton.logging.entity;

import java.util.Date;

public class OperationLog {

    private int operation_log_id;

    private String operation_Desc;

    private String operation_Request_Parameters;

    private String operation_Response_Parameters;

    private Date operation_Time;

    public int getOperation_log_id() {
        return operation_log_id;
    }

    public void setOperation_log_id(int operation_log_id) {
        this.operation_log_id = operation_log_id;
    }

    public String getOperation_Desc() {
        return operation_Desc;
    }

    public void setOperation_Desc(String operation_Desc) {
        this.operation_Desc = operation_Desc;
    }

    public String getOperation_Request_Parameters() {
        return operation_Request_Parameters;
    }

    public void setOperation_Request_Parameters(String operation_Request_Parameters) {
        this.operation_Request_Parameters = operation_Request_Parameters;
    }

    public String getOperation_Response_Parameters() {
        return operation_Response_Parameters;
    }

    public void setOperation_Response_Parameters(String operation_Response_Parameters) {
        this.operation_Response_Parameters = operation_Response_Parameters;
    }

    public Date getOperation_Time() {
        return operation_Time;
    }

    public void setOperation_Time(Date operation_Time) {
        this.operation_Time = operation_Time;
    }
}
