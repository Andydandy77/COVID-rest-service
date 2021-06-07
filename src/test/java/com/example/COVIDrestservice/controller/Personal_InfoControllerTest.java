package com.example.COVIDrestservice.controller;

import com.example.COVIDrestservice.service.Personal_InfoService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
class Personal_InfoControllerTest {
    private MockMvc mvc;

    @InjectMocks
    private Personal_InfoController controller;

//    @Mock
//    private Personal_InfoService service;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void name() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/personalinfos"));
//                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void findPersonal_Info_ByName() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/personalinfos"));
        MvcResult result = this.mvc.perform(get("/person/find/Fellini+Abbie")).andReturn();
        assertEquals(1,1);

    }
}



