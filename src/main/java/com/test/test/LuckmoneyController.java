package com.test.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
@RestController
public class LuckmoneyController {
    @Autowired
    private LuckmoneyRepository repository;
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){
        return repository.findAll();
    }

    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money") BigDecimal money){
        Luckymoney luckmoney=new Luckymoney();
        luckmoney.setProducer(producer);
        luckmoney.setMoeny(money);
        return repository.save(luckmoney);
    }
}
