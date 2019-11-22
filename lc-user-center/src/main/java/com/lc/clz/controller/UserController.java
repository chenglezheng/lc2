package com.lc.clz.controller;

import com.lc.clz.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(description = "用戶服务")
public class UserController {

    @Autowired
    private UserService appUserService;




}
