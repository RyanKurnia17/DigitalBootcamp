package com.example.multipolar.bootcamp.gateway.controller;


import com.example.multipolar.bootcamp.gateway.dto.CustomerDTO;
import com.example.multipolar.bootcamp.gateway.dto.ErrorMessageDTO;
import com.example.multipolar.bootcamp.gateway.kafka.AccessLog;
import com.example.multipolar.bootcamp.gateway.service.AccessLogService;
import com.example.multipolar.bootcamp.gateway.util.RestTemplateUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiContoller {

    private static final String CUSTOMER_URL = "http://localhost:8081/customers";
    private  final RestTemplateUtil restTemplateUtil;
    private final ObjectMapper objectMapper;
    private final AccessLogService accessLogService;

    @Autowired
    public ApiContoller(RestTemplateUtil restTemplateUtil, ObjectMapper objectMapper, AccessLogService accessLogService) {
        this.restTemplateUtil = restTemplateUtil;
        this.objectMapper = objectMapper;
        this.accessLogService = accessLogService;
    }
    //http://localhost:8080/api/getCustomers
    @GetMapping("/getCustomers")
    public ResponseEntity<?> getCustomer() throws JsonProcessingException {
        //akses API customer dan dapatkan datanya
        try {
            ResponseEntity<?> response = restTemplateUtil.getList(CUSTOMER_URL , new ParameterizedTypeReference<>(){});
            //kirim accesslog
            AccessLog accessLog =  new AccessLog("GET", response.getStatusCode().toString(),"Successful");
            accessLogService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog =  new AccessLog("GET", ex.getStatusCode().toString(),"Failed");
            accessLogService.logAccess(accessLog);
            return  ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }

    @PostMapping("/createCustomers")
    public ResponseEntity<?> postCustomer(@RequestBody CustomerDTO customerDTO) throws JsonProcessingException {
        try {
            ResponseEntity<?> response = restTemplateUtil.post(CUSTOMER_URL, customerDTO, CustomerDTO.class);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        } catch (HttpClientErrorException ex) {
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
        }

}
