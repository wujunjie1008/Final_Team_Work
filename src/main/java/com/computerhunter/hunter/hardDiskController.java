package com.computerhunter.hunter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class hardDiskController {
    @Autowired
    private hardDiskRepository repository;

    //获取显卡的所有记录
    @GetMapping("/getAllhardDisk")
    public List<hardDisk> list(){
        return repository.findAll();
    }
    //根据型号查找
    @GetMapping("/gethardDiskModel")
    public String gethardDiskmodel(String model){
        hardDisk h=repository.findByhModel(model);
        if(h==null)
            return "NOT THIS MODLE!";
        return h.gethModel()+"\n"+h.gethRecommend();
    }

    //查找所需权值记录
    @GetMapping("/gethardDisk/{hWeight}")
    public String findhardDisk(@PathVariable("hWeight") String w){
        hardDisk h= repository.findByhWeight(w);
        if (h==null)
            return "Not this record";
        return h.gethModel()+"   "+h.gethPrice();
    }

    //更新数据
    @PutMapping("/updatehardDisk/{hModel}")
    public String updatehardDisk(@PathVariable("hModel") String model,
                                 @RequestParam("hPrice") String price,
                                 @RequestParam("hParameter") String parmeter,
                                 @RequestParam("hRecommend") String recommend,
                                 @RequestParam("hWeight") String weight){
        hardDisk h=new hardDisk();
        h.sethModel(model);
        h.sethPrice(price);
        h.sethParameter(parmeter);
        h.sethRecommend(recommend);
        h.sethWeight(weight);
        repository.save(h);
        return "Success!";
    }

    //删除记录
    @GetMapping("/drophardDisk/{model}")
    public String drophardDisk(@PathVariable("model") String id){
        repository.deleteById(id);
        return "Successed!";
    }
}
