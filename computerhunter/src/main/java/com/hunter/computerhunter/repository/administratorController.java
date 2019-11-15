package com.hunter.computerhunter.repository;

import com.hunter.computerhunter.entity.administratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface administratorController extends JpaRepository<administratorEntity,String> {
    public administratorEntity findByAccount(String account);
}
