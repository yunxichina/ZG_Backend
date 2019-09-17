package com.zlt.lawyer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.central.common.model.PageResult;
import com.central.common.model.lawyer.Lawyer;

import java.util.Map;

/**
 *
 *
 * @author zlt
 * @date 2019-07-02 17:21:03
 */
public interface ILawyerService extends IService<Lawyer> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<Lawyer> findList(Map<String, Object> params);

    /**
     * 根据用户名查询用户信息
     */
    Lawyer selectByUsername(String username);



    /**
     * 根据手机号查询用户信息
     */
    Lawyer selectByMobile(String mobile);
}

