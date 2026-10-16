package basic.initial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/profile")
    public Profile profile() {
        return new Profile("홍길동",20);
    }
    record Profile(String name,int age){}
}
