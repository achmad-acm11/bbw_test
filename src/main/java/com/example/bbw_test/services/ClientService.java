package com.example.bbw_test.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.example.bbw_test.models.entities.Client;
import com.example.bbw_test.models.repositories.ClientRepo;
import com.example.bbw_test.request.ClientRequest;
import com.example.bbw_test.response.ClientResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientService {
    @Autowired
    private ClientRepo repo;

    public ClientResponse inquiryService(ClientRequest req) {
        Client client = new Client();

        // Mapping
        client.setId(req.getClient_id());
        client.setReferenceNumber(req.getReference_number());
        client.setVirtualAccount(req.getVirtual_account());

        // // Get Order
        Optional<Client> tmp = repo.findByVirtualAccount(client.getVirtualAccount());
        if (!tmp.isPresent()) {
            return null;
        }
        client = repo.findByVirtualAccount(client.getVirtualAccount()).get();

        // Get Data Client
        // Optional<Client> tmp1 = clientRepo.findById(order.getClientId());
        // if (!tmp1.isPresent()) {
        // return null;
        // }
        // Client client = clientRepo.findById(order.getClient().).get();

        return new ClientResponse("000", "Success", client.getAccount_name());
    }
}
