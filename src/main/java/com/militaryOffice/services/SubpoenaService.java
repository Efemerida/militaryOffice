package com.militaryOffice.services;

import com.militaryOffice.model.Citizen;
import com.militaryOffice.model.Subpoena;
import com.militaryOffice.repositories.SubpoenaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubpoenaService {

    private final SubpoenaRepository subpoenaRepository;
    private final CitizenService citizenService;

    public List<Subpoena> getAllSubpoena(){
        Citizen citizen = citizenService.getCitizenByAuthentication();
        List<Subpoena> subpoenas = subpoenaRepository.findAllByidUser(citizen);
        return subpoenas;
    }

}
