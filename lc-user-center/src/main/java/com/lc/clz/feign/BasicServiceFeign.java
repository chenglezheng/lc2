package com.lc.clz.feign;

import com.lc.clz.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="lc-basic-service",fallback = BasicServiceFeign.BasicServiceFeignCallback.class)
public interface BasicServiceFeign {


    @PostMapping(value = "/add",consumes = "application/json")
    User addUser(@RequestBody User user);

    @GetMapping(value = "/select/{userId}")
    User selectUser(@PathVariable("userId") Long userId);

    @GetMapping(value = "/test")
    User test();

    @Component
    class BasicServiceFeignCallback implements BasicServiceFeign {
        @Override
        public User test() {
            System.out.println("还是失败");
            return null;
        }

        @Override
        public User selectUser(Long userId) {
            System.out.println("失败");
            return null;
        }

        @Override
        public User addUser(User user) {
            System.out.println("failed!");
            return null;
        }
    }
}
