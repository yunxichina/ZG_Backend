package com.zlt.lawyer.mapper;

import com.zlt.lawyer.model.Org;
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
public interface OrgMapper extends SuperMapper<Org> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<Org> findList(Page<Org> page, @Param("p") Map<String, Object> params);
}
