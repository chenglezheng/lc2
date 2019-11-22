package com.lc.clz.controller;

import com.lc.clz.entity.Menu;
import com.lc.clz.service.MenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(description = "菜单服务")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 添加用户
     * @param menu
     * @return
     */
    @PostMapping(value = "/add")
    public Menu addMenu(@RequestBody Menu menu){
        return menuService.addMenu(menu);
    }


}

