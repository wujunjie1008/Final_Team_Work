package com.computerhunter.hunter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoone {
    @RequestMapping("/hello6")
    public String hello6(String m){
        String a="fbf\nafaf";
        return a;
    }
}
