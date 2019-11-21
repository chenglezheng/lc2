package com.lc.clz.controller;

import com.lc.clz.entities.User;
import com.lc.clz.service.MenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(description = "基础服务")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping(value = "/add")
    public void addMenu(@RequestBody User user){
        return menuService.addUser(user);
    }


}

