package com.lc.clz.service;

/*import com.codingapi.txlcn.tc.annotation.LcnTransaction;*/

import com.lc.clz.dao.PermissionDao;
import com.lc.clz.dao.RoleDao;
import com.lc.clz.dao.UserDao;
import com.lc.clz.entities.Permission;
import com.lc.clz.entities.Role;
import com.lc.clz.entities.User;
import com.lc.clz.enums.ServiceStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public User getUserByUserName(String userName){
        return userDao.getUserByUserName(userName);
    }

    public Set<Role> getRolesByUserId(Long userId){
        return roleDao.getRolesByUserId(userId);
    }

    public Set<Permission> getPermissionByUserId(Long userId){
        if(roleDao.getRoleIdsByUserId(userId)!=null && roleDao.getRoleIdsByUserId(userId).size()>0){
            return permissionDao.getPermissionByRoledIds(roleDao.getRoleIdsByUserId(userId));
        }else{
            return null;
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    public User addUser(User user){
        try {
            if(getUserByUserName(user.getUserName())==null){
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                userDao.save(user);
            }else{
                user.setUserName("用户已存在");
            }
            return user;
        }catch (Exception e){
            e.printStackTrace();
            user.setUserName(ServiceStatusEnum.getServiceStatus.serviceException().toString());
            return user;
        }
    }
}
