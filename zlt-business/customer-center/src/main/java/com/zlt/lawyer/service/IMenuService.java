package com.zlt.lawyer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.central.common.model.customer.CusMenu;

import java.util.List;
import java.util.Set;

/**
 *
 *
 * @author cyq
 * @date 2019-07-16 14:58:10
 */
public interface IMenuService extends IService<CusMenu> {


    /**
     * 角色分配菜单
     * @param roleId
     * @param menuIds
     */
    void setMenuToRole(Long roleId, Set<Long> menuIds);

    /**
     * 角色菜单列表
     * @param roleIds 角色ids
     * @return
     */
    List<CusMenu> findByRoles(Set<Long> roleIds);

    /**
     * 角色菜单列表
     * @param roleIds 角色ids
     * @param roleIds 是否菜单
     * @return
     */
    List<CusMenu> findByRoles(Set<Long> roleIds, Integer type);

    /**
     * 角色菜单列表
     * @param roleCodes
     * @return
     */
    List<CusMenu> findByRoleCodes(Set<String> roleCodes, Integer type);
}

