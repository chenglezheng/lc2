package com.lc.clz.feign;

import com.lc.clz.entities.SysPermission;
import com.lc.clz.entities.SysRole;
import com.lc.clz.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name="lc-user-center",fallback = UserClient.UserClientCallback.class)
public interface UserClient {

    @GetMapping(value = "/getUserByUsername")
    User getUserByUsername(@RequestParam("username") String username);

    @GetMapping(value = "/getRolesByUserId")
    Set<SysRole> getRolesByUserId(@RequestParam("userId") Long userId);

    @GetMapping(value = "/getPermissionByRoleIds")
    Set<SysPermission> getPermissionByRoleIds(@RequestBody Set<Long> roleIds);


    @Component
    class UserClientCallback implements UserClient {
        @Override
        public User getUserByUsername(String username) {
            return null;
        }

        @Override
        public Set<SysRole> getRolesByUserId(Long userId) {
            return null;
        }

        @Override
        public Set<SysPermission> getPermissionByRoleIds(Set<Long> roleIds) {
            return null;
        }
    }

}
