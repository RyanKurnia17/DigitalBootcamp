package com.multipolar.bootcamp.kyc.service;

import com.multipolar.bootcamp.kyc.domain.Kyc;
import com.multipolar.bootcamp.kyc.repository.KycRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KycService {
    private final KycRepository kycRepository;

    @Autowired
    public KycService(KycRepository kycRepository) {
        this.kycRepository = kycRepository;
    }
    //fungsi untuk get all kyc
    public List<Kyc> getAllKyc(){
        return kycRepository.findAll();
    }

    //fungsi untuk get kyc by id
    public Optional<Kyc> getKycByID(String id){
        return kycRepository.findById(id);
    }

    //fungsi untuk get kyc by nik
    public Optional<Kyc> getKycByNik(String nik){
        return kycRepository.findByNikInCaseSensitive(nik);
    }

    //fungsi untuk get kyc by firstName
    public List<Kyc> getKycByFirstName(String firstName){
        return kycRepository.findAllFirstNameInCaseSensitive(firstName);
    }

    //fungsi untuk get kyc by lastName
    public List<Kyc> getKycByLastName(String lastName){
        return kycRepository.findAllLastNameInCaseSensitive(lastName);
    }

    //fungsi untuk create kyc baru
    public Kyc createOrUpdateKyc(Kyc kyc){
        return kycRepository.save(kyc);
    }

    //fungsi untuk delete todo
    public void deleteKycById(String id){
        kycRepository.deleteById(id);
    }

}
