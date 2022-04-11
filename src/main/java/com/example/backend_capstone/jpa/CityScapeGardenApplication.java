package com.example.backend_capstone.jpa;

import com.example.backend_capstone.jpa.controller.GardenController;
import com.example.backend_capstone.jpa.controller.UserController;
import com.example.backend_capstone.jpa.controller.MainController;
import com.example.backend_capstone.jpa.service.GardenService;
import com.example.backend_capstone.jpa.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class CityScapeGardenApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CityScapeGardenApplication.class, args);
        GardenService gardenService = applicationContext.getBean(GardenService.class);
        if(gardenService != null) {
            System.out.println("gardenService = " + gardenService);
        }
        GardenController gardenController = applicationContext.getBean(GardenController.class);
        if(gardenController != null) {
            System.out.println("gardenController = " + gardenController);
        }

        UserService userService = applicationContext.getBean(UserService.class);
        if(userService != null){
            System.out.println("userService = " + userService);
        }
        UserController userController = applicationContext.getBean(UserController.class);
        if(userController != null){
            System.out.println("userController = " + userController);
        }
        MainController mainController = applicationContext.getBean(MainController.class);
    }

}
