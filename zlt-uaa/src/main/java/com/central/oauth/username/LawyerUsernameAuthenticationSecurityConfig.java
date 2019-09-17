package com.central.oauth.username;

import com.central.oauth.service.LawyerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.stereotype.Component;

/**
 * mobile的相关处理配置
 *
 * @author zlt
 */
@Component
public class LawyerUsernameAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private LawyerDetailService lawyerDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(HttpSecurity http) {
        //mobile provider
        LawyerUsernameAuthenticationProvider provider = new LawyerUsernameAuthenticationProvider();
        provider.setLawyerDetailService(lawyerDetailService);
        provider.setPasswordEncoder(passwordEncoder);
        http.authenticationProvider(provider);
}
}
