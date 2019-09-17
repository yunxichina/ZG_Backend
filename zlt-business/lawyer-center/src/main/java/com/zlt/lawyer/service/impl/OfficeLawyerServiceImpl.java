package com.zlt.lawyer.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlt.lawyer.mapper.OfficeLawyerMapper;
import com.zlt.lawyer.model.OfficeLawyer;
import com.zlt.lawyer.service.IOfficeLawyerService;
import org.springframework.stereotype.Service;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MapUtils;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;


/**
 *
 *
 * @author cyq
 * @date 2019-07-18 18:01:50
 */
@Slf4j
@Service
public class OfficeLawyerServiceImpl extends ServiceImpl<OfficeLawyerMapper, OfficeLawyer> implements IOfficeLawyerService {

    @Resource
    private OfficeLawyerMapper orgLawyerMapper;

    /**
     * 列表
     * @param params
     * @return
     */
    public PageResult<OfficeLawyer> findList(Map<String, Object> params){
        Integer page = MapUtils.getInteger(params, "page");
        Integer limit = MapUtils.getInteger(params, "limit");
        if (page == null) {
            page = 1;
        }
        if (limit == null) {
            limit = -1;
        }
        Page<OfficeLawyer> pages = new Page<>(page, limit);
        List<OfficeLawyer> list  =  baseMapper.findList(pages, params);
        return PageResult.<OfficeLawyer>builder().data(list).code(0).count(pages.getTotal()).build();
    }

    @Override
    public int setOffice(OfficeLawyer officeLawyer) {

        //根据客户信息查询该客户是否拥有组织架构
     //   baseMapper.selectObjs(officeLawyer.)

        OfficeLawyer info = orgLawyerMapper.selectOne(new QueryWrapper<OfficeLawyer>().eq("cus_id", officeLawyer.getCusId()));
        if(null!=info){
            //存在则更新值
            orgLawyerMapper.update(info,new QueryWrapper<OfficeLawyer>().eq("cus_id",info.getCusId()));
        }else {
            //插入值
            orgLawyerMapper.insert(officeLawyer);
        }



        return 0;
    }
}
