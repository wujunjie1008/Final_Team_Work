package com.computerhunter.hunter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CPUController {
    @Autowired
    private CPURepository repository;

    //获取CPU的所有记录
    @GetMapping("/getAllCPU")
    public List<CPU> list(){
        return repository.findAll();
    }
    //根据型号查找
    @RequestMapping("/getCPUModel")

    public String getcpumodel(String  model){
        CPU cpu=repository.findBycModel(model);
        if(cpu==null)
            return "NOT THIS MODLE!";
        return cpu.getcModel()+"\n"+cpu.getcRecommend();
    }

    //查找所需权值记录
    @GetMapping("/getcpu/{cWeight}")
    public String findcpu(@PathVariable("cWeight") String w){
        CPU cpu= repository.findBycWeight(w);
        if (cpu==null)
                return "Not this record";
        return cpu.getcModel()+"价格"+cpu.getcPrice();
    }

    //更新数据
    @PutMapping("/updatecpu/{cModel}")
    public String updateCPU(@PathVariable("cModel") String model,
                            @RequestParam("cPrice") String price,
                            @RequestParam("cParameter") String parmeter,
                            @RequestParam("cRecommend") String recommend,
                            @RequestParam("cWeight") String weight){
        CPU cpu=new CPU();
        cpu.setcModel(model);
        cpu.setcPrice(price);
        cpu.setcParameter(parmeter);
        cpu.setcRecommend(recommend);
        cpu.setcWeight(weight);
        repository.save(cpu);
        return "Success!";
    }

    //删除记录
    @GetMapping("/dropcpu/{model}")
    public String dropCpu(@PathVariable("model") String id){
        repository.deleteById(id);
        return "Successed!";
    }




}
