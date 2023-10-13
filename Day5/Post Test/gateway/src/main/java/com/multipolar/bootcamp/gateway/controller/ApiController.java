package com.multipolar.bootcamp.gateway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multipolar.bootcamp.gateway.dto.AccountDTO;
import com.multipolar.bootcamp.gateway.dto.ErrorMessageDTO;
import com.multipolar.bootcamp.gateway.kafka.AccessLog;
import com.multipolar.bootcamp.gateway.service.AccessLogService;
import com.multipolar.bootcamp.gateway.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private static final String CUSTOMER_URL = "http://localhost:8080/accounts";
    private  final RestTemplateUtil restTemplateUtil;
    private final ObjectMapper objectMapper;
    private final AccessLogService accessLogService;
    private final HttpServletRequest request;
    @Autowired
    public ApiController(RestTemplateUtil restTemplateUtil, ObjectMapper objectMapper, AccessLogService accessLogService, HttpServletRequest request) {
        this.restTemplateUtil = restTemplateUtil;
        this.objectMapper = objectMapper;
        this.accessLogService = accessLogService;
        this.request = request;
    }
    //getAccount
    @GetMapping("/getAccounts")
    public ResponseEntity<?> getAccounts() throws JsonProcessingException {
        //akses API customer dan dapatkan datanya
        try {
            ResponseEntity<?> response = restTemplateUtil.getList(CUSTOMER_URL , new ParameterizedTypeReference<>(){});
            //kirim accesslog
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL, response.getStatusCodeValue(),"content", request.getRemoteAddr(),request.getHeader("User-Agent"),LocalDateTime.now());
            accessLogService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL, ex.getRawStatusCode(),"content", request.getRemoteAddr(),request.getHeader("User-Agent"),LocalDateTime.now());
            accessLogService.logAccess(accessLog);
            return  ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }

    }

    //getAccount
    @GetMapping("/getAccounts/{id}")
    public ResponseEntity<?> getAccountsById(@PathVariable String id) throws JsonProcessingException {
        //akses API customer dan dapatkan datanya
        try {
            ResponseEntity<?> response = restTemplateUtil.getList(CUSTOMER_URL+"/"+id , new ParameterizedTypeReference<>(){});
            //kirim accesslog
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL+"/"+id, response.getStatusCodeValue(),"content", request.getRemoteAddr(),request.getHeader("User-Agent"),LocalDateTime.now());
            accessLogService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL+"/"+id, ex.getRawStatusCode(),"content", request.getRemoteAddr(),request.getHeader("User-Agent"),LocalDateTime.now());
            accessLogService.logAccess(accessLog);
            return  ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }
    //update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable String id, @RequestBody AccountDTO accountDTO) throws JsonProcessingException {
        try {
            ResponseEntity<?> response = restTemplateUtil.put(CUSTOMER_URL+"/"+id , accountDTO, AccountDTO.class);
            //kirim accesslog
            AccessLog accessLog =  new AccessLog("PUT",CUSTOMER_URL+"/"+id, response.getStatusCodeValue(),"content", request.getRemoteAddr(),request.getHeader("User-Agent"),LocalDateTime.now());
            accessLogService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog =  new AccessLog("PUT",CUSTOMER_URL+"/"+id, ex.getRawStatusCode(),"content", request.getRemoteAddr(),request.getHeader("User-Agent"),LocalDateTime.now());
            accessLogService.logAccess(accessLog);
            return  ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }

    //delete data
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountById(@PathVariable String id) throws JsonProcessingException {
        try {
            ResponseEntity<?> response = restTemplateUtil.delete(CUSTOMER_URL+"/"+id);
            //kirim accesslog
            AccessLog accessLog =  new AccessLog("DELETE",CUSTOMER_URL+"/"+id, response.getStatusCodeValue(),"content", request.getRemoteAddr(),request.getHeader("User-Agent"),LocalDateTime.now());
            accessLogService.logAccess(accessLog);
            return ResponseEntity.notFound().build();
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog =  new AccessLog("DELETE",CUSTOMER_URL+"/"+id, ex.getRawStatusCode(),"content", request.getRemoteAddr(),request.getHeader("User-Agent"),LocalDateTime.now());
            accessLogService.logAccess(accessLog);
            return ResponseEntity.notFound().build();
        }
    }

    //input data
    @PostMapping("/createAccounts")
    public ResponseEntity<?> postAccount(@RequestBody AccountDTO accountDTO) throws JsonProcessingException {
        try {
            ResponseEntity<?> response = restTemplateUtil.post(CUSTOMER_URL, accountDTO, AccountDTO.class);
            //kirim accesslog
            AccessLog accessLog =  new AccessLog("POST",CUSTOMER_URL, response.getStatusCodeValue(),"content", request.getRemoteAddr(),request.getHeader("User-Agent"),LocalDateTime.now());
            accessLogService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog =  new AccessLog("POST",CUSTOMER_URL, ex.getRawStatusCode(),"content", request.getRemoteAddr(),request.getHeader("User-Agent"),LocalDateTime.now());
            accessLogService.logAccess(accessLog);
            return  ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }

}
