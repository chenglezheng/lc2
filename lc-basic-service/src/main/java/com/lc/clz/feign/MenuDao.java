package com.lc.clz.feign;

import com.lc.clz.entity.Menu;
import com.lc.clz.entity.MenuId;
import org.springframework.data.repository.CrudRepository;

public interface MenuDao extends CrudRepository<Menu, MenuId> {

    Menu getByMenuId(MenuId menuId);

}