package com.lc.clz.feign;

import com.lc.clz.entities.Menu;
import com.lc.clz.entities.MenuId;
import org.springframework.data.repository.CrudRepository;

public interface MenuDao extends CrudRepository<Menu, MenuId> {

    Menu getByMenuCodeAndMenuActualValue(String menuCode,String menuActualValue);

}