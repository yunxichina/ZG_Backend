package com.zlt.lawyer.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.central.common.model.customer.CusRole;
import com.central.common.model.PageResult;
import com.zlt.lawyer.mapper.RoleMapper;
import com.zlt.lawyer.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author cyq
 * @date 2019-07-16 14:58:10
 */
@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, CusRole> implements IRoleService {
    /**
     * 列表
     * @param params
     * @return
     */
    public PageResult<CusRole> findList(Map<String, Object> params){
        Integer page = MapUtils.getInteger(params, "page");
        Integer limit = MapUtils.getInteger(params, "limit");
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = -1;
        }
        Page<CusRole> pages = new Page<>(page, limit);
        List<CusRole> list  =  baseMapper.findList(pages, params);
        return PageResult.<CusRole>builder().data(list).code(0).count(pages.getTotal()).build();
    }
}
