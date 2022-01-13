package com.example.bbw_test.response;

public class StatusResponse {
    private String rc;
    private String message;
    
    public StatusResponse() {
    }

    public StatusResponse(String rc, String message) {
        this.rc = rc;
        this.message = message;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
