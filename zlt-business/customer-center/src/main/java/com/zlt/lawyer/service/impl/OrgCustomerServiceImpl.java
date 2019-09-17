package com.zlt.lawyer.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlt.lawyer.mapper.OrgCustomerMapper;
import com.zlt.lawyer.service.IOrgCustomerService;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import com.zlt.lawyer.model.OrgCustomer;

import javax.annotation.Resource;


/**
 *
 *
 * @author cyq
 * @date 2019-07-18 18:01:50
 */
@Slf4j
@Service
public class OrgCustomerServiceImpl extends ServiceImpl<OrgCustomerMapper, OrgCustomer> implements IOrgCustomerService {

    @Resource
    private OrgCustomerMapper orgCustomerMapper;

    /**
     * 列表
     * @param params
     * @return
     */
    public PageResult<OrgCustomer> findList(Map<String, Object> params){
        Integer page = MapUtils.getInteger(params, "page");
        Integer limit = MapUtils.getInteger(params, "limit");
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = -1;
        }
        Page<OrgCustomer> pages = new Page<>(page, limit);
        List<OrgCustomer> list  =  baseMapper.findList(pages, params);
        return PageResult.<OrgCustomer>builder().data(list).code(0).count(pages.getTotal()).build();
    }

    @Override
    public int setOrg(OrgCustomer orgCustomer) {

        //根据客户信息查询该客户是否拥有组织架构
     //   baseMapper.selectObjs(orgCustomer.)

        OrgCustomer info = orgCustomerMapper.selectOne(new QueryWrapper<OrgCustomer>().eq("cus_id", orgCustomer.getCusId()));
        if(null!=info){
            //存在则更新值
            orgCustomerMapper.update(info,new QueryWrapper<OrgCustomer>().eq("cus_id",info.getCusId()));
        }else {
            //插入值
            orgCustomerMapper.insert(orgCustomer);
        }



        return 0;
    }
}
