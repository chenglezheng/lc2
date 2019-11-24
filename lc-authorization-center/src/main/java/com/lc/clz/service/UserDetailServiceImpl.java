package com.lc.clz.service;

import com.lc.clz.entities.LoginUser;
import com.lc.clz.enums.CredentialType;
import com.lc.clz.enums.ServiceStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户详情服务
 */
@Slf4j
@Service("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;


    /**
     * 获取用户详情
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        String[] params = userName.split("\\|");// 为支持多类型登录,username后面拼装上登录类型,如username|type
        userName = params[0];
        LoginUser LoginUser = userService.findByUserName(userName);
        if (LoginUser == null) {
            throw new AuthenticationCredentialsNotFoundException("用户不存在");
        }else if (LoginUser.getUsername().equals(ServiceStatusEnum.getServiceStatus.serviceException().toString())) {
            throw new DisabledException("用户请求异常");
        } else if (!LoginUser.isEnabled()) {
            throw new DisabledException("用户已作废");
        }

        // TODO: 2019/11/22 需要对不同的登录类型做个性化处理
        if (params.length > 1) {
            CredentialType credentialType = CredentialType.valueOf(params[1]);
            if (CredentialType.PHONE == credentialType) {
                // 短信登录

            } else if (CredentialType.WECHAT_OPENID == credentialType) {
                // 微信登陆

            }
        }
        return LoginUser;
    }

}
