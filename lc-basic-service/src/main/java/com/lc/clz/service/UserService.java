package com.lc.clz.service;

import com.lc.clz.entities.user.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by chenglezheng on 2018/12/28.
 */


public interface UserService {

    User addUser(User user);

    User updateUser(@PathVariable("userId") Long userId);

    User selectUser(@PathVariable("userId") Long userId);

    String deleteUser(@PathVariable("userId") Long userId);

    String deleteAllUser();

    Map<String,Object> selectUserWithPage(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit);

}
