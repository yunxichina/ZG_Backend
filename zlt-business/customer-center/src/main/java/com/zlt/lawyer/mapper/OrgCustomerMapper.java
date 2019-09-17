package com.zlt.lawyer.mapper;

import com.zlt.lawyer.model.OrgCustomer;
import com.central.db.mapper.SuperMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author cyq
 * @date 2019-07-18 18:01:50
 */
@Mapper
public interface OrgCustomerMapper extends SuperMapper<OrgCustomer> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<OrgCustomer> findList(Page<OrgCustomer> page, @Param("p") Map<String, Object> params);
}
