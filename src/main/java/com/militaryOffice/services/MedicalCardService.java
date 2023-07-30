package com.militaryOffice.services;

import com.militaryOffice.model.Citizen;
import com.militaryOffice.model.MedicalCard;
import com.militaryOffice.repositories.MedicalCardRepository;
import com.militaryOffice.security.AccountDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicalCardService {

    private final MedicalCardRepository medicalCardRepository;
    private final CitizenService citizenService;

    public MedicalCard getMedicalCard(){
        Citizen citizen = citizenService.getCitizenByAuthentication();
        MedicalCard medicalCard = medicalCardRepository.findByidUser(citizen);
        return medicalCard;
    }
}
