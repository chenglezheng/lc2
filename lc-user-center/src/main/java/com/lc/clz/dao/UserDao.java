package com.lc.clz.dao;

import com.lc.clz.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {


    User getUserByUserName(String userName);

    @Override
    <S extends User> S save(S s);
}
