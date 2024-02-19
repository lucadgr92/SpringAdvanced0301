package com.develhope.SpringAdvanced0301.controllers;

import com.develhope.SpringAdvanced0301.errors.CustomError;
import com.develhope.SpringAdvanced0301.services.BasicService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Slf4j
public class BasicController {

    @Value("${myCustomVarTree.firstInt}")
    String firstInt;

    @Value("${myCustomVarTree.secondInt}")
    String secondInt;

    Integer firstIntConv;
    Integer secondIntConv;




    @Autowired
    private BasicService basicService;

    @PostConstruct
    public void convertAfterInjection() {
        firstIntConv = Integer.parseInt(firstInt);
        secondIntConv = Integer.parseInt(secondInt);
    }

    @GetMapping("/:")
    public String getWelcome() {
        String welcomeMessage = "Welcome!";
        log.info(welcomeMessage);
        return welcomeMessage;
    }




    @GetMapping("/exp")
    public double getAdditionService() {
        return basicService.additionService(firstIntConv,secondIntConv);
    }

    @GetMapping("/get-errors")
    public void throwError() {
        try {
            throw new CustomError("This is a custom error message");
        } catch (CustomError e) {
            log.error("An error occurred: ", e);
        }
    }
}

/*

		starts from INFO for root level logging
		starts from DEBUG for services level logging
		the logging info has ANSI colours enabled
		saves all the logs in a subfolder called myCustomLogs*/
