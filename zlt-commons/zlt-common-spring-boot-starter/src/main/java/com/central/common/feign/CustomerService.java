package com.central.common.feign;

import com.central.common.constant.ServiceNameConstants;
import com.central.common.feign.fallback.CustomerServiceFallbackFactory;
import com.central.common.model.customer.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zlt
 */
@FeignClient(name = ServiceNameConstants.CUSTOMER_SERVICE, fallbackFactory = CustomerServiceFallbackFactory.class, decode404 = true)
public interface CustomerService {
    /**
     * feign rpc访问远程/Lawyer/{username}接口
     * 查询用户实体对象SysUser
     *
     * @param username
     * @return
     */
    @GetMapping(value = "/customer/name/{username}")
    Customer selectByUsername(@PathVariable("username") String username);



}
