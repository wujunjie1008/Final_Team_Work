package com.hunter.computerhunter.repository;

import  com.hunter.computerhunter.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InformationRepository extends JpaRepository<Information,Integer> {

     Information findBytitle(String title);
}
