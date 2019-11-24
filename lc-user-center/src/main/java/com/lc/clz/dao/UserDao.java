package com.lc.clz.dao;

import com.lc.clz.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {


    User getUserByuserName(String userName);


}
