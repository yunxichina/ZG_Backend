package com.zlt.lawyer.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.central.common.model.customer.Customer;
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
public interface CustomerMapper extends SuperMapper<Customer> {
    /**
     * 分页查询用户列表
     * @param page
     * @param params
     * @return
     */
    List<Customer> findList(Page<Customer> page, @Param("p") Map<String, Object> params);
}
