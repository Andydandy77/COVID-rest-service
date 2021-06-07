package com.example.COVIDrestservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Personal_Info {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int peopleId;
    private String lastName;
    private String firstName;
    private String ethnicity;
    private String sex;
    private Date dateOfBirth;
    private String phoneNum;
    private String address;


}
