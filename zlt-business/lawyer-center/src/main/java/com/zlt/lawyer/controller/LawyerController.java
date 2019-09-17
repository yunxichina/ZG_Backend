package com.zlt.lawyer.controller;

import com.central.common.model.PageResult;
import com.central.common.model.Result;
import com.central.common.model.lawyer.Lawyer;
import com.zlt.lawyer.service.ILawyerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
public class LawyerController {
    @Autowired
    private ILawyerService lawyerService;


    /**
     * 根据用户名查询用户信息
     */
    @GetMapping(value = "/lawyer/name/{username}")
    @ApiOperation(value = "根据用户名查询用户实体")
    public Lawyer selectByUsername(@PathVariable String username) {
        Lawyer c = lawyerService.selectByUsername(username);
        return c;
    }


    /**
     * 通过手机号查询用户、角色信息
     * @param mobile 手机号
     */
    @GetMapping(value = "/lawyer-anon/mobile", params = "mobile")
    @ApiOperation(value = "根据手机号查询用户")
    public Lawyer findByMobile(String mobile) {
        return lawyerService.selectByMobile(mobile);
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
        return lawyerService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/lawyer/{id}")
    public Result findUserById(@PathVariable Long id) {
        Lawyer model = lawyerService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping("/lawyer")
    public Result save(@RequestBody Lawyer lawyer) {
        lawyerService.saveOrUpdate(lawyer);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/lawyer/{id}")
    public Result delete(@PathVariable Long id) {
        lawyerService.removeById(id);
        return Result.succeed("删除成功");
    }



}
