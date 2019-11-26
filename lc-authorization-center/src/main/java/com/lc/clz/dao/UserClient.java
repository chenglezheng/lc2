package com.lc.clz.dao;

import com.lc.clz.entities.Permission;
import com.lc.clz.entities.Role;
import com.lc.clz.entities.User;
import com.lc.clz.enums.ServiceStatusEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name="lc-user-center",fallback = UserClient.UserClientCallback.class)
public interface UserClient {

    @GetMapping(value = "/getUserByUsername")
    User getUserByUsername(@RequestParam("userName") String userName);

    @GetMapping(value = "/getRolesByUserId")
    Set<Role> getRolesByUserId(@RequestParam("userId") Long userId);

    @GetMapping(value = "/getPermissionByUserId")
    Set<Permission> getPermissionByUserId(@RequestParam("userId") Long userId);


    @Component
    class UserClientCallback implements UserClient {
        @Override
        public User getUserByUsername(String userName) {
            User user=new User();
            user.setUserName(ServiceStatusEnum.getServiceStatus.serviceException().toString());
            user.setIsEnabled(false);
            return user;
        }

        @Override
        public Set<Role> getRolesByUserId(Long userId) {
            return null;
        }

        @Override
        public Set<Permission> getPermissionByUserId(Long userId) {
            return null;
        }
    }

}
