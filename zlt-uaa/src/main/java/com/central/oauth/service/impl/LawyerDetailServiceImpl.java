package com.central.oauth.service.impl;

import com.central.common.feign.LawyerService;
import com.central.common.model.lawyer.Lawyer;
import com.central.oauth.service.LawyerDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class LawyerDetailServiceImpl implements LawyerDetailService {
    @Resource
    private LawyerService lawyerService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     Lawyer lawyer =  lawyerService.selectByUsername(username);
     return  checkLawyer(lawyer);
    }

    private Lawyer checkLawyer(Lawyer lawyer) {
        if (lawyer != null && !lawyer.isEnabled()) {
            throw new DisabledException("该律师被禁用");
        }
        return lawyer;
    }
}
