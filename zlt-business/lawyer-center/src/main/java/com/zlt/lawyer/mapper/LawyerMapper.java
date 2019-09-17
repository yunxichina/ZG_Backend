package com.zlt.lawyer.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.model.lawyer.Lawyer;
import com.central.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author zlt
 * @date 2019-07-02 17:21:03
 */
@Mapper
public interface LawyerMapper extends SuperMapper<Lawyer> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<Lawyer> findList(Page<Lawyer> page, @Param("p") Map<String, Object> params);
}
