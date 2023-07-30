package com.militaryOffice.services;

import com.militaryOffice.model.Citizen;
import com.militaryOffice.repositories.ServiceRepository;
import com.militaryOffice.security.AccountDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;
    private final CitizenService citizenService;


    public List<com.militaryOffice.model.Service> getAllServices(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();
        Citizen citizen = citizenService.getCitizen(accountDetails.getAccount().getPassport());
        List<com.militaryOffice.model.Service> services = serviceRepository.findAllByidUser(citizen);
        return services;
    }
}
