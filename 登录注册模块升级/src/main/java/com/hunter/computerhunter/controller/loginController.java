package com.hunter.computerhunter.controller;

import com.hunter.computerhunter.entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface loginController extends JpaRepository<userEntity,String> {
    public userEntity findByEmailOrPhonenumber(String email,String phonenumber);

    public userEntity findByEmail(String email);

    public userEntity findByPhonenumber(String phonenumber);

}
