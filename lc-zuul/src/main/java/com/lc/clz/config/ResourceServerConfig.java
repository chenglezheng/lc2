package com.lc.clz.config;

import com.lc.clz.utils.PermitUrlUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

/**
 * 资源服务配置
 *
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling()
				.authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
				.and().authorizeRequests()
				.antMatchers(PermitUrlUtils.permitAllUrl("/lc-user-center/v2/api-docs"
																,"/lc-auth-center/v2/api-docs"
																,"/lc-basic-service/v2/api-docs"
																,"/lc-quartz-service/v2/api-docs")).permitAll() // 放开权限的url
				.anyRequest().authenticated().and().httpBasic();
	}


}
