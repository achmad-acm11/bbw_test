package com.example.bbw_test.response;

public class OrderResponse extends StatusResponse {
    
    private Long transactionNumber;

    public OrderResponse() {
    }

    public OrderResponse(String rc, String message, Long transactionNumber) {
        super(rc, message);
        this.transactionNumber = transactionNumber;
    }

    public Long getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(Long transactionNumber) {
        this.transactionNumber = transactionNumber;
    }
}
