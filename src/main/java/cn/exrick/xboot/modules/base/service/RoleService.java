package cn.exrick.xboot.modules.base.service;


import cn.exrick.xboot.base.BaseService;
import cn.exrick.xboot.modules.base.entity.Role;

import java.util.List;

/**
 * 角色接口
 *
 * @author Exrickx
 */
public interface RoleService extends BaseService<Role, String> {

    /**
     * 获取默认角色
     *
     * @param defaultRole
     * @return
     */
    List<Role> findByDefaultRole(Boolean defaultRole);
}
