package com.zlt.lawyer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.central.common.model.*;
import com.central.common.model.customer.Customer;
import com.zlt.lawyer.mapper.CustomerMapper;
import com.zlt.lawyer.mapper.RoleCustomerMapper;
import com.zlt.lawyer.mapper.RoleMenuMapper;
import com.zlt.lawyer.service.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author cyq
 * @date 2019-07-02 17:21:03
 */
@Slf4j
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Resource
    RoleCustomerMapper roleCustomerMapper;

    @Resource
    RoleMenuMapper roleMenuMapper;
    /**
     * 列表
     * @param params
     * @return
     */
    public PageResult<Customer> findList(Map<String, Object> params){
        Integer page = MapUtils.getInteger(params, "page");
        Integer limit = MapUtils.getInteger(params, "limit");
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = -1;
        }
        Page<Customer> pages = new Page<>(page, limit);
        List<Customer> list  =  baseMapper.findList(pages, params);
        return PageResult.<Customer>builder().data(list).code(0).count(pages.getTotal()).build();
    }

    @Override
    public Customer selectByUsername(String username) {
        List<Customer> customers =
                baseMapper.selectList( new QueryWrapper<Customer>().eq("username", username));
        return getCustomer(customers);
    }

    @Override
    public Customer selectByMobile(String mobile) {
        List<Customer> customers =
                baseMapper.selectList( new QueryWrapper<Customer>().eq("mobile", mobile));
        return getCustomer(customers);
    }


    private Customer getCustomer( List<Customer> customers){
        Customer cus = null;
        if(customers!=null&&!customers.isEmpty()){
          cus =  getUserRolePermission(customers.get(0));
        }
        return cus;
    }
    /**
     * 获取用户角色权限数据并返回
     */
    private Customer getUserRolePermission(Customer customer) {
        // TODO: 2019/9/11 0011
        return customer;
    }


}
