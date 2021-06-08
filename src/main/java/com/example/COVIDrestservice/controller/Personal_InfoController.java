package com.example.COVIDrestservice.controller;

import com.example.COVIDrestservice.entity.PersonalInformationEntity;
import com.example.COVIDrestservice.service.Personal_InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Personal_InfoController {

    @Autowired
    private Personal_InfoService service;

    private Map<String, PersonalInformationEntity> personalInformationEntityMap = new HashMap<>();
    private ArrayList<PersonalInformationEntity> personalInformationEntityList = new ArrayList<>();


    @PostMapping("/addpersonalinfo")
    public PersonalInformationEntity addPersonal_Info(@RequestBody PersonalInformationEntity personal_info) {
        return service.savePersonal_Info(personal_info);
    }

    @GetMapping("")
    public void generateCache() {
        List<PersonalInformationEntity> personalInfos = service.getPersonal_Infos();
            for (PersonalInformationEntity entity : personalInfos) {
                personalInformationEntityMap.put(entity.getLname() + entity.getFname(), entity);
                personalInformationEntityList.add(entity);

            }
    }



    @GetMapping("/personalinfos")
    public List<PersonalInformationEntity> findAllPersonal_Info() {
        List<PersonalInformationEntity> personalInfos = service.getPersonal_Infos();
        for (PersonalInformationEntity entity : personalInfos) {
            personalInformationEntityMap.put(entity.getLname() + entity.getFname(), entity);
        }
        return service.getPersonal_Infos();
    }

    @GetMapping("/person/find/map/{lname}+{fname}")
    public PersonalInformationEntity findPersonal_Info_ByNameMap(@PathVariable String fname, @PathVariable String lname) {
        double startTime = System.nanoTime();
        PersonalInformationEntity person = personalInformationEntityMap.get(lname+fname);
        double endTime = System.nanoTime();
        if (person != null) {
            System.out.print("Time to hit HashMap: ");
        } else {
            person = service.getPersonal_InfoByFullName(fname, lname);
            endTime = System.nanoTime();
            if (person != null) {
                personalInformationEntityMap.put(lname + fname, person);
            }
            System.out.print("Time to hit Database: ");
        }
        System.out.print(endTime - startTime);
        System.out.println(" nanoseconds");

        return person;
    }

    @GetMapping("/person/find/list/{lname}+{fname}")
    public PersonalInformationEntity findPersonal_Info_ByNameList(@PathVariable String fname, @PathVariable String lname) {
        PersonalInformationEntity person = null;
        double startTime = System.nanoTime();
        for(PersonalInformationEntity temp : personalInformationEntityList) {
            if (temp.getFname().equals(fname) && temp.getLname().equals(lname)) {
                person = temp;
            }
        }
        double endTime = System.nanoTime();
        if (person != null) {
            System.out.print("Time to hit ArrayList: ");
        } else {
            person = service.getPersonal_InfoByFullName(fname, lname);
            endTime = System.nanoTime();
            if (person != null) {
                personalInformationEntityList.add(person);
            }
            System.out.print("Time to hit Database: ");
        }
        System.out.print(endTime - startTime);
        System.out.println(" nanoseconds");
        return person;
    }

}
