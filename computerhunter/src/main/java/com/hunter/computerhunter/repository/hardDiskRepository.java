package com.hunter.computerhunter.repository;

import com.hunter.computerhunter.entity.hardDisk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface hardDiskRepository extends JpaRepository<hardDisk,String> {
    hardDisk findByhWeight(String c);
    hardDisk findByhModel(String c);
}
