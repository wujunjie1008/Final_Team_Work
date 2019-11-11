package com.computerhunter.hunter;

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
        if(d==null)
            return "NOT THIS MODLE!";
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
    @PutMapping("/updatecpu/{dModel}")
    public String updatedisplayCard(@PathVariable("dModel") String model,
                            @RequestParam("dPrice") String price,
                            @RequestParam("dParameter") String parmeter,
                            @RequestParam("dRecommend") String recommend,
                            @RequestParam("dWeight") String weight){
        displayCard d=new displayCard();
        d.setdModel(model);
        d.setdPrice(price);
        d.setdParameter(parmeter);
        d.setdRecommend(recommend);
        d.setdWeight(weight);
        repository.save(d);
        return "Success!";
    }

    //删除记录
    @GetMapping("/dropdisplayCard/{model}")
    public String dropdisplayCard(@PathVariable("model") String id){
        repository.deleteById(id);
        return "Successed!";
    }
}
