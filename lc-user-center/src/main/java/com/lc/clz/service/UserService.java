package com.lc.clz.service;

/*import com.codingapi.txlcn.tc.annotation.LcnTransaction;*/

import com.lc.clz.dao.PermissionDao;
import com.lc.clz.dao.RoleDao;
import com.lc.clz.dao.UserDao;
import com.lc.clz.entities.Permission;
import com.lc.clz.entities.Role;
import com.lc.clz.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Slf4j
@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;


    public User getUserByUserName(String userName){
        return userDao.getUserByuserName(userName);
    }

    public Set<Role> getRolesByUserId(Long userId){
        return roleDao.getRolesByUserId(userId);
    }

    public Set<Permission> getPermissionByUserId(Long userId){
        return permissionDao.getPermissionByRoledIds(roleDao.getRoleIdsByUserId(userId));
    }

}
