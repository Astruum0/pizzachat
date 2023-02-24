package com.arthurvella.pizzachat;

import org.springframework.web.bind.annotation.GetMapping;

public class Controller {
    @GetMapping("/")
    String HelloWord() {
        return "Hello World !";
    }
}
