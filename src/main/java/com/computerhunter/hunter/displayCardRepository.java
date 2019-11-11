package com.computerhunter.hunter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface displayCardRepository extends JpaRepository<displayCard,String> {
    displayCard findBydWeight(String c);
    displayCard findBydModel(String c);
}
