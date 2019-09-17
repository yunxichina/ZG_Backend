package com.central.oauth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LawyerDetailService {

    UserDetails loadUserByUsername(String var1) throws UsernameNotFoundException;

}
