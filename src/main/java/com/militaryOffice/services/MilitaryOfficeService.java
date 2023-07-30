package com.militaryOffice.services;

import com.militaryOffice.model.MilitaryOffice;
import com.militaryOffice.repositories.MilitaryOfficeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MilitaryOfficeService {

    private final MilitaryOfficeRepository militaryOfficeRepository;


    @Transactional(readOnly = true)
    public List<MilitaryOffice> getAllMilitaryOffices(){
        return militaryOfficeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public MilitaryOffice getMilitaryOfficeById(int id){
        Optional<MilitaryOffice> militaryOffice = militaryOfficeRepository.findById(id);
        if(militaryOffice.isEmpty()) throw new IllegalArgumentException();
        return militaryOffice.get();
    }
}
