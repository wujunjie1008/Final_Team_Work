package com.hunter.computerhunter.repository;

import com.hunter.computerhunter.entity.displayCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface displayCardRepository extends JpaRepository<displayCard,String> {
    displayCard findBydWeight(String c);
    displayCard findBydModel(String c);
}
