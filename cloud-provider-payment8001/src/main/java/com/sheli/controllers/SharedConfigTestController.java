package com.sheli.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/sharedconfig")
public class SharedConfigTestController {
    /*
    @Value("${text.message01}")
    String messageFromConfigServer;

    @GetMapping("/getTestConfig")
    public String getTestConfig() {
        return messageFromConfigServer;
    }
    */
}
