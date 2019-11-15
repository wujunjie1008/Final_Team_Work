package com.hunter.computerhunter.controller;

import com.hunter.computerhunter.entity.CPU;
import com.hunter.computerhunter.repository.*;
import com.hunter.computerhunter.service.computerService;
import com.hunter.computerhunter.entity.computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/computers")
public class computerController {

    @Autowired
    private computerRepository computerrepository;

    @Autowired
    private CPURepository cpurepository;

    @Autowired
    private displayCardRepository displaycardrepository;

    @Autowired
    private hardDiskRepository harddiskrepository;

    @Autowired
    private memoryRepository memoryrepository;

    @Autowired
    private computerService service;

    //进入硬件匹配界面
    @GetMapping(value = {"/hardwareSearchPage","/hardwareSearchPage.html"})
    public String hardwareSearchPage() {
        return "hardwareSearchPage";
    }
    //进入关键词匹配界面
    @GetMapping(value = {"/keywordSearchtPage","/keywordSearchPage.html"})
    public String keywordSearchtPage() {
        return "keywordSearchtPage";
    }
    //进入电脑猎场
    @GetMapping(value = "/computerResultPage")
    public String computerResultPage() {
        return "电脑猎场";
    }
    //
    @GetMapping(value = "/hardwareKonwledgePage")
    public String hardwareKonwledgePage(){
        return "硬件知识";
    }
    /**增加电脑*/
    @PostMapping("/addComputer")
    @ResponseBody
    public computer create(computer compu){
        compu.setBrand(compu.getBrand());
        compu.setBuyUrl1(compu.getBuyUrl1());
        compu.setBuyUrl2(compu.getBuyUrl2());
        compu.setBuyUrl3(compu.getBuyUrl3());
        compu.setCharacterOne(compu.getCharacterOne());
        compu.setCharacterTwo(compu.getCharacterTwo());
        compu.setCharacterThree(compu.getCharacterThree());
        compu.setCpuWeight(compu.getCpuWeight());
        compu.setCpuName(compu.getCpuName());
        compu.setMemoryWeight(compu.getMemoryWeight());
        compu.setMemoryName(compu.getMemoryName());
        compu.setDisplayCardWeight(compu.getDisplayCardWeight());
        compu.setDisplayCardName(compu.getDisplayCardName());
        compu.setHardDiskWeight(compu.getHardDiskWeight());
        compu.setHardDiskName(compu.getHardDiskName());
        compu.setModel(compu.getModel());
        compu.setPrice(compu.getPrice());
        compu.setComputerExplain(compu.getComputerExplain());

        return computerrepository.save(compu);
    }

    /**
     * 通过型号查询电脑
     */
    @GetMapping(value = "/findByModel")
    @ResponseBody
    public computer computerFindByModel(String model) {
        return computerrepository.findByModel(model).orElse(null);
    }
    /**
     * 通过型号和品牌查询电脑
     */
    @GetMapping(value = "/findByModelAndBrand")
    @ResponseBody
    public computer computerFindByModelAndBrand(String model, String brand) {
        return computerrepository.findByModelAndBrand(model,brand).orElse(null);
    }
    /**
     * 更新电脑
     */
    @PutMapping(value = "/updateByModel")
    @ResponseBody
    public computer computerUpdateByModel(String model, String brand, String buyUrl1, String buyUrl2, String buyUrl3,
                                          String characterOne, String characterTwo, String characterThree, int cpuWeight,
                                          String cpuName, int memoryWeight, String memoryName, int displayCardWeight, String displayCardName,
                                          int hardDiskWeight, String hardDiskName, int price, String computerExplain){
        Optional<computer> optional = computerrepository.findByModel(model);
        if(optional.isPresent())
        {
            computer compu = optional.get();
            compu.setBrand(brand);
            compu.setBuyUrl1(buyUrl1);
            compu.setBuyUrl2(buyUrl2);
            compu.setBuyUrl3(buyUrl3);
            compu.setCharacterOne(characterOne);
            compu.setCharacterTwo(characterTwo);
            compu.setCharacterThree(characterThree);
            compu.setCpuWeight(cpuWeight);
            compu.setCpuName(cpuName);
            compu.setMemoryWeight(memoryWeight);
            compu.setMemoryName(memoryName);
            compu.setDisplayCardWeight(displayCardWeight);
            compu.setDisplayCardName(displayCardName);
            compu.setHardDiskWeight(hardDiskWeight);
            compu.setHardDiskName(hardDiskName);
            compu.setPrice(price);
            compu.setComputerExplain(computerExplain);

            return computerrepository.save(compu);
        }
        return  null;
    }

    /**
     * 删除电脑
     * @param model
     */
    @DeleteMapping(value = "/deleteComputer")
    @ResponseBody
    public void computerDelete (String model) {
        computerrepository.deleteByModel(model);
    }

    /**
     * 关键字查询
     * @param one
     * @param two
     * @param three
     * @return
     */
    @GetMapping("/keywordSearch")
    @ResponseBody
    public List<computer> keywordSearch(String one, String two, String three) {
        return service.keywordSearch(one, two, three);
    }
    /**
     * 硬件匹配
     */
    @RequestMapping("/hardwareSearch")
    @ResponseBody
    public  List<computer> handwareSearch(String cpuName, String displayCardName, String memoryName, String hardDiskName/*,
                                         int cpuWeight, int displayWeight, int memoryWeight, int hardDiskWeight*/){
        List<computer> list1 = computerrepository.findAllByCpuNameAndDisplayCardNameAndMemoryNameAndHardDiskName(cpuName,displayCardName,memoryName,hardDiskName);
        if(!list1.isEmpty()) {
            return service.hardwareSearchByName(cpuName,displayCardName,memoryName,hardDiskName);
        }
 /*       else {
            CPU c = cpurepository.findBycModel(cpuName);
            int cpuWeight = c.getcWeight();
            return service.hardwardSearchByWeight(cpuWeight, displayWeight, memoryWeight, hardDiskWeight);
       }*/
        return null;
    }
}
