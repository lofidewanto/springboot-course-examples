package com.example.fullmode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientDao {

    private static final Logger logger = LoggerFactory.getLogger(ClientDao.class);

    public void run() {
        logger.info("Run ClientDao: " + this);
    }
}
