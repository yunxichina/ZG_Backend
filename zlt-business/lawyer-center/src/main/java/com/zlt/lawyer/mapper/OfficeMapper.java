package com.zlt.lawyer.mapper;

import com.zlt.lawyer.model.Office;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author cyq
 * @date 2019-07-18 12:03:08
 */
@Mapper
public interface OfficeMapper extends SuperMapper<Office> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<Office> findList(Page<Office> page, @Param("p") Map<String, Object> params);
}
