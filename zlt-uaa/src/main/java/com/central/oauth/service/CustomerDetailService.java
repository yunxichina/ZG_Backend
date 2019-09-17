package com.central.oauth.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public interface CustomerDetailService {

    UserDetails loadUserByUsername(String var1) throws UsernameNotFoundException;

}
