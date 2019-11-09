package com.zking.controller;

import com.zking.entity.newUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface signinController extends JpaRepository<newUserEntity,Integer> {

    public newUserEntity findByEmailOrPhonenumber(String email,String phoneNum);
}
