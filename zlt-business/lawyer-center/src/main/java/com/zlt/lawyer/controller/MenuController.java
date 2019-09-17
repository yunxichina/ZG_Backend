package com.zlt.lawyer.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.central.common.constant.CommonConstant;
import com.central.common.model.Result;
import com.central.common.model.lawyer.LawMenu;
import com.central.common.model.lawyer.LawRole;
import com.central.common.model.lawyer.Lawyer;
import com.zlt.lawyer.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 *
 * @author cyq
 * @date 2019-07-16 14:58:10
 */
@Slf4j
@RestController
@RequestMapping("/menu")
@Api(tags = "")
public class MenuController {
    @Autowired
    private IMenuService menuService;


    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/{id}")
    public Result findUserById(@PathVariable Long id) {
        LawMenu model = menuService.getById(id);
        return Result.succeed(model, "查询成功");
    }

   /* *//**
     * 新增or更新
     *//*
    @ApiOperation(value = "保存")
    @PostMapping("/menu")
    public Result save(@RequestBody LawMenu menu) {
        menuService.saveOrUpdateUser(menu);
        return Result.succeed("保存成功");
    }*/

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        menuService.removeById(id);
        return Result.succeed("删除成功");
    }

/*
    *//**
     * 当前登录用户的菜单
     *
     * @return
     *//*
    @GetMapping("/current")
    @ApiOperation(value = "查询当前用户菜单")
    public List<LawMenu> findMyMenu(Lawyer lawyer) {
        List<LawRole> roles = lawyer.getRoles();
        if (CollectionUtil.isEmpty(roles)) {

            return Collections.emptyList();
        }
        List<LawMenu> menus = menuService.findByRoleCodes(roles.parallelStream().map(LawRole::getCode).collect(Collectors.toSet()), CommonConstant.MENU);
        return menus;
    }*/

}
