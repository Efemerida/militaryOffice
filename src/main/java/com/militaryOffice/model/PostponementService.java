package com.militaryOffice.model;

import com.militaryOffice.repositories.PostponementRepository;
import com.militaryOffice.services.CitizenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostponementService {

    private final PostponementRepository postponementRepository;
    private final CitizenService citizenService;

    public List<Postponement> getAllPostponement(){
        Citizen citizen = citizenService.getCitizenByAuthentication();
        List<Postponement> postponements = postponementRepository.findAllByidUser(citizen);
        return postponements;
    }
}
