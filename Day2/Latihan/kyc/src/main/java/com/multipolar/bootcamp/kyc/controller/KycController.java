package com.multipolar.bootcamp.kyc.controller;


//import org.springframework.validation.annotation.Validated;
import com.multipolar.bootcamp.kyc.domain.Kyc;
import com.multipolar.bootcamp.kyc.dto.ErrorMessage;
import com.multipolar.bootcamp.kyc.service.KycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kyc")
public class KycController {
    private final KycService kycService;
    @Autowired
    public KycController(KycService kycService) {
        this.kycService = kycService;
    }

    //menambahkan data
    @PostMapping
    public ResponseEntity<?> createTodo(@Valid @RequestBody Kyc kyc, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ErrorMessage> validationErrors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                ErrorMessage errorMessage = new ErrorMessage();
                errorMessage.setCode("VALIDATION_ERROR");
                errorMessage.setMessage(error.getDefaultMessage());
                validationErrors.add(errorMessage);
            }
            return ResponseEntity.badRequest().body(validationErrors);
        }

        Kyc createdKyc = kycService.createOrUpdateKyc(kyc);
        return ResponseEntity.ok(createdKyc);
    }


    //mengambil data dari database
    @GetMapping
    public List<Kyc> getAllKyc(){
        return kycService.getAllKyc();
    }

    //get kyc by id lewat pathvariabel/segment
    @GetMapping("/{id}")
    public ResponseEntity<Kyc> getKycById(@PathVariable String id){
        Optional<Kyc> kyc = kycService.getKycByID(id);
        return kyc.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //edit kyc
    @PutMapping("/{id}")
    public Kyc updateKyc(@PathVariable String id, @RequestBody Kyc kyc){
        kyc.setId(id);
        return  kycService.createOrUpdateKyc(kyc);
    }

    //menghapus data pada database
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKycById(@PathVariable String id){
        kycService.deleteKycById(id);
        return ResponseEntity.notFound().build();
    }

}
