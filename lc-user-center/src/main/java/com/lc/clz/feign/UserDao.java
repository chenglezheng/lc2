package com.lc.clz.feign;

import com.lc.clz.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {

	User getByMenuId(Long id);

	User getUserByUsername(String userName);

}
