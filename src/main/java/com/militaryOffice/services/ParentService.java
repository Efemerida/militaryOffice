package com.militaryOffice.services;

import com.militaryOffice.model.Citizen;
import com.militaryOffice.model.Parent;
import com.militaryOffice.repositories.ParentRepository;
import com.militaryOffice.security.AccountDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class ParentService {

    private final ParentRepository parentRepository;
    private final CitizenService citizenService;


//    public List<Parent> getAllParentByUserId(int id){
//        return new ArrayList<>(parentRepository.findAllByidUser(id));
//    }

    public List<Parent> getAllParentByUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AccountDetails accountDetails = (AccountDetails)authentication.getPrincipal();
        Citizen citizen = citizenService.getCitizen(accountDetails.getAccount().getPassport());
        return new ArrayList<>(parentRepository.findAllByidUser(citizen));
    }

}
