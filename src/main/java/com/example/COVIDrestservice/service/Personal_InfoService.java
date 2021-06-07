package com.example.COVIDrestservice.service;

import com.example.COVIDrestservice.entity.PersonalInformationEntity;
import com.example.COVIDrestservice.repository.Personal_InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Personal_InfoService {
    @Autowired
    private Personal_InfoRepository repository;

    public PersonalInformationEntity savePersonal_Info(PersonalInformationEntity personal_info) {
        return repository.save(personal_info);
    }

    public List<PersonalInformationEntity> getPersonal_Infos() {
        return repository.findAll();
    }

    public PersonalInformationEntity getPersonal_InfoByFullName(String fname, String lname) {
        return repository.findByFnameAndLname(fname, lname);
    }


}
