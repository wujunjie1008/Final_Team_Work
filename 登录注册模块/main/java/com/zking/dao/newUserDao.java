package com.zking.dao;

import com.zking.entity.newUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface newUserDao extends CrudRepository<newUserEntity,Integer> {

    public newUserEntity findByUsernameAndPassword(String username,String password);

}