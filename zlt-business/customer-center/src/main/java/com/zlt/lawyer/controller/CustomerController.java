package com.zlt.lawyer.controller;

import com.central.common.model.PageResult;
import com.central.common.model.Result;
import com.central.common.model.customer.Customer;
import com.zlt.lawyer.service.ICustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *
 *
 * @author cyq
 * @date 2019-07-02 17:21:03
 */
@Slf4j
@RestController
@Api(tags = "")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;


    /**
     * 根据用户名查询用户信息
     */
    @GetMapping(value = "/customer/name/{username}")
    @ApiOperation(value = "根据用户名查询用户实体")
    public Customer selectByUsername(@PathVariable String username) {
        Customer c = customerService.selectByUsername(username);
        return c;
    }


    /**
     * 通过手机号查询用户、角色信息
     * @param mobile 手机号
     */
    @GetMapping(value = "/customer-anon/mobile", params = "mobile")
    @ApiOperation(value = "根据手机号查询用户")
    public Customer findByMobile(String mobile) {
        return customerService.selectByMobile(mobile);
    }



    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public PageResult list(@RequestParam Map<String, Object> params) {
        return customerService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/customer/{id}")
    public Result findUserById(@PathVariable Long id) {
        Customer model = customerService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping("/customer")
    public Result save(@RequestBody Customer customer) {
        customerService.saveOrUpdate(customer);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/customer/{id}")
    public Result delete(@PathVariable Long id) {
        customerService.removeById(id);
        return Result.succeed("删除成功");
    }



}
