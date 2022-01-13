package com.example.bbw_test.response;

public class ClientResponse extends StatusResponse {
    private String accountName;

    public ClientResponse(String rc, String message, String accountName) {
        super(rc, message);
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
