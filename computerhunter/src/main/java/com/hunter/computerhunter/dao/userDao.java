package com.hunter.computerhunter.dao;

import com.hunter.computerhunter.entity.userEntity;
import org.springframework.data.repository.CrudRepository;

public interface userDao extends CrudRepository<userEntity,Integer> {

}
