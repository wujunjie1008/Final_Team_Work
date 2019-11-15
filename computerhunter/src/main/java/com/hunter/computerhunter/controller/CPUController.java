package com.hunter.computerhunter.controller;

import com.hunter.computerhunter.entity.CPU;
import com.hunter.computerhunter.repository.CPURepository;
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
        {
            return "匹配错误!\n没有该硬件";
        }
        return cpu.getcModel()+"\n"+cpu.getcRecommend();
    }

    //查找所需权值记录
    @GetMapping("/getcpu/{cWeight}")
    public String findcpu(@PathVariable("cWeight") String w){
        CPU cpu= repository.findBycWeight(w);
        if (cpu==null){
            return "Not this record";
        }
        return cpu.getcModel()+"价格"+cpu.getcPrice();
    }

    //更新数据
    @RequestMapping("/updateCPU")
    public void updateCPU( String Model,
                             String Price,
                             String Parmeter,
                            String Recommend
                             ){
        CPU cpu=new CPU();
        cpu.setcModel(Model);
        cpu.setcPrice(Price);
        cpu.setcParameter(Parmeter);
        cpu.setcRecommend(Recommend);
        cpu.setcWeight("0.1");
        repository.save(cpu);

    }

    //删除记录
    @GetMapping("/dropcpu/{model}")
    public String dropCpu(@PathVariable("model") String id){
        repository.deleteById(id);
        return "Successed!";
    }




}
