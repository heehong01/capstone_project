package com.example.backend_capstone.jpa.service.Client;

import com.example.backend_capstone.jpa.enititymodels.Client;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientServiceTest {
    @Autowired
    private ClientService clientService;

//    @BeforeEach
//    void setUp(){
//        Client client1 = new Client();
//        client1.setClientId(1L);
//        client1.setFirstName("Mary");
//        client1.setEmail("mj@gmail.com");
//        client1.setLastName("Jane");
//        client1.setUsername("maryJane");
//        client1.setPassword("password");
//        clientService.saveUser(client1);
//
//        Client client2 = new Client();
//        client2.setClientId(2L);
//        client2.setFirstName("Joseph");
//        client2.setEmail("JDoe@gmail.com");
//        client2.setLastName("Doe");
//        client2.setUsername("jdoe");
//        client2.setPassword("password");
//        clientService.saveUser(client2);
//    }

    @Test
    void getAllUsers() {
        List<Client> allClient = clientService.getAllUsers();
        int beforeAddingMoreClient = allClient.size();

        Client client1 = new Client();
        client1.setUsername("jdoe007");
        client1.setFirstName("Doe");
        client1.setLastName("John");
        client1.setEmail("john.doe@gmail.com");
        client1.setPassword("password");
        clientService.saveUser(client1);
        int afterAddingMoreClient = clientService.getAllUsers().size();


        Assertions.assertThat(afterAddingMoreClient).isEqualTo(beforeAddingMoreClient + 1);
        Assertions.assertThat(allClient.contains(client1)).isTrue();
    }

    @Test
    void saveUser() {
    }

    @Test
    void getUserById() {
        List<Client> allClient = clientService.getAllUsers();
        Client client1 = allClient.get(0);
        if (client1 != null) {
            Client client2 =  clientService.getUserById(client1.getClientId());
            Assertions.assertThat(client1).isEqualTo(client2);
        }
    }

    @Test
    void deleteUserById() {
    }

    @Test
    void saveGardenToUser() {
    }

    @Test
    void getGardenByUser() {
    }
}