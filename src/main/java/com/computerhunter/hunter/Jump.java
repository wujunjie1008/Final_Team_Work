package com.computerhunter.hunter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Jump {
    @RequestMapping("/home")
    public String jump(){

        return "home";

    }
}
