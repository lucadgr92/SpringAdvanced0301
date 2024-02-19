package com.develhope.SpringAdvanced0301.services;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BasicService {




    public double additionService(int firstInt, int secondInt) {
        try {
            log.info("Starting calculation.");
            log.info("First argument {}",firstInt);
            log.info("Second argument {}",secondInt);
            return Math.pow(firstInt, secondInt);
        } finally {
            log.info("Calculation completed.");
        }

    }
}
