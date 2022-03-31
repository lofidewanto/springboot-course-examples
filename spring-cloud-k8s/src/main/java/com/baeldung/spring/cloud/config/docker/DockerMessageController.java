package com.baeldung.spring.cloud.config.docker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerMessageController {

    private static final Logger logger = LoggerFactory.getLogger(DockerMessageController.class);
    
    @GetMapping("/messages")
    public String getMessage() {
        logger.info("Called getMessage...");
        
        return "Hello from Docker and K8s!";
    }
}
