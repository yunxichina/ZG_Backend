package com.central.common.feign.fallback;

import com.central.common.feign.CustomerService;
import com.central.common.model.customer.Customer;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * userService降级工场
 *
 * @author zlt
 * @date 2019/1/18
 */
@Slf4j
@Component
public class CustomerServiceFallbackFactory implements FallbackFactory<CustomerService> {
    @Override
    public CustomerService create(Throwable throwable) {
        return new CustomerService() {
            @Override
            public Customer selectByUsername(String username) {
                log.error("通过用户名查询用户异常:{}", username, throwable);
                return new Customer();
            }


        };
    }
}
