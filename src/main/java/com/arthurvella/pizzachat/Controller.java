package com.arthurvella.pizzachat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    String HelloWord() {
        return "Hello World !";
    }
}
