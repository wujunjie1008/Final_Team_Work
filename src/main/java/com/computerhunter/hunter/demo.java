package com.computerhunter.hunter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class demo {
    @GetMapping("/硬件知识")
    public String hhh(){
        return "硬件知识";
    }

}
