package com.hunter.computerhunter.controller;

import com.hunter.computerhunter.entity.memory;
import com.hunter.computerhunter.repository.memoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class memoryController {
    @Autowired
    private memoryRepository repository;

    //获取显卡的所有记录
    @GetMapping("/getAllmemory")
    public List<memory> list(){
        return repository.findAll();
    }
    //根据型号查找
    @GetMapping("/getmemoryModel")
    public String getmemory(String model){
        memory d=repository.findBymModel(model);
        if(d==null){
            return "匹配错误!\n没有该硬件";
        }
        return d.getmModel()+"\n"+d.getmRecommend();
    }

    //查找所需权值记录
    @GetMapping("/getmemory/{mWeight}")
    public String findmemory(@PathVariable("mWeight") String w){
        memory m= repository.findBymWeight(w);
        if (m==null){
            return "Not this record";
        }
        return m.getmModel()+"   "+m.getmPrice();
    }

    //更新数据
    @RequestMapping("/updatememory")
    public void updatememory( String model,
                              String price,
                               String parmeter,
                                String recommend
                                ){
        memory m=new memory();
        m.setmModel(model);
        m.setmPrice(price);
        m.setmParameter(parmeter);
        m.setmRecommend(recommend);
        m.setmWeight("0.1");
        repository.save(m);

    }

    //删除记录
    @GetMapping("/dropmemory/{model}")
    public String dropmemory(@PathVariable("model") String id){
        repository.deleteById(id);
        return "Successed!";
    }
}
