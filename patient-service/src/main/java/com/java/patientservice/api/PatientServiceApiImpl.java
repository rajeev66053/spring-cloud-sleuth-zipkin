package com.java.patientservice.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PatientServiceApiImpl implements PatientServiceApi {
    private static Logger logger = LoggerFactory.getLogger(PatientServiceApiImpl.class);

    @Autowired
    private RestTemplateBuilder builder;

    @Override
    public String getPatients(String city) {
        logger.info("fetching patients list from db for city -{}", city);

        RestTemplate template = builder.build();
        template.getForObject("http://localhost:5081/notify/patients", String.class);

        return "List of patients for city - " + city;
    }
}