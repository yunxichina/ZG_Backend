package com.zlt.lawyer.service;

import com.zlt.lawyer.model.OrgCustomer;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 *
 *
 * @author cyq
 * @date 2019-07-18 18:01:50
 */
public interface IOrgCustomerService extends IService<OrgCustomer> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<OrgCustomer> findList(Map<String, Object> params);

    int setOrg (OrgCustomer orgCustomer);
}

