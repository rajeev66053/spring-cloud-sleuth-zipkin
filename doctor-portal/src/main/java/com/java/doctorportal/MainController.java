package com.java.doctorportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {
    private static Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    private boolean flag = true;
    @GetMapping("/doctors")
    public String getDoctors(){
        logger.info("Going to call doctors service");
        RestTemplate restTemplate = restTemplateBuilder.build();
        String hospital = "Fortis";
        if(flag){
            hospital = "Apollo";
        }
        flag = !flag;
        return restTemplate.getForObject("http://localhost:9081/allDoctors/"+hospital, String.class);
    }

    @GetMapping("/patients")
    public String getPatients(){
        logger.info("Going to call patients service");
        RestTemplate restTemplate = restTemplateBuilder.build();
        String city = "Norwalk";
        if(flag){
            city = "Fairfield";
        }
        flag = !flag;
        return restTemplate.getForObject("http://localhost:6081/allPatients/"+city, String.class);

    }
}