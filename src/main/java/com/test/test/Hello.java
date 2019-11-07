package com.test.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping({"/hello"})
public class Hello {
    @Autowired
    private LimitConfig limitConfig;


   @PostMapping("/say")
   //@PostMapping
    //@RequestMapping
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myid){
     //   return "说明："+limitConfig.getDescription();
          return "id = "+myid;
   }

}
