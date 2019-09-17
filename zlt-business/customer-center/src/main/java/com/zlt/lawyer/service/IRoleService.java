package com.zlt.lawyer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.central.common.model.PageResult;
import com.central.common.model.customer.CusRole;

import java.util.Map;

/**
 *
 *
 * @author cyq
 * @date 2019-07-16 14:58:10
 */
public interface IRoleService extends IService<CusRole> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<CusRole> findList(Map<String, Object> params);
}

