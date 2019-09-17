package com.zlt.lawyer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.central.common.model.PageResult;
import com.central.common.model.lawyer.LawRole;

import java.util.Map;

/**
 *
 *
 * @author cyq
 * @date 2019-07-16 14:58:10
 */
public interface IRoleService extends IService<LawRole> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<LawRole> findList(Map<String, Object> params);
}

