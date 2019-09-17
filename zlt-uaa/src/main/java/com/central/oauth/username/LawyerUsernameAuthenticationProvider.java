package com.central.oauth.username;

import com.central.oauth.service.LawyerDetailService;
import com.central.oauth2.common.token.LawyerUsernameAuthenticationToken;
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
public class LawyerUsernameAuthenticationProvider implements AuthenticationProvider {
    private LawyerDetailService lawyerDetailService;
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) {
        LawyerUsernameAuthenticationToken authenticationToken = (LawyerUsernameAuthenticationToken) authentication;
        String username = (String) authenticationToken.getPrincipal();
        String password = (String) authenticationToken.getCredentials();
        UserDetails user = lawyerDetailService.loadUserByUsername(username);

        if (user == null) {
            throw new InternalAuthenticationServiceException("账户名或密码错误");
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("账户名或密码错误");
        }
        LawyerUsernameAuthenticationToken authenticationResult = new LawyerUsernameAuthenticationToken(user, password, user.getAuthorities());
        authenticationResult.setDetails(authenticationToken.getDetails());
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return LawyerUsernameAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
