package com.lc.clz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class OAuth2Controller {

    @Autowired
    private TokenStore tokenStore;


    /**
     * 获得用户和token等相关信息
     * @param principal
     * @return
     */
    @GetMapping("/getPrincipal")
    public Principal getPrincipal(Principal principal) {
        return principal;
    }


    /**
     * 移除access_token，refresh_token 用户退出
     * @param principal
     * @param access_token
     */
    @DeleteMapping(value = "/remove_token")
    public void removeToken(Principal principal,@RequestParam("access_token") String access_token) {
        OAuth2AccessToken accessToken=tokenStore.readAccessToken(access_token);
        if (access_token!=null){
            tokenStore.removeAccessToken(accessToken);
            tokenStore.removeRefreshToken(accessToken.getRefreshToken());
        }
    }


}
