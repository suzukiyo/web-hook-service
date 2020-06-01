package com.example.demo.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
class ReceiveController {

    @PostMapping
    void receive(@RequestParam("param") String param) {
        System.out.println(param);
    }

}
