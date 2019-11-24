package com.lc.clz.controller;

import com.lc.clz.entities.Menu;
import com.lc.clz.entities.MenuId;
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
     * 根据菜单ID（菜单编码和菜单实际值获取菜单）
     * @param menuId
     * @return
     */
    @PostMapping(value = "/add")
    public Menu selectMenuByMenuId(@RequestBody MenuId menuId){
        return menuService.selectMenuByMenuId(menuId);
    }


}

