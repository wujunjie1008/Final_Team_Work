package com.hunter.computerhunter.repository;

import com.hunter.computerhunter.entity.memory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface memoryRepository extends JpaRepository<memory,String> {
    memory findBymWeight(String c);
    memory findBymModel(String c);
}
