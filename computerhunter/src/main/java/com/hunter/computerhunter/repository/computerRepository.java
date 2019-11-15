package com.hunter.computerhunter.repository;

import com.hunter.computerhunter.entity.computer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface computerRepository extends JpaRepository<computer,String> {
    /**
     * 通过型号查找电脑
     * @param name model
     * @return Optional<computer>
     */
    public Optional<computer> findByModel(String name);

    /**
     * 通过型号和品牌查找电脑
     * @param model
     * @param brand
     * @return Optional<computer>
     */
    public Optional<computer> findByModelAndBrand(String model,String brand);

    /**
     * 是否存在具有关键词1的电脑
     * @return Boolean
     */
    public Boolean findByCharacterOneIs(String characterOne);

    /**
     * 是否存在具有关键词2的电脑
     * @param characterTwo 关键词2
     * @return Boolean
     */
    public Boolean findByCharacterTwoIs(String characterTwo);

    /**
     * 是否存在具有关键词3的电脑
     * @param characterThree
     * @return
     */
    public Boolean findByCharacterThreeIs(String characterThree);

    /**
     * 是否存在具有关键词1和关键词2的电脑
     * @param characterOne
     * @param characterTwo
     * @return
     */
    public Boolean findByCharacterOneIsAndCharacterTwoIs(String characterOne,String characterTwo);

    /**
     * 是否存在具有关键词1和关键词3的电脑
     * @param characterOne
     * @param characterThree
     * @return
     */
    public Boolean findByCharacterOneIsAndCharacterThreeIs(String characterOne,String characterThree);

    /**
     * 是否存在具有关键词2和关键词3的电脑
     * @param characterTwo
     * @param characterThree
     * @return
     */
    public Boolean findByCharacterTwoIsAndCharacterThreeIs(String characterTwo,String characterThree);
    /**
     * 找出所有具有关键词1、关键词2和关键词3的电脑
     * @param characterOne
     * @param characterTwo
     * @param characterThree
     * @return
     */
    public List<computer> findAllByCharacterOneOrCharacterTwoOrCharacterThree(String characterOne,String characterTwo,String characterThree);

    public void deleteByModel(String model);

    public List<computer> findAllByCpuNameAndDisplayCardNameAndMemoryNameAndHardDiskName(String cpuName, String displayCardName, String memoryName, String hardDisk);
}
