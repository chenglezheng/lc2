package com.lc.clz.feign;

import com.lc.clz.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/*@FeignClient(name="lc-basic-service",fallback = BasicServiceFeign.BasicServiceFeignCallback.class)*/
public interface BasicServiceFeign {


    /*@GetMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    User addUser(User user);

    @Component
    class BasicServiceFeignCallback implements BasicServiceFeign {
        @Override
        public User addUser(User user) {
            return null;
        }
    }*/
}
