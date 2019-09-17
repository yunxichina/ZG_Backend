package com.zlt.lawyer.controller;

import java.util.Map;

import com.zlt.lawyer.model.OfficeLawyer;
import com.zlt.lawyer.model.Office;
import com.zlt.lawyer.service.IOfficeLawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import com.zlt.lawyer.service.IOfficeService;
import com.central.common.model.PageResult;
import com.central.common.model.Result;

/**
 *
 *
 * @author cyq
 * @date 2019-07-18 12:03:08
 */
@Slf4j
@RestController
@Api(tags = "")
public class OfficeController {
    @Autowired
    private IOfficeService iOfficeService;

    @Autowired
    private IOfficeLawyerService iOfficeLawyerService;
  /*  @Autowired
    private I*/
    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("/org")
    public PageResult list(@RequestParam Map<String, Object> params) {
        return iOfficeService.findList(params);
    }

    /**
     * 查询
     */
    @ApiOperation(value = "查询")
    @GetMapping("/org/{id}")
    public Result findUserById(@PathVariable Long  id) {
        Office model = iOfficeService.getById(id);
        return Result.succeed(model, "查询成功");
    }

    /**
     * 新增or更新
     */
    @ApiOperation(value = "保存")
    @PostMapping("/org")
    public Result save(@RequestBody Office office) {
        iOfficeService.saveOrUpdate(office);
        return Result.succeed("保存成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/org/{id}")
    public Result delete(@PathVariable Long id) {
        iOfficeService.removeById(id);
        return Result.succeed("删除成功");
    }

    /**
     * 给用户分配组织架构
     */

    @ApiOperation(value = "设置客户组织架构")
    @PostMapping("/org/setOrg")
    public Result setOrg(OfficeLawyer officeLawyer) {
       //设置客户组织架构
        iOfficeLawyerService.setOffice(officeLawyer);
        return Result.succeed("设置成功");
    }
}
