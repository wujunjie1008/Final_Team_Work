package com.computerhunter.hunter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface hardDiskRepository extends JpaRepository<hardDisk,String> {
    hardDisk findByhWeight(String c);
    hardDisk findByhModel(String c);
}
