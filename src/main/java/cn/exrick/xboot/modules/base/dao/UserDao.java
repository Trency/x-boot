package cn.exrick.xboot.modules.base.dao;

import cn.exrick.xboot.base.BaseDao;
import cn.exrick.xboot.modules.base.entity.User;

import java.util.List;

/**
 * 用户数据处理层
 *
 * @author Exrickx
 */
public interface UserDao extends BaseDao<User, String> {

    /**
     * 通过用户名获取用户
     *
     * @param username
     * @return
     */
    List<User> findByUsername(String username);

    /**
     * 通过手机获取用户
     *
     * @param mobile
     * @return
     */
    List<User> findByMobile(String mobile);

    /**
     * 通过邮件获取用户
     *
     * @param email
     * @return
     */
    List<User> findByEmail(String email);

    /**
     * 通过部门id获取
     *
     * @param departmentId
     * @return
     */
    List<User> findByDepartmentId(String departmentId);
}
