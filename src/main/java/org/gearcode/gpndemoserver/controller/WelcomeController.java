package org.gearcode.gpndemoserver.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.gearcode.gpndemoserver.repository.DataPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private DataPackRepository repository;

    @GetMapping("/")
    public String welcome(){
        Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
        return gson.toJson(repository.findAll().get(0));
    }

}
