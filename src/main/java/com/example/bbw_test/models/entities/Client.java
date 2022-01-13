package com.example.bbw_test.models.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
    @Id
    private String id;
    private String account_name;
    private String referenceNumber;
    private Long virtualAccount;

    @JoinTable
    @OneToMany
    private List<Order> order;

    public Client() {
    }

    public Client(String id, String account_name, String referenceNumber, Long virtualAccount, List<Order> order) {
        this.id = id;
        this.account_name = account_name;
        this.referenceNumber = referenceNumber;
        this.virtualAccount = virtualAccount;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Long getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(Long virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    
    
}
