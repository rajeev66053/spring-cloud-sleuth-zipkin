package com.java.doctorservice;

import com.java.doctorservice.api.DoctorServiceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private DoctorServiceApi doctorServiceApi;
    @GetMapping("/allDoctors/{hospital}")
    public String doctors(@PathVariable String hospital){
        logger.info("got hit on /allDoctors/"+hospital);
        return doctorServiceApi.getDoctors(hospital);
    }
}