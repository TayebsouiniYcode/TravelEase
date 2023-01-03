package com.youcode.travelease.util;

public class ResponseMessage {
    private Integer status;
    private String statusName;
    private String message;

    public Integer getStatus ( ) {
        return status;
    }

    public void setStatus ( Integer status ) {
        this.status = status;
    }

    public String getStatusName ( ) {
        return statusName;
    }

    public void setStatusName ( String statusName ) {
        this.statusName = statusName;
    }

    public String getMessage ( ) {
        return message;
    }

    public void setMessage ( String message ) {
        this.message = message;
    }

    @Override
    public String toString ( ) {
        return "ResponseMessage{" +
                "status=" + status +
                ", statusName='" + statusName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
