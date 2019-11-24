package com.lc.clz.feign;

import com.lc.clz.entities.Permission;
import com.lc.clz.entities.Role;
import com.lc.clz.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name="lc-user-center",fallback = UserClient.UserClientCallback.class)
public interface UserClient {

    @GetMapping(value = "/getUserByuserName")
    User getUserByuserName(@RequestParam("userName") String userName);

    @GetMapping(value = "/getRolesByUserId")
    Set<Role> getRolesByUserId(@RequestParam("userId") Long userId);

    @GetMapping(value = "/getPermissionByUserId")
    Set<Permission> getPermissionByUserId(@RequestParam("userId") Long userId);


    @Component
    class UserClientCallback implements UserClient {
        @Override
        public User getUserByuserName(String userName) {
            return null;
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
