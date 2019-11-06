package com.lc.clz.feign;

import com.lc.clz.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="lc-basic-service",fallback = BasicServiceFeign.BasicServiceFeignCallback.class)
public interface BasicServiceFeign {


    @PostMapping(value = "/add")
    User addUser(@RequestBody User user);


    @Component
    class BasicServiceFeignCallback implements BasicServiceFeign {

        @Override
        public User addUser(User user) {
            System.out.println("failed");
            user.setUserName("用户添加失败");
            return user;
        }
    }
}
