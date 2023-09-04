package com.example.fullmode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringFullmodeSingletonConfigDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFullmodeSingletonConfigDemoApplication.class, args);
    }

    @Bean
    ClientService clientService1() {
        ClientService clientService1 = new ClientService();
        clientService1.setClientDao(clientDao());
        return clientService1;
    }

    @Bean
    ClientService clientService2() {
        ClientService clientService2 = new ClientService();
        clientService2.setClientDao(clientDao());
        return clientService2;
    }

    @Bean
    ClientDao clientDao() {
        return new ClientDao();
    }

}
