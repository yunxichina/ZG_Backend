package com.zlt.lawyer.service;

import com.zlt.lawyer.model.Office;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 *
 *
 * @author cyq
 * @date 2019-07-18 12:03:08
 */
public interface IOfficeService extends IService<Office> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<Office> findList(Map<String, Object> params);
}

