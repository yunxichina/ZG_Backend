package com.central.oauth.username;

import com.central.oauth.service.CustomerDetailService;
import com.central.oauth2.common.token.CustomerUsernameAuthenticationToken;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zlt
 */
@Setter
public class CustomerUsernameAuthenticationProvider implements AuthenticationProvider {
    private CustomerDetailService customerDetailService;
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) {
        CustomerUsernameAuthenticationToken authenticationToken = (CustomerUsernameAuthenticationToken) authentication;
        String username = (String) authenticationToken.getPrincipal();
        String password = (String) authenticationToken.getCredentials();
        UserDetails user = customerDetailService.loadUserByUsername(username);

        if (user == null) {
            throw new InternalAuthenticationServiceException("账户名或密码错误");
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("账户名或密码错误");
        }
        CustomerUsernameAuthenticationToken authenticationResult = new CustomerUsernameAuthenticationToken(user, password, user.getAuthorities());
        authenticationResult.setDetails(authenticationToken.getDetails());
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomerUsernameAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
