package com.multipolar.bootcamp.gateway.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multipolar.bootcamp.gateway.dto.ErrorMessageDTO;
import com.multipolar.bootcamp.gateway.dto.ProductDTO;
import com.multipolar.bootcamp.gateway.kafka.AccessLog;
import com.multipolar.bootcamp.gateway.service.AccessLogService;
import com.multipolar.bootcamp.gateway.util.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private static final String CUSTOMER_URL = "http://localhost:8080/products";
    private  final RestTemplateUtil restTemplateUtil;
    private final ObjectMapper objectMapper;
    private final AccessLogService accessLogService;

    @Autowired
    public ApiController(RestTemplateUtil restTemplateUtil, ObjectMapper objectMapper, AccessLogService accessLogService) {
        this.restTemplateUtil = restTemplateUtil;
        this.objectMapper = objectMapper;
        this.accessLogService = accessLogService;
    }

    //http://localhost:8081/api/getProducts
    @GetMapping("/getProducts")
    public ResponseEntity<?> getProducts() throws JsonProcessingException {
        //akses API customer dan dapatkan datanya
        try {
            ResponseEntity<?> response = restTemplateUtil.getList(CUSTOMER_URL , new ParameterizedTypeReference<>(){});
            //kirim accesslog
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL, response.getStatusCodeValue(),LocalDateTime.now(),"Successful");
            accessLogService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL, ex.getRawStatusCode(),LocalDateTime.now(),"Failed");
            accessLogService.logAccess(accessLog);
            return  ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }

    }
    //get product by id
    //http://localhost:8081/api/getProducts
    @GetMapping("/getProducts/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) throws JsonProcessingException {
        try {
            ResponseEntity<?> response = restTemplateUtil.getList(CUSTOMER_URL+"/"+id , new ParameterizedTypeReference<>(){});
            //kirim accesslog
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL, response.getStatusCodeValue(),LocalDateTime.now(),"Successful");
            accessLogService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL, ex.getRawStatusCode(),LocalDateTime.now(),"Failed");
            accessLogService.logAccess(accessLog);
            return  ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }

    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody ProductDTO productDTO) throws JsonProcessingException {
        try {
            ResponseEntity<?> response = restTemplateUtil.put(CUSTOMER_URL+"/"+id , productDTO, ProductDTO.class);
            //kirim accesslog
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL, response.getStatusCodeValue(),LocalDateTime.now(),"Successful");
            accessLogService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL, ex.getRawStatusCode(),LocalDateTime.now(),"Failed");
            accessLogService.logAccess(accessLog);
            return  ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }

    }

    //delete data
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable String id) throws JsonProcessingException {
        try {
            ResponseEntity<?> response = restTemplateUtil.delete(CUSTOMER_URL+"/"+id);
            //kirim accesslog
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL, response.getStatusCodeValue(),LocalDateTime.now(),"Successful");
            accessLogService.logAccess(accessLog);
            return ResponseEntity.notFound().build();
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL, ex.getRawStatusCode(),LocalDateTime.now(),"Failed");
            accessLogService.logAccess(accessLog);
            return ResponseEntity.notFound().build();
        }
    }

    //input data
    @PostMapping("/createProducts")
    public ResponseEntity<?> postProduct(@RequestBody ProductDTO productDTO) throws JsonProcessingException {
        try {
            ResponseEntity<?> response = restTemplateUtil.post(CUSTOMER_URL, productDTO, ProductDTO.class);
            //kirim accesslog
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL, response.getStatusCodeValue(),LocalDateTime.now(),"Successful");
            accessLogService.logAccess(accessLog);
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }catch (HttpClientErrorException ex){
            List<ErrorMessageDTO> errorResponse = objectMapper.readValue(ex.getResponseBodyAsString(), List.class);
            AccessLog accessLog =  new AccessLog("GET",CUSTOMER_URL, ex.getRawStatusCode(),LocalDateTime.now(),"Failed");
            accessLogService.logAccess(accessLog);
            return  ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
        }
    }
}
