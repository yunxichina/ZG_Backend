package com.zlt.lawyer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.central.common.model.*;
import com.central.common.model.lawyer.Lawyer;
import com.zlt.lawyer.mapper.LawyerMapper;
import com.zlt.lawyer.mapper.RoleLawyerMapper;
import com.zlt.lawyer.mapper.RoleMenuMapper;
import com.zlt.lawyer.service.ILawyerService;
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
public class LawyerServiceImpl extends ServiceImpl<LawyerMapper, Lawyer> implements ILawyerService {

    @Resource
    RoleLawyerMapper roleLawyerMapper;

    @Resource
    RoleMenuMapper roleMenuMapper;
    /**
     * 列表
     * @param params
     * @return
     */
    public PageResult<Lawyer> findList(Map<String, Object> params){
        Integer page = MapUtils.getInteger(params, "page");
        Integer limit = MapUtils.getInteger(params, "limit");
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = -1;
        }
        Page<Lawyer> pages = new Page<>(page, limit);
        List<Lawyer> list  =  baseMapper.findList(pages, params);
        return PageResult.<Lawyer>builder().data(list).code(0).count(pages.getTotal()).build();
    }

    @Override
    public Lawyer selectByUsername(String username) {
        List<Lawyer> lawyers =
                baseMapper.selectList( new QueryWrapper<Lawyer>().eq("username", username));
        return getLawyer(lawyers);
    }

    @Override
    public Lawyer selectByMobile(String mobile) {
        List<Lawyer> lawyers =
                baseMapper.selectList( new QueryWrapper<Lawyer>().eq("mobile", mobile));
        return getLawyer(lawyers);
    }


    private Lawyer getLawyer( List<Lawyer> lawyers){
        Lawyer cus = null;
        if(lawyers!=null&&!lawyers.isEmpty()){
          cus =  getUserRolePermission(lawyers.get(0));
        }
        return cus;
    }
    /**
     * 获取用户角色权限数据并返回
     */
    private Lawyer getUserRolePermission(Lawyer lawyer) {
        // TODO: 2019/9/11 0011
        return lawyer;
    }


}
