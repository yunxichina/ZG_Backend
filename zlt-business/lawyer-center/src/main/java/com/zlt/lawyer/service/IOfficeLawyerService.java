package com.zlt.lawyer.service;

import com.zlt.lawyer.model.OfficeLawyer;
import com.central.common.model.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 *
 *
 * @author cyq
 * @date 2019-07-18 18:01:50
 */
public interface IOfficeLawyerService extends IService<OfficeLawyer> {
    /**
     * 列表
     * @param params
     * @return
     */
    PageResult<OfficeLawyer> findList(Map<String, Object> params);

    int setOffice (OfficeLawyer officeLawyer);
}

