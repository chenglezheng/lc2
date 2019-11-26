package com.lc.clz.service;

import com.lc.clz.entities.LoginUser;
import com.lc.clz.entities.Permission;
import com.lc.clz.entities.Role;
import com.lc.clz.entities.User;
import com.lc.clz.dao.UserClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chenglezheng
 * @date 2019-11-22 16:06
 */
@Service
public class UserService {

    @Autowired
    private UserClient userClient;

    public LoginUser findByUserName(String userName) {
        User user = userClient.getUserByUsername(userName);
        if (user != null) {
            LoginUser LoginUser = new LoginUser();
            BeanUtils.copyProperties(user, LoginUser);
            Set<Role> roles = userClient.getRolesByUserId(user.getId());
            LoginUser.setRoles(roles);   // 设置角色集合
            Set<Permission> sysPermissions = userClient.getPermissionByUserId(user.getId());
            if (!CollectionUtils.isEmpty(sysPermissions)) {
                Set<String> permissions = sysPermissions.parallelStream().map(Permission::getPermission).collect(Collectors.toSet());
                LoginUser.setPermissions(permissions);// 设置权限集合
            }
            return LoginUser;
        }
        return null;
    }
}
