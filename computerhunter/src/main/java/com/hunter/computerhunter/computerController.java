package com.hunter.computerhunter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class computerController {

    @Autowired
    private computerRepository computerrepository;

    /**增加电脑*/
    @PostMapping("/computers")
    public computer create(computer compu){
        compu.setBrand(compu.getBrand());
        compu.setBuyUrl1(compu.getBuyUrl1());
        compu.setBuyUrl2(compu.getBuyUrl2());
        compu.setBuyUrl3(compu.getBuyUrl3());
        compu.setCharacterOne(compu.getCharacterOne());
        compu.setCharacterTwo(compu.getCharacterTwo());
        compu.setCharacterThree(compu.getCharacterThree());
        compu.setCpuWeight(compu.getCpuWeight());
        compu.setMemoryWeight(compu.getMemoryWeight());
        compu.setDisplayCardWeight(compu.getDisplayCardWeight());
        compu.setHardDiskWeight(compu.getHardDiskWeight());
        compu.setExplain(compu.getExplain());
        compu.setModel(compu.getModel());
        compu.setPrice(compu.getPrice());
        return computerrepository.save(compu);
    }

    /**
     * 通过型号查询电脑
     */

    /**
     * 更新电脑
     */
}
