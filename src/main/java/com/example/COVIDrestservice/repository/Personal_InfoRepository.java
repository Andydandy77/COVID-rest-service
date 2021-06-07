package com.example.COVIDrestservice.repository;


import com.example.COVIDrestservice.entity.PersonalInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Personal_InfoRepository extends JpaRepository<PersonalInformationEntity, Integer> {

    PersonalInformationEntity findByFnameAndLname(String fname, String lname);
}
