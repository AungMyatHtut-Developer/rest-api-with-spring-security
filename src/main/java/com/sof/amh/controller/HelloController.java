package com.sof.amh.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("/")
    public String greet() {
        return "Hello World!";
    }

    @GetMapping("/secured")
    public String securedEndpoint() {
        return "You got me and you have access to get this.";
    }
}
