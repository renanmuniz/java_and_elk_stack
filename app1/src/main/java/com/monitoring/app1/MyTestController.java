package com.monitoring.app1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestController {

    private static final Logger logger = LogManager.getLogger(MyTestController.class);

    @GetMapping(path = "/users/{name}")
    public ResponseEntity<String> getUserByName(@PathVariable String name) {
        if (name.equalsIgnoreCase("admin")) {
            logger.info("Access by ADMIN triggered");
            return ResponseEntity.ok("Access Granted to " + name);
        } else {
            logger.error("Access denied for: {}", name);
            return new ResponseEntity<>(("Access Denied for " + name), HttpStatus.BAD_REQUEST);
        }
    }

}
