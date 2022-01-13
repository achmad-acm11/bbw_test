package com.example.bbw_test.request;

public class OrderRequest {
    private String client_id;
    private String reference_number;
    private Long virtual_account;
    private Integer amount;
    private String note;

    
    public OrderRequest() {
    }


    public OrderRequest(String client_id, String reference_number, Long virtual_account, Integer amount, String note) {
        this.client_id = client_id;
        this.reference_number = reference_number;
        this.virtual_account = virtual_account;
        this.amount = amount;
        this.note = note;
    }


    public String getClient_id() {
        return client_id;
    }


    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }


    public String getReference_number() {
        return reference_number;
    }


    public void setReference_number(String reference_number) {
        this.reference_number = reference_number;
    }


    public Long getVirtual_account() {
        return virtual_account;
    }


    public void setVirtual_account(Long virtual_account) {
        this.virtual_account = virtual_account;
    }


    public Integer getAmount() {
        return amount;
    }


    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    public String getNote() {
        return note;
    }


    public void setNote(String note) {
        this.note = note;
    }

    

}
