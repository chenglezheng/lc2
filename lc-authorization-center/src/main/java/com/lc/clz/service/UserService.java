package com.lc.clz.service;

import com.lc.clz.entities.LoginUser;
import com.lc.clz.entities.SysPermission;
import com.lc.clz.entities.SysRole;
import com.lc.clz.entities.User;
import com.lc.clz.feign.UserClient;
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

    public LoginUser findByUsername(String username) {
        User user = userClient.getUserByUsername(username);
        if (user != null) {
            LoginUser LoginUser = new LoginUser();
            BeanUtils.copyProperties(user, LoginUser);
            Set<SysRole> sysRoles = userClient.getRolesByUserId(user.getId());
            LoginUser.setSysRoles(sysRoles);// 设置角色
            if (!CollectionUtils.isEmpty(sysRoles)) {
                Set<Long> roleIds = sysRoles.parallelStream().map(SysRole::getId).collect(Collectors.toSet());
                Set<SysPermission> sysPermissions = userClient.getPermissionByRoleIds(roleIds);
                if (!CollectionUtils.isEmpty(sysPermissions)) {
                    Set<String> permissions = sysPermissions.parallelStream().map(SysPermission::getPermission).collect(Collectors.toSet());
                    LoginUser.setPermissions(permissions);// 设置权限集合
                }
            }

            return LoginUser;
        }

        return null;
    }
}
