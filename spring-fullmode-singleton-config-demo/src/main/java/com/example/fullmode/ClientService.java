package com.example.fullmode;

public class ClientService {

    private ClientDao clientDao;

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void runClientDao() {
        clientDao.run();
    }
}
