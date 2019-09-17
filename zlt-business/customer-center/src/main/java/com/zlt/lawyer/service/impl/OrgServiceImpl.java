package com.zlt.lawyer.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.central.common.model.PageResult;
import com.zlt.lawyer.mapper.OrgMapper;
import com.zlt.lawyer.model.Org;
import com.zlt.lawyer.service.IOrgService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author cyq
 * @date 2019-07-18 12:03:08
 */
@Slf4j
@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements IOrgService {
    /**
     * 列表
     * @param params
     * @return
     */
    public PageResult<Org> findList(Map<String, Object> params){
        Integer page = MapUtils.getInteger(params, "page");
        Integer limit = MapUtils.getInteger(params, "limit");
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 10;
        }
        Page<Org> pages = new Page<>(page, limit);
        List<Org> list  =  baseMapper.findList(pages, params);
        return PageResult.<Org>builder().data(list).code(0).count(pages.getTotal()).build();
    }
}
