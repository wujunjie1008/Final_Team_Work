package com.hunter.computerhunter.controller;

import com.hunter.computerhunter.entity.displayCard;
import com.hunter.computerhunter.repository.displayCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class displayCardController {
    @Autowired
    private displayCardRepository repository;

    //获取显卡的所有记录
    @GetMapping("/getAlldisplayCard")
    public List<displayCard> list(){
        return repository.findAll();
    }
    //根据型号查找
    @GetMapping("/getdisplayCardModel")
    public String getdisplayCardmodel(String model){
        displayCard d=repository.findBydModel(model);
        if(d==null){
            return "匹配错误!\n没有该硬件";
        }
        return d.getdModel()+"\n"+d.getdRecommend();
    }

    //查找所需权值记录
    @GetMapping("/getdisplayCard/{dWeight}")
    public String finddisplayCard(@PathVariable("dWeight") String w){
        displayCard d= repository.findBydWeight(w);
        if (d==null)
            return "Not this record";
        return d.getdModel()+"   "+d.getdPrice();
    }

    //更新数据
    @RequestMapping("/updatedisplayCard")
    public void updatedisplayCard(String model,
                            String price,
                             String parmeter,
                            String recommend
                            ){
        displayCard d=new displayCard();
        d.setdModel(model);
        d.setdPrice(price);
        d.setdParameter(parmeter);
        d.setdRecommend(recommend);
        d.setdWeight("0.1");
        repository.save(d);

    }

    //删除记录
    @GetMapping("/dropdisplayCard/{model}")
    public String dropdisplayCard(@PathVariable("model") String id){
        repository.deleteById(id);
        return "Successed!";
    }
}
