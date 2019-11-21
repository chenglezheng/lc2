package com.lc.clz.service;

//import com.codingapi.txlcn.tc.annotation.LcnTransaction;

import com.lc.clz.dao.MenuDao;
import com.lc.clz.entity.Menu;
import com.lc.clz.entity.MenuId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenglezheng on 2018/12/28.
 */
@Service
@CacheConfig(cacheNames="MenuCache") // 本类内方法指定使用缓存时，默认的名称就是MenuCache
@Transactional(readOnly=true)
public class MenuService {

    private  final  String  PREFIX =this.getClass().getName().toUpperCase();

    @Autowired
    private MenuDao menuDao;


    @CachePut(key="#p0.menuId.getMenuCode()")
    @Transactional(rollbackFor = Throwable.class)
    public Menu addMenu(Menu Menu) {
        Menu=new Menu();
        return Menu;
    }


    @Cacheable(key="'com.lc.clz.entities.Menu'+#MenuId") // @Cacheable 会先查询缓存，如果缓存中存在，则不执行方法
    public Menu selectMenu(MenuId menuId) {
        Menu menu =menuDao.getByMenuId(menuId);
        return menu;
    }


    @CacheEvict(key="#p0")  //删除缓存名称为MenuCache,key等于指定的id对应的缓存
    public String deleteMenu(Menu menuId) {
        return null;
    }


}
