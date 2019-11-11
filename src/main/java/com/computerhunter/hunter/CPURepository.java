package com.computerhunter.hunter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CPURepository extends JpaRepository<CPU,String> {

    CPU findBycWeight(String c);
    CPU findBycModel(String c);


}
