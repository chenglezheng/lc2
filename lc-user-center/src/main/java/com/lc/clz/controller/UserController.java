package com.lc.clz.controller;

import com.lc.clz.entities.Permission;
import com.lc.clz.entities.Role;
import com.lc.clz.entities.User;
import com.lc.clz.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
@Api(description = "用戶服务")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    @GetMapping(value = "/getUserByUsername")
    User getUserByUsername(@RequestParam("userName") String userName){
        return userService.getUserByUserName(userName);
    }

    /**
     * 根据用户id获取角色对象集合
     * @param userId
     * @return
     */
    @GetMapping(value = "/getRolesByUserId")
    Set<Role> getRolesByUserId(@RequestParam("userId") Long userId){
        return userService.getRolesByUserId(userId);
    }

    /**
     * 根据用户id获取权限集合
     * @param userId
     * @return
     */
    @GetMapping(value = "/getPermissionByUserId")
    Set<Permission> getPermissionByUserId(@RequestParam("userId") Long userId){
        return userService.getPermissionByUserId(userId);
    }


}
