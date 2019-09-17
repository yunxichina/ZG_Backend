package com.zlt.lawyer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.central.common.model.PageResult;
import com.central.common.model.customer.Customer;

import java.util.Map;

/**
 *
 *
 * @author zlt
 * @date 2019-07-02 17:21:03
 */
public interface ICustomerService extends IService<Customer> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<Customer> findList(Map<String, Object> params);

    /**
     * 根据用户名查询用户信息
     */
    Customer selectByUsername(String username);



    /**
     * 根据手机号查询用户信息
     */
    Customer selectByMobile(String mobile);
}

