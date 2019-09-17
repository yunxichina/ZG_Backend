package com.zlt.lawyer.mapper;

import com.central.common.model.lawyer.LawRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 *
 * @author cyq
 * @date 2019-07-16 14:58:10
 */
@Mapper
public interface RoleLawyerMapper {

    /**
     * 删除客户角色
     */
    int deleteLawyerRole(@Param("cusId") Long cusId, @Param("roleId") Long roleId);

    @Insert("insert into cus_role_lawyer(cus_id, role_id) values(#{cusId}, #{roleId})")
    int saveUserRoles(@Param("cusId") Long cusId, @Param("roleId") Long roleId);

    /**
     * 根据用户id获取角色
     *
     * @param cusId
     * @return
     */
    @Select("select r.* from cus_role_lawyer ru inner join cus_role r on r.id = ru.role_id where ru.cus_id = #{cusId}")
    List<LawRole> findRolesByCusId(Long cusId);

    /**
     * 根据用户ids 获取
     *
     * @param cusIds
     * @return
     */
    @Select("<script>select r.*,ru.user_id from cus_role_lawyer ru inner join cus_role r on r.id = ru.role_id where ru.cus_id IN " +
            " <foreach item='item' index='index' collection='list' open='(' separator=',' close=')'> " +
            " #{item} " +
            " </foreach>" +
            "</script>")
    List<LawRole> findRolesBycusIds(List<Long> cusIds);

}
