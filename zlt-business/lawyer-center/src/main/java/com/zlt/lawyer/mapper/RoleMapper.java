package com.zlt.lawyer.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.model.lawyer.LawRole;
import com.central.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author cyq
 * @date 2019-07-16 14:58:10
 */
@Mapper
public interface RoleMapper extends SuperMapper<LawRole> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<LawRole> findList(Page<LawRole> page, @Param("p") Map<String, Object> params);
}
