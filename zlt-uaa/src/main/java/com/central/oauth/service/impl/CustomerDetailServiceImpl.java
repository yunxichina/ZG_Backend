package com.central.oauth.service.impl;

import com.central.common.feign.CustomerService;
import com.central.common.model.customer.CusRole;
import com.central.common.model.customer.Customer;
import com.central.common.model.sysuser.LoginAppUser;
import com.central.common.model.sysuser.SysRole;
import com.central.oauth.service.CustomerDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerDetailServiceImpl implements CustomerDetailService {
    @Resource
    private CustomerService customerService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     Customer cus =  customerService.selectByUsername(username);
     return  checkCustomer(cus);
    }

    private Customer checkCustomer(Customer customer) {
        if (customer != null && !customer.isEnabled()) {
            throw new DisabledException("客户被禁用");
        }
        return customer;
    }
}
