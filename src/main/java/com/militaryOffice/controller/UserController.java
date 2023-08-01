package com.militaryOffice.controller;

import com.militaryOffice.model.*;
import com.militaryOffice.security.AccountDetails;
import com.militaryOffice.services.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final ParentService parentService;
    private final ServiceService serviceService;
    private final MedicalCardService medicalCardService;
    private final AwardService awardService;
    private final SubpoenaService subpoenaService;
    private final InspectionService inspectionService;
    private final PostponementService postponementService;
    private final CitizenService citizenService;

    @GetMapping("/aboutMe")
    public String aboutMePage(Model model){
        Citizen citizen = citizenService.getCitizenByAuthentication();
        model.addAttribute("user",citizen);
        return "user/aboutMe";
    }

    @GetMapping("/parents")
    public String getParentsPage(Model model){
        List<Parent> parents = parentService.getAllParent();
        model.addAttribute("parents", parents);
        model.addAttribute("thereIs",!parents.isEmpty());
        return "user/parent";
    }

    @GetMapping("/service")
    public String getServicePage(Model model){
        List<Service> services = serviceService.getAllServices();
        model.addAttribute("services", services);
        model.addAttribute("thereIs", !services.isEmpty());
        return "user/service";
    }

    @GetMapping("/medicalCard")
    public String getMedicalCardPage(Model model){
        MedicalCard medicalCard = medicalCardService.getMedicalCard();
        System.out.println(medicalCard);
        model.addAttribute("medicalCard", medicalCard);
        model.addAttribute("thereIs", medicalCard!=null);
        return "user/medicalCard";
    }

    @GetMapping("/awards")
    public String getAwardsPage(Model model){
        List<Award> awards = awardService.getAllAwards();
        model.addAttribute("awards", awards);
        model.addAttribute("thereIs", !awards.isEmpty());
        return "user/award";
    }

    @GetMapping("/subpoenas")
    public String getSubpoenasPage(Model model){
        List<Subpoena> subpoenas = subpoenaService.getAllSubpoena();
        model.addAttribute("subpoenas", subpoenas);
        model.addAttribute("thereIs", !subpoenas.isEmpty());
        return "user/subpoena";
    }

    @GetMapping("/inspections")
    public String getInspectionsPage(Model model){
        List<Inspection> inspections = inspectionService.getAllInspection();
        model.addAttribute("inspections", inspections);
        model.addAttribute("thereIs", !inspections.isEmpty());
        return "user/inspection";
    }

    @GetMapping("/postponements")
    public String getPostponementsPage(Model model){
        List<Postponement> postponements = postponementService.getAllPostponement();
        model.addAttribute("postponements", postponements);
        model.addAttribute("thereIs", !postponements.isEmpty());
        return "user/postponement";
    }

    @GetMapping("/sizeForm")
    public String getSizeFormPage(Model model){
        Citizen citizen = citizenService.getCitizenByAuthentication();
        model.addAttribute("citizen", citizen);
        model.addAttribute("thereIs", citizen!=null);
        return "user/sizeForm";
    }


}
