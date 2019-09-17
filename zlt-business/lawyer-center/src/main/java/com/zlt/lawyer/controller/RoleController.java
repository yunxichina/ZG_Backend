package com.zlt.lawyer.controller;

import com.central.common.model.PageResult;
import com.central.common.model.Result;
import com.central.common.model.lawyer.LawRole;
import com.zlt.lawyer.service.IRoleService;
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
 * @date 2019-07-16 14:58:10
 */
@Slf4j
@RestController
@RequestMapping("/role")
@Api(tags = "")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("/role")
    public PageResult list(@RequestParam Map<String, Object> params) {
        return roleService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/role/{id}")
    public Result findUserById(@PathVariable Long id) {
        LawRole model = (LawRole) roleService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     *
     */

    /*  *//**
     * 新增or更新
     *//*
    @ApiOperation(value = "保存")
    @PostMapping("/role")
    public Result save(@RequestBody Role role) {
        roleService.saveOrUpdateUser(role);
        return Result.succeed("保存成功");
    }

    *//**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/role/{id}")
    public Result delete(@PathVariable Long id) {
        roleService.removeById(id);
        return Result.succeed("删除成功");
    }
}
