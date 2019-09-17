package com.zlt.lawyer.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.central.common.model.lawyer.LawMenu;
import com.zlt.lawyer.mapper.MenuMapper;
import com.zlt.lawyer.mapper.RoleMenuMapper;
import com.zlt.lawyer.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 *
 *
 * @author cyq
 * @date 2019-07-16 14:58:10
 */
@Slf4j
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, LawMenu> implements IMenuService {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void setMenuToRole(Long roleId, Set<Long> menuIds) {
        roleMenuMapper.delete(roleId, null);

        if (!CollectionUtils.isEmpty(menuIds)) {
            menuIds.forEach(menuId -> roleMenuMapper.save(roleId, menuId));
        }
    }

    /**
     * 角色菜单列表
     * @param roleIds
     * @return
     */
    @Override
    public List<LawMenu> findByRoles(Set<Long> roleIds) {
        return roleMenuMapper.findMenusByRoleIds(roleIds, null);
    }

    /**
     * 角色菜单列表
     * @param roleIds 角色ids
     * @param roleIds 是否菜单
     * @return
     */
    @Override
    public List<LawMenu> findByRoles(Set<Long> roleIds, Integer type) {
        return roleMenuMapper.findMenusByRoleIds(roleIds, type);
    }

    @Override
    public List<LawMenu> findByRoleCodes(Set<String> roleCodes, Integer type) {
        return roleMenuMapper.findMenusByRoleCodes(roleCodes, type);
    }



}
