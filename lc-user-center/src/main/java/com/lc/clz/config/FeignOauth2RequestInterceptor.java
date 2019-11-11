package com.lc.clz.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class FeignOauth2RequestInterceptor implements RequestInterceptor {

    private final String AUTHORIZATION_HEADER="access_token";

    private final String BEARER_TOKEN_TYPE="bearer";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null && authentication.getDetails() instanceof OAuth2AuthenticationDetails){
            OAuth2AuthenticationDetails details=(OAuth2AuthenticationDetails) authentication.getDetails();
            System.out.println(details.getTokenValue());
            requestTemplate.header(AUTHORIZATION_HEADER,String.format("%s %s",BEARER_TOKEN_TYPE,details.getTokenValue()));
        }
    }
}
