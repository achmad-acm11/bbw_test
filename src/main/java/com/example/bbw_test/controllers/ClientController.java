package com.example.bbw_test.controllers;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

import com.example.bbw_test.request.ClientRequest;
import com.example.bbw_test.response.ClientResponse;
import com.example.bbw_test.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/va")
public class ClientController {

    @Autowired
    private ClientService service;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, value = "/inquiry")
    public ResponseEntity inquiry(@RequestBody ClientRequest req,
    @RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            System.out.println("Key " + key + " Value " + value);
        });
        ClientResponse res = service.inquiryService(req);
        HttpHeaders responHeaders = new HttpHeaders();
        responHeaders.set("Content-Type", "application/json");
        return new ResponseEntity<ClientResponse>(res, responHeaders, HttpStatus.OK);
    }

}
