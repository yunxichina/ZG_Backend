package com.zlt.lawyer.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.central.common.model.PageResult;
import com.zlt.lawyer.mapper.OfficeMapper;
import com.zlt.lawyer.model.Office;
import com.zlt.lawyer.service.IOfficeService;
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
public class OfficeServiceImpl extends ServiceImpl<OfficeMapper, Office> implements IOfficeService {
    /**
     * 列表
     * @param params
     * @return
     */
    public PageResult<Office> findList(Map<String, Object> params){
        Integer page = MapUtils.getInteger(params, "page");
        Integer limit = MapUtils.getInteger(params, "limit");
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = 10;
        }
        Page<Office> pages = new Page<>(page, limit);
        List<Office> list  =  baseMapper.findList(pages, params);
        return PageResult.<Office>builder().data(list).code(0).count(pages.getTotal()).build();
    }
}
